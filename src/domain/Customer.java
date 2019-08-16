package domain;

public class Customer {
	private String Cid;
	private String Cname;
	private String Cpw;
	private String Ctel;
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
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
	public String getCtel() {
		return Ctel;
	}
	public void setCtel(String ctel) {
		Ctel = ctel;
	}
	public Customer(String cid, String cname, String cpw, String ctel) {
		super();
		Cid = cid;
		Cname = cname;
		Cpw = cpw;
		Ctel = ctel;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [Cid=" + Cid + ", Cname=" + Cname + ", Cpw=" + Cpw + ", Ctel=" + Ctel + "]";
	}
	
}
