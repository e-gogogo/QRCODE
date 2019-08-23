package domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ManagerLogin {
	
	
	private int Mid;
	
	@NotEmpty(message="密码不能为空")
	@Length(min=0,max=10,message="密码长度超出限制")
	private String Mpw;

	public int getMid() {
		return Mid;
	}

	public void setMid(int mid) {
		Mid = mid;
	}

	public String getMpw() {
		return Mpw;
	}

	public void setMpw(String mpw) {
		Mpw = mpw;
	}

	public ManagerLogin(int mid, String mpw) {
		super();
		Mid = mid;
		Mpw = mpw;
	}

	public ManagerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
