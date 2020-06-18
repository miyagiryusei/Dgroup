package ja.co.example.entity;

import java.sql.Date;

public class Ranking {

	//usersテーブル
	private Integer userId;

	private String userName;

	private Integer userCoin;

	private Integer rankId;

	private Date insertTime;

	private Integer userStatus;


	//resultテーブル
	private Integer resultId;

	private Integer resultCoin;

	private Integer divisionId;

	private Integer pokerRoleId;


	//division_idテーブル
	private String divisionName;


	//rankテーブル
	private String rankName;

	private Integer rankArea;


	//poker_roleテーブル
	private String pokerRoleName;

	private Integer pokerRoleCoin;


	//エイリアス
	private Integer rank;

	private Integer sumBjCoin;

	private Integer sumPokerCoin;

	private Integer difference;

	private Integer maxCoin;


	//usersテーブルアクセッサ
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserCoin() {
		return userCoin;
	}

	public void setUserCoin(Integer userCoin) {
		this.userCoin = userCoin;
	}

	public Integer getRankId() {
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

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}


	//resultアクセッサ
	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public Integer getResultCoin() {
		return resultCoin;
	}

	public void setResultCoin(Integer resultCoin) {
		this.resultCoin = resultCoin;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public Integer getPokerRoleId() {
		return pokerRoleId;
	}

	public void setPokerRoleId(Integer pokerRoleId) {
		this.pokerRoleId = pokerRoleId;
	}


	//divisionアクセッサ
	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}


	//rankアクセッサ
	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public Integer getRankArea() {
		return rankArea;
	}

	public void setRankArea(Integer rankArea) {
		this.rankArea = rankArea;
	}


	//pokerRoleアクセッサ
	public String getPokerRoleName() {
		return pokerRoleName;
	}

	public void setPokerRoleName(String pokerRoleName) {
		this.pokerRoleName = pokerRoleName;
	}

	public Integer getPokerRoleCoin() {
		return pokerRoleCoin;
	}

	public void setPokerRoleCoin(Integer pokerRoleCoin) {
		this.pokerRoleCoin = pokerRoleCoin;
	}


	//エイリアスアクセッサ
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getSumBjCoin() {
		return sumBjCoin;
	}

	public void setSumBjCoin(Integer sumBjCoin) {
		this.sumBjCoin = sumBjCoin;
	}

	public Integer getSumPokerCoin() {
		return sumPokerCoin;
	}

	public void setSumPokerCoin(Integer sumPokerCoin) {
		this.sumPokerCoin = sumPokerCoin;
	}

	public Integer getDifference() {
		return difference;
	}

	public void setDifference(Integer difference) {
		this.difference = difference;
	}

	public Integer getMaxCoin() {
		return maxCoin;
	}

	public void setMaxCoin(Integer maxCoin) {
		this.maxCoin = maxCoin;
	}

}
