package domain;

public class Customer {
	private int Cid;
	private String Cname;
	private String Cpw;
	private String Cmail;
	
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCpw() {
		return Cpw;
	}
	public void setCpw(String cpw) {
		Cpw = cpw;
	}
	public String getCmail() {
		return Cmail;
	}
	public void setCmail(String cmail) {
		Cmail = cmail;
	}
	public Customer(int cid, String cname, String cpw, String cmail) {
		super();
		Cid = cid;
		Cname = cname;
		Cpw = cpw;
		Cmail = cmail;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [Cid=" + Cid + ", Cname=" + Cname + ", Cpw=" + Cpw + ", Cmail=" + Cmail + "]";
	}
	
	
}
