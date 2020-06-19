package ja.co.example.dao;

import ja.co.example.entity.Ranking;
import ja.co.example.entity.Users;

public interface GameResultDao {
	public void pokerResultInsert(Ranking result,Integer betCoin);
	public void jackResultInsert(Ranking result,Integer betCoin);
	public void userGetCoin(Users user);
	Ranking getCoin(Integer userId);
	Ranking pokerRoleName(Integer roleId);
	void userBetCoin(Integer betCoin,Integer userId);

}
