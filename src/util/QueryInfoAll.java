package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import domain.SaleInfo;
import util.JDBCUtils;

public class QueryInfoAll
{
	//initialization
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	//����
	private String Mname = "����";
	private int Mlevel;
	private int Miid;
	private int Mid;
	public List<SaleInfo> infoAll = new ArrayList<SaleInfo>();
	
	//getter and setter
	public String getMname()
	{
		return Mname;
	}
	public void setMname(String mname)
	{
		Mname = mname;
	}
	
	//methods
	private void searchAllByName(String mname) 
	{
		//���Ҿ���id������id��level
        
         searchManagerByName(mname);
         //System.out.println(Mid);
         
         searchLowerList(Miid,Mlevel);
	}
	
	//���Ҿ���id,����id������
	private void searchManagerByName(String Mname)
	{
		// ����sql
        String sql = "select Mid,Miid,Level from manager where Mname =?";
        // ִ��sql
        Map<String, Object> map = template.queryForMap(sql,Mname);
        //System.out.println(map);
        //��ֵ
        this.Mid = (int) map.get("Mid");
        //System.out.println(this.Mid);
        this.Miid = (int) map.get("Miid");
        //System.out.println(this.Miid);
        this.Mlevel =  (int) map.get("Level");
        //System.out.println(this.Mlevel);        
	}
	
	private List<SaleInfo> searchLowerList(int Miid,int Mlevel) 
	{
		String sql ="SELECT Mname FROM manager WHERE (Miid=?) AND (Level <=?)";
		List<Map<String, Object>> list = template.queryForList(sql,Miid,Mlevel);
		//System.out.println(list);
		for (Map<String, Object> stringObjectMap : list) 
		{
			String lowerName= stringObjectMap.values().iterator().next().toString();
			//System.out.println(lowerName);
			infoAll.addAll(new QueryInfo().getListByName(lowerName));			
		}
		//System.out.println(infoAll);
		return infoAll;
	}
	
	public List<SaleInfo> getListByName(String name)
	{
		this.setMname(name);
		this.searchAllByName(Mname);
		return this.infoAll;
	}
	public static void main(String[] args)
	{
		//QueryInfoAll queryInfoAll = new QueryInfoAll();
		//queryInfoAll.getListByName("����");
		System.out.println(new QueryInfoAll().getListByName("����"));
	}

}
