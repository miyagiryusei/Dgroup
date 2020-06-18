package ja.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ja.co.example.dao.RankingDao;
import ja.co.example.entity.Ranking;
import ja.co.example.service.RankingService;

@Service
public class RankinServiceImpl implements RankingService{

	@Autowired
	private RankingDao rankingDao;

	public List<Ranking> getAll(){
		return rankingDao.getAll();
	}

	public List<Ranking> getOverallRanking(){
		return rankingDao.getOverallRanking();
	}

	public List<Ranking> getOverallSumBj(){
		return rankingDao.getOverallSumBj();
	}

	public List<Ranking> getOverallSumPoker(){
		return rankingDao.getOverallSumPoker();
	}

	public List<Ranking> getOverallPokerRole(){
		return rankingDao.getOverallPokerRole();
	}

	public List<Ranking> getOverallPokerOntimeScore(){
		return rankingDao.getOverallPokerOntimeScore();
	}

	public List<Ranking> getPokerCountPersonal(String userName){
		return rankingDao.getPokerCountPersonal(userName);
	}

	public List<Ranking> getPersonalRanking(String userName){
		return rankingDao.getPersonalRanking(userName);
	}

	public List<Ranking> getPersonalSumBj(String userName){
		return rankingDao.getPersonalSumBj(userName);
	}

	public List<Ranking> getPersonalSumPoker(String userName){
		return rankingDao.getPersonalSumPoker(userName);
	}

	public List<Ranking> getPersonalPokerOntimeScore(String userName){
		return rankingDao.getPersonalPokerOntimeScore(userName);
	}

}
