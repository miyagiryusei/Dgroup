package ja.co.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AccountForm {

	@NotBlank
	@Pattern(regexp = "^[0-9a-zA-Z_]*$")
	private String loginId;
	@NotBlank
	private String pass;
	@NotBlank
	private String userName;

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}



}
