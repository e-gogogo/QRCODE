package domain;

public class Manager {
	private int Mid;
	private String Mname;
	private int Miid;
	private String Mpw;
	private String Mtel;
	private int Level;
	public int getMid() {
		return Mid;
	}
	public void setMid(int mid) {
		Mid = mid;
	}
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
	}
	public int getMiid() {
		return Miid;
	}
	public void setMiid(int miid) {
		Miid = miid;
	}
	public String getMpw() {
		return Mpw;
	}
	public void setMpw(String mpw) {
		Mpw = mpw;
	}
	public String getMtel() {
		return Mtel;
	}
	public void setMtel(String mtel) {
		Mtel = mtel;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public Manager(int mid, String mname, int miid, String mpw, String mtel, int level) {
		super();
		Mid = mid;
		Mname = mname;
		Miid = miid;
		Mpw = mpw;
		Mtel = mtel;
		Level = level;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Manager [Mid=" + Mid + ", Mname=" + Mname + ", Miid=" + Miid + ", Mpw=" + Mpw + ", Mtel=" + Mtel
				+ ", Level=" + Level + "]";
	}
	
}
