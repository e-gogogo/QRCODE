package domain;

public class SaleInfo
{
	private Integer Sid;
	private String Mname;
	private String Cname;
	private String Pname;
	private int Snum;
	private String Ssum;
	public Integer getSid()
	{
		return Sid;
	}
	
	public String getMname()
	{
		return Mname;
	}

	public void setMname(String mname)
	{
		Mname = mname;
	}

	public void setSid(int sid)
	{
		Sid = sid;
	}
	public String getCname()
	{
		return Cname;
	}
	public void setCname(String cname)
	{
		Cname = cname;
	}
	public String getPname()
	{
		return Pname;
	}
	public void setPname(String pname)
	{
		Pname = pname;
	}
	public int getSnum()
	{
		return Snum;
	}
	public void setSnum(int snum)
	{
		Snum = snum;
	}
	public String getSsum()
	{
		return Ssum;
	}
	public void setPsum(String ssum)
	{
		Ssum = ssum;
	}
	@Override
	public String toString()
	{
		return "SaleInfo [Sid=" + Sid + ", Mname=" + Mname + ", Cname=" + Cname + ", Pname=" + Pname + ", Snum=" + Snum
				+ ", Ssum=" + Ssum + "]";
	} 
	
	//
	
}
