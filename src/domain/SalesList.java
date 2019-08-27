package domain;

public class SalesList {
	private String Sid;
	private String Smid;
	private String Scid;
	private String Spid;
	private String Snum;
	private String Ssum;
	
	public String getSid()
	{
		return Sid;
	}
	public void setSid(String sid)
	{
		Sid = sid;
	}
	public String getSmid()
	{
		return Smid;
	}
	public void setSmid(String smid)
	{
		Smid = smid;
	}
	public String getScid()
	{
		return Scid;
	}
	public void setScid(String scid)
	{
		Scid = scid;
	}
	public String getSpid()
	{
		return Spid;
	}
	public void setSpid(String spid)
	{
		Spid = spid;
	}
	public String getSnum()
	{
		return Snum;
	}
	public void setSnum(String snum)
	{
		Snum = snum;
	}
	public String getSsum()
	{
		return Ssum;
	}
	public void setSsum(String ssum)
	{
		Ssum = ssum;
	}
	//
	@Override
	public String toString()
	{
		return "SalesList [Sid=" + Sid + ", Smid=" + Smid + ", Scid=" + Scid + ", Spid=" + Spid + ", Snum=" + Snum
				+ ", Ssum=" + Ssum + "]";
	}
	
	
}