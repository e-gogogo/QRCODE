package domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
public class CustomerLogin {
	@NotNull(message="username cannot be null")
	@Length(min=1,max=20,message="Length : {min} ~{max}")
	private String Cname;
	
	@NotNull(message="password cannot be null")
	@Length(min=4,max=10,message="Length : {min} ~{max}")
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
