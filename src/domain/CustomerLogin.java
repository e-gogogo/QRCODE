package domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
public class CustomerLogin {
	@NotEmpty(message="用户名不能为空")
	@Length(min=0,max=20,message="用户名长度超出限制")
	private String Cname;
	
	@NotEmpty(message="密码不能为空")
	@Length(min=0,max=10,message="密码长度超出限制")
	private String Cpw;

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

	public CustomerLogin(String cname, String cpw) {
		super();
		Cname = cname;
		Cpw = cpw;
	}

	public CustomerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
