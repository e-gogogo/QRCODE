package domain;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CustomerForgetPassword {
	@NotEmpty(message="邮箱不能为空")
	@Email
	private String Cmail;
	
	@NotEmpty(message="验证码不能为空")
	private String VerificationCode;

	public String getCmail() {
		return Cmail;
	}

	public void setCmail(String cmail) {
		Cmail = cmail;
	}

	public String getVerificationCode() {
		return VerificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		VerificationCode = verificationCode;
	}

	public CustomerForgetPassword(String cmail, String verificationCode) {
		super();
		Cmail = cmail;
		VerificationCode = verificationCode;
	}

	public CustomerForgetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerForgetPassword [Cmail=" + Cmail + ", VerificationCode=" + VerificationCode + "]";
	}
	
	
}
