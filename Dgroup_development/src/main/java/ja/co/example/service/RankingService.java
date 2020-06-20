package ja.co.example.service;

import java.util.List;

import ja.co.example.entity.Ranking;

public interface RankingService {

	//全権取得
	public List<Ranking> getAll();

	//所持コインランキング(全)
	public List<Ranking> getOverallRanking();

	//所持コインランキング(個人)
	public List<Ranking> getPersonalRanking(String userName);

	//ブラックジャックSUM(全)
	public List<Ranking> getOverallBjSum();

	//ブラックジャックSUM(個)
	public List<Ranking> getPersonalBjSum(String userName);

	//ポーカーSUM(全)
	public List<Ranking> getOverallPokerSum();

	//ポーカーSUM（個）
	public List<Ranking> getPersonalPokerSum(String userName);

	//ポーカー役(全)
	public List<Ranking> getOverallPokerRoleRanking();

	//ポーカー役(個)
	public List<Ranking> getPersonalPokerRoleRanking(String userName);

	//ポーカー１試合の最高スコアランキング(全)
	public List<Ranking> getOverallPokerOneTimeMaxScore();

	//ポーカー１試合の最高スコアランキング(個)
	public List<Ranking> getPersonalPokerOneTimeMaxScore(String userName);

	//ポーカー役カウント(全)
	public List<Ranking> getOverallPokerRoleCount();

	//ポーカー役カウント(個)
	public List<Ranking> getPersonalPokerRoleCount(String userName);

	//ポーカー合計試合数カウント(全)
	public List<Ranking> getOverallPokerSumMatch();

	//ブラックジャック合計試合数カウント(全)
	public List<Ranking> getOverallBjSumMatch();

	//全体試合数カウント
	public List<Ranking> getSumMatch();

}
