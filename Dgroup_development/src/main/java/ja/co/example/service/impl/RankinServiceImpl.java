package ja.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ja.co.example.dao.RankingDao;
import ja.co.example.entity.Ranking;
import ja.co.example.service.RankingService;

@Service
public class RankinServiceImpl implements RankingService {

	@Autowired
	private RankingDao rankingDao;

	//全権取得
	public List<Ranking> getAll(){
		return rankingDao.getAll();
	}

	//所持コインランキング(全)
	public List<Ranking> getOverallRanking(){
		return rankingDao.getOverallRanking();
	}

	//所持コインランキング(個人)
	public List<Ranking> getPersonalRanking(String userName){
		return rankingDao.getPersonalRanking(userName);
	}

	//ブラックジャックSUM(全)
	public List<Ranking> getOverallBjSum(){
		return rankingDao.getOverallBjSum();
	}

	//ブラックジャックSUM(個)
	public List<Ranking> getPersonalBjSum(String userName){
		return rankingDao.getPersonalBjSum(userName);
	}

	//ポーカーSUM(全)
	public List<Ranking> getOverallPokerSum(){
		return rankingDao.getOverallPokerSum();
	}

	//ポーカーSUM（個）
	public List<Ranking> getPersonalPokerSum(String userName){
		return rankingDao.getPersonalPokerSum(userName);
	}

	//ポーカー役(全)
	public List<Ranking> getOverallPokerRoleRanking(){
		return rankingDao.getOverallPokerRoleRanking();
	}

	//ポーカー役(個)
	public List<Ranking> getPersonalPokerRoleRanking(String userName){
		return rankingDao.getPersonalPokerRoleRanking(userName);
	}

	//ポーカー１試合の最高スコアランキング(全)
	public List<Ranking> getOverallPokerOneTimeMaxScore(){
		return rankingDao.getOverallPokerOneTimeMaxScore();
	}

	//ポーカー１試合の最高スコアランキング(個)
	public List<Ranking> getPersonalPokerOneTimeMaxScore(String userName){
		return rankingDao.getPersonalPokerOneTimeMaxScore(userName);
	}

	//ポーカー役カウント(全)
	public List<Ranking> getOverallPokerRoleCount(){
		return rankingDao.getOverallPokerRoleCount();
	}

	//ポーカー役カウント(個)
	public List<Ranking> getPersonalPokerRoleCount(String userName){
		return rankingDao.getPersonalPokerRoleCount(userName);
	}

	//ポーカー合計試合数カウント(全)
	public List<Ranking> getOverallPokerSumMatch(){
		return rankingDao.getOverallPokerSumMatch();
	}

	//ブラックジャック合計試合数カウント(全)
	public List<Ranking> getOverallBjSumMatch(){
		return rankingDao.getOverallBjSumMatch();
	}

	//全体試合数カウント
	public List<Ranking> getSumMatch(){
		return rankingDao.getSumMatch();
	}

}
