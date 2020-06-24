package ja.co.example.form;

import javax.validation.constraints.NotBlank;

public class CheckForm {


	private String loginID;

	private String userName;

	@NotBlank
	private String pass;


	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String UserName) {
		this.userName = UserName;
	}

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}



}
