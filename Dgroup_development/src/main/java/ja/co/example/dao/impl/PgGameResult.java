package ja.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ja.co.example.dao.GameResultDao;
import ja.co.example.entity.Ranking;
import ja.co.example.entity.Users;

@Repository
@Transactional
public class PgGameResult implements GameResultDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String POKER_RESULT_INSERT = "insert into result (user_id,coin,division_id,poker_role_id,result_time) values (:userId,:betCoin*(select poker_role_coin from poker_role where poker_role_id=:pokerRoleId),:divisionId,:pokerRoleId,now())";
	private static final String JACK_RESULT_INSERT = "insert into result (user_id,coin,division_id,result_time) values (:userId,:betCoin*3,:divisionId,now())";
	private static final String USER_COIN_UPDATE = "update users set coin= coin+(select coin from result where user_id=:userId order by result_id desc limit 1)where user_id=:userId";
	private static final String USER_BETCOIN = "update users set coin= coin-:betCoin where user_id=:userId";
	private static final String SELECT_RESULT_COIN = "select coin from result where user_id=:userId order by result_id desc limit 1";
	private static final String SELECT_ROLE_NAME = "select poker_role_name from poker_role where poker_role_id =:roleId";

	//ゲーム結果登録(ポーカー）
	@Override
	public void pokerResultInsert(Ranking result, Integer betCoin) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", result.getUserId());
		param.addValue("betCoin", betCoin);
		param.addValue("divisionId", result.getDivisionId());
		param.addValue("pokerRoleId", result.getPokerRoleId());

		jdbcTemplate.update(POKER_RESULT_INSERT, param);
	}

	//ゲーム結果登録（ブラックジャック）
	@Override
	public void jackResultInsert(Ranking result, Integer betCoin) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", result.getUserId());
		param.addValue("betCoin", betCoin);
		param.addValue("divisionId", result.getDivisionId());

		jdbcTemplate.update(JACK_RESULT_INSERT, param);
	}

	//ユーザーのコイン
	@Override
	public void userBetCoin(Integer betCoin,Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("betCoin", betCoin);

		jdbcTemplate.update(USER_BETCOIN, param);

	}

	//ユーザーのコイン更新（ゲーム終了時）
	@Override
	public void userGetCoin(Users user) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", user.getUserId());

		jdbcTemplate.update(USER_COIN_UPDATE, param);

	}

	//獲得コイン取得
	@Override
	public Ranking getCoin(Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_RESULT_COIN, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	//ポーカー役取得
	@Override
	public Ranking pokerRoleName(Integer roleId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("roleId", roleId);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_ROLE_NAME, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

}
