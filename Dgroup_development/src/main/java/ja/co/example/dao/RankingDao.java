package ja.co.example.dao;

import java.util.List;

import ja.co.example.entity.Ranking;

public interface RankingDao {

	public List<Ranking> getAll();

	public List<Ranking> getOverallRanking();

	public List<Ranking> getOverallSumBj();

	public List<Ranking> getOverallSumPoker();

	public List<Ranking> getOverallPokerRole();

	public List<Ranking> getOverallPokerOntimeScore();

	public List<Ranking> getPokerCountPersonal(String userName);

	public List<Ranking> getPersonalRanking(String userName);

	public List<Ranking> getPersonalSumBj(String userName);

	public List<Ranking> getPersonalSumPoker(String userName);

	public List<Ranking> getPersonalPokerOntimeScore(String userName);

}
