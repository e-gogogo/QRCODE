package util;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import domain.SaleInfo;
import util.JDBCUtils;

public class QueryInfo
{
	
	
	//initialization
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	//声明
	private String Mname = "李四";
	private Integer Mid ;
	//private static QueryInfo queryInfo = new QueryInfo();
	public List<SaleInfo> infolist = new ArrayList<SaleInfo>();
	//ArrayList arraylist = new ArrayList (300);
	
	//getter 和 setter
	public String getMid()
	{
		return Mname;
	}

	public void setMname(String mname)
	{
		Mname = mname;
	}

	
	//查找经理的ID
    private void SearchByName(){
    	
    	//查找经理id
        //2. 定义sql
        String sql = "select Mid from manager where Mname =?";
        //3. 执行sql
        Integer Mid = template.queryForObject(sql, Integer.class, Mname);
        // System.out.println(Mid);
         this.Mid = Mid;
         
         //查找交易id
         sql = "select Sid from sales_list where Smid =?";
         //String sqlcid;
         String sqlCname;
         String sqlPname;
         String sqlSum;
         //int cid;
         String cname;
         String pname;
         Integer snum;
         String ssum;
         //String sql1 = "select scid";
         List<Map<String, Object>> list = template.queryForList(sql,Mid);
         
         for (Map<String, Object> stringObjectMap : list) 
         {
        	 String sidS1 = stringObjectMap.values().toString();
        	 Integer sid = Integer.parseInt(sidS1.substring(1, (sidS1.length()-1)));
             //System.out.println("sid"+sid);
             
             //查找顾客姓名
             
             //sqlcid = "select Scid from sales_list where Sid =?";
             //cid= template.queryForObject(sqlcid, int.class, sid);
             //System.out.println("cid"+cid);
             sqlCname = "SELECT Cname FROM customer WHERE Cid = (SELECT Scid FROM sales_list WHERE Sid =?)";
             cname = template.queryForObject(sqlCname, String.class, sid);
             //System.out.println("cname"+cname);
             
             //查找商品名  
             
             sqlPname = "SELECT Pname FROM product WHERE Pid = (SELECT Spid FROM sales_list WHERE Sid =?)";
             pname = template.queryForObject(sqlPname, String.class, sid);
             //System.out.println("pname"+pname);  
             
             //查找商品数量和总价
             sqlSum = "SELECT Snum,Ssum FROM sales_list WHERE Sid =?";
             Map<String, Object> map = template.queryForMap(sqlSum, sid);
             //System.out.println(map);
             snum = (Integer) map.get("Snum");
             ssum =  map.get("Ssum").toString();
             
             
             //封装
             
             SaleInfo saleInfoa = new SaleInfo();
             saleInfoa.setSid(sid);
             saleInfoa.setMname(Mname);;
             saleInfoa.setCname(cname);
             saleInfoa.setPname(pname);
             saleInfoa.setSnum(snum);
             saleInfoa.setPsum(ssum);
             //System.out.println(saleInfoa.getClass());
             infolist.add(saleInfoa);
         }
         /*
             for (SaleInfo text : infolist) {
	            System.out.println(text);
	        }
         */
    }
    
   public List<SaleInfo> getListByName(String name) 
   {
	   //QueryInfo queryInfo = new QueryInfo();
	   this.setMname(name);
	   this.SearchByName();
	   //System.out.print(infolist);
	   return infolist;
	   
   };
    
    
    
	public static void main(String[] args) {
		//QueryInfo queryInfo = new QueryInfo();
		//queryInfo.setMname("");
		//QueryInfo queryInfo = new QueryInfo();
		//queryInfo.setMname("李四");
		//queryInfo.SearchByName();
		//System.out.println(queryInfo.Mid);
		//new QueryInfo().getListByName("张三");
		System.out.println(new QueryInfo().getListByName("张三"));
		 
	}
}
