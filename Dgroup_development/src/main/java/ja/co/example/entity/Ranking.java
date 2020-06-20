package ja.co.example.entity;

import java.sql.Date;

public class Ranking {
	public Ranking(Integer userId, Integer resultId, Integer divisionId, Integer pokerRoleId) {
		super();
		this.userId = userId;
		this.resultId = resultId;
		this.divisionId = divisionId;
		this.pokerRoleId = pokerRoleId;
	}

	public Ranking() {

	}

	//usersテーブル
	private Integer userId;

	private Integer rankId;

	private Date insertTime;

	private Integer userStatus;

	private Integer coin;

	//resultテーブル
	private Integer resultId;

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

	private Integer sumCoin;

	private Integer difference;

	private Integer maxCoin;

	private Integer count;

	//usersテーブルアクセッサ
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public Integer getSumCoin() {
		return sumCoin;
	}

	public void setSumCoin(Integer sumCoin) {
		this.sumCoin = sumCoin;
	}

}
