package ja.co.example.entity;

import java.sql.Date;

public class Account {

	private Integer userId;
	private String loginId;
	private String userName;
	private String pass;
	private Integer coin;
	private Integer rankId;
	private Date insertTime;

//	public Account(Integer userId ,String loginId,String userName, String pass,Integer coin,Integer rankId,Date insertTime) {
//		this.userId = userId;
//		this.loginId = loginId;
//		this.userName = userName;
//		this.pass = pass;
//		this.coin = coin;
//		this.rankId = rankId;
//		this.insertTime = insertTime;
//	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public int getRankId() {
		return rankId;
	}

	public void setRankId(Integer rankId) {
		this.rankId = rankId;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
}