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
	//����
	private String Mname = "����";
	private Integer Mid ;
	//private static QueryInfo queryInfo = new QueryInfo();
	public List<SaleInfo> infolist = new ArrayList<SaleInfo>();
	//ArrayList arraylist = new ArrayList (300);
	
	//getter �� setter
	public String getMid()
	{
		return Mname;
	}

	public void setMname(String mname)
	{
		Mname = mname;
	}

	
	//���Ҿ����ID
    private void SearchByName(){
    	
    	//���Ҿ���id
        //2. ����sql
        String sql = "select Mid from manager where Mname =?";
        //3. ִ��sql
        Integer Mid = template.queryForObject(sql, Integer.class, Mname);
        // System.out.println(Mid);
         this.Mid = Mid;
         
         //���ҽ���id
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
             
             //���ҹ˿�����
             
             //sqlcid = "select Scid from sales_list where Sid =?";
             //cid= template.queryForObject(sqlcid, int.class, sid);
             //System.out.println("cid"+cid);
             sqlCname = "SELECT Cname FROM customer WHERE Cid = (SELECT Scid FROM sales_list WHERE Sid =?)";
             cname = template.queryForObject(sqlCname, String.class, sid);
             //System.out.println("cname"+cname);
             
             //������Ʒ��  
             
             sqlPname = "SELECT Pname FROM product WHERE Pid = (SELECT Spid FROM sales_list WHERE Sid =?)";
             pname = template.queryForObject(sqlPname, String.class, sid);
             //System.out.println("pname"+pname);  
             
             //������Ʒ�������ܼ�
             sqlSum = "SELECT Snum,Ssum FROM sales_list WHERE Sid =?";
             Map<String, Object> map = template.queryForMap(sqlSum, sid);
             //System.out.println(map);
             snum = (Integer) map.get("Snum");
             ssum =  map.get("Ssum").toString();
             
             
             //��װ
             
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
		//queryInfo.setMname("����");
		//queryInfo.SearchByName();
		//System.out.println(queryInfo.Mid);
		//new QueryInfo().getListByName("����");
		System.out.println(new QueryInfo().getListByName("����"));
		 
	}
}
