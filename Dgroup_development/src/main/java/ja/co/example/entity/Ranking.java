package ja.co.example.entity;

public class Ranking {
	public Ranking(Integer userId, Integer resultId, Integer divisionId, Integer pokerRoleId) {
		super();
		this.userId = userId;
		this.resultId = resultId;
		this.divisionId = divisionId;
		this.pokerRoleId = pokerRoleId;
	}

	public Ranking () {

	}

	//usersテーブル
	private Integer userId;




	//resultテーブル
	private Integer resultId;

	private Integer coin;

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




	//resultアクセッサ
	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
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
