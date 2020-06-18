package ja.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.RankingDao;
import ja.co.example.entity.Ranking;

@Repository
public class PgRankingDao implements RankingDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//ランキング使用範囲を全権取得
	private static final String SELECT_ALL = "select * " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where u.user_status !=2 ";

	//全体ランキング用　（不要なものは破棄します）
	private static final String SELECT_COIN_RAMKING_OVERALL = "select RANK() OVER (ORDER BY u.coin DESC) , u.user_id , u.user_name , "
			+ "u.coin user_coin , u.rank_id ,ra.rank_name, u.insert_time, " +
			"(first_value(u.coin) OVER () - u.coin) as difference " +
			"from users u join rank ra on ra.rank_id = u.rank_id " +
			"where u.user_status !=2 " +
			"FETCH FIRST 50 ROWS ONLY ";

	private static final String SELECT_SUM_BJ_OVERALL = "select  RANK() OVER (ORDER BY sum(r.coin) DESC) , u.user_name , u.rank_id , "
			+ "ra.rank_name, u.insert_time, sum(r.coin) sum_bj_coin , d.division_name , "
			+ "(first_value(sum(r.coin)) OVER () - sum(r.coin)) as difference " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"where d.division_name = 'ブラックジャック' and r.coin is not null and u.user_status !=2 and r.coin > 0 " +
			"group by user_name , d.division_name ,u.rank_id ,ra.rank_name, u.insert_time " +
			"FETCH FIRST 50 ROWS ONLY ";

	private static final String SELECT_SUM_POKER_OVERALL = "select RANK() OVER (ORDER BY sum(r.coin) DESC) , u.user_name , "
			+ "u.rank_id ,ra.rank_name, u.insert_time, sum(r.coin) sum_poker_coin , d.division_name, "
			+ "(first_value(sum(r.coin)) OVER () - sum(r.coin)) as difference " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 and r.coin > 0 " +
			"group by user_name , d.division_name , u.rank_id ,ra.rank_name, u.insert_time " +
			"FETCH FIRST 50 ROWS ONLY ";

	//	private static final String SELECT_MAX_POKER_OVERALL = "select RANK() OVER (ORDER BY max(r.coin) DESC) , u.user_name, u.rank_id , "
	//			+ "ra.rank_name, u.insert_time , max(r.coin) max_coin , d.division_name, "
	//			+ "(first_value(max(r.coin)) OVER () - max(r.coin)) as difference " +
	//			"from users u " +
	//			"join result r on r.user_id = u.user_id " +
	//			"join rank ra on ra.rank_id = u.rank_id " +
	//			"join division d on d.division_id = r.division_id " +
	//			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 " +
	//			"group by user_name , d.division_name , u.rank_id ,ra.rank_name, u.insert_time " +
	//			"FETCH FIRST 50 ROWS ONLY ";

	private static final String SELECT_POKER_ROLE_OVERALL = "select RANK() OVER (ORDER BY p.poker_role_id DESC), p.poker_role_id , "
			+ "u.user_name , u.rank_id ,ra.rank_name, u.insert_time, p.poker_role_name " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 " +
			"FETCH FIRST 50 ROWS ONLY ";

	private static final String SELECT_POKER_ONETIME_SCORE_OVERALL = "select RANK() OVER (ORDER BY r.coin DESC),r.coin, p.poker_role_id ,"
			+ " u.user_name , u.rank_id ,ra.rank_name, u.insert_time, p.poker_role_name " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 and r.coin > 0  " +
			"FETCH FIRST 50 ROWS ONLY ";
	//ランキング用末尾

	//-------------------------------------------------------------------------------------------------------------------------

	//個人用ランキング情報画面（不要なものは破棄します）
	private static final String SELECT_POKER_ROLE_PERSONAL_COUNT = "select RANK() OVER (ORDER BY p.poker_role_id DESC) , "
			+ "u.user_name, u.rank_id ,ra.rank_name, u.insert_time , p.poker_role_name ,count(p.poker_role_id) count " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 and u.user_name = :userName " +
			"group by user_name , p.poker_role_name , p.poker_role_id, u.rank_id ,ra.rank_name, u.insert_time ";

	private static final String SELECT_COIN_RAMKING_PERSONAL = "select RANK() OVER (ORDER BY u.coin DESC) , u.user_id , u.user_name , "
			+ "u.coin user_coin , u.rank_id ,ra.rank_name, u.insert_time, " +
			"(first_value(u.coin) OVER () - u.coin) as difference " +
			"from users u join rank ra on ra.rank_id = u.rank_id " +
			"where u.user_status !=2 and u.user_name = :userName ";

	private static final String SELECT_SUM_BJ_PERSONAL = "select  RANK() OVER (ORDER BY sum(r.coin) DESC) , u.user_name , u.rank_id , "
			+ "ra.rank_name, u.insert_time, sum(r.coin) sum_bj_coin , d.division_name , "
			+ "(first_value(sum(r.coin)) OVER () - sum(r.coin)) as difference " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"where d.division_name = 'ブラックジャック' and r.coin is not null and u.user_status !=2 and u.user_name = :userName and r.coin > 0 "
			+
			"group by user_name , d.division_name ,u.rank_id ,ra.rank_name, u.insert_time ";

	private static final String SELECT_SUM_POKER_PERSONAL = "select RANK() OVER (ORDER BY sum(r.coin) DESC) , u.user_name , "
			+ "u.rank_id ,ra.rank_name, u.insert_time, sum(r.coin) sum_poker_coin , d.division_name, "
			+ "(first_value(sum(r.coin)) OVER () - sum(r.coin)) as difference " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 and u.user_name = :userName and r.coin > 0 "
			+
			"group by user_name , d.division_name , u.rank_id ,ra.rank_name, u.insert_time ";

	//	private static final String SELECT_MAX_POKER_PERSONAL = "select RANK() OVER (ORDER BY max(r.coin) DESC) , u.user_name, u.rank_id , "
	//			+ "ra.rank_name, u.insert_time , max(r.coin) max_coin , d.division_name, "
	//			+ "(first_value(max(r.coin)) OVER () - max(r.coin)) as difference " +
	//			"from users u " +
	//			"join result r on r.user_id = u.user_id " +
	//			"join rank ra on ra.rank_id = u.rank_id " +
	//			"join division d on d.division_id = r.division_id " +
	//			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 and u.user_name = :userName " +
	//			"group by user_name , d.division_name , u.rank_id ,ra.rank_name, u.insert_time " +
	//			"FETCH FIRST 50 ROWS ONLY ";

	//	private static final String SELECT_POKER_ROLE_PERSONAL = "select RANK() OVER (ORDER BY p.poker_role_id DESC), p.poker_role_id , "
	//			+ "u.user_name , u.rank_id ,ra.rank_name, u.insert_time, p.poker_role_name " +
	//			"from users u " +
	//			"join result r on r.user_id = u.user_id " +
	//			"join rank ra on ra.rank_id = u.rank_id " +
	//			"join division d on d.division_id = r.division_id " +
	//			"join poker_role p on p.poker_role_id = r.poker_role_id " +
	//			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 and u.user_name = :userName ";

	private static final String SELECT_POKER_ONETIME_SCORE_PERSONAL = "select RANK() OVER (ORDER BY r.coin DESC),r.coin, p.poker_role_id ,"
			+ " u.user_name , u.rank_id ,ra.rank_name, u.insert_time, p.poker_role_name " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 and u.user_name = :userName "
			+ "FETCH FIRST 1 ROWS ONLY ";
	//個人ランキング用末尾

	//---------------------------------------------------------------------------------------------------------------------

	//（全）
	//全権取得
	public List<Ranking> getAll() {
		List<Ranking> resultList = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//全体ランキング必要カラム取得
	public List<Ranking> getOverallRanking() {
		List<Ranking> resultList = jdbcTemplate.query(SELECT_COIN_RAMKING_OVERALL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//（全）ブラックジャックの合計取得
	public List<Ranking> getOverallSumBj() {
		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM_BJ_OVERALL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//（全）ポーカーの合計取得
	public List<Ranking> getOverallSumPoker() {
		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM_POKER_OVERALL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//	//（全）ポーカー最高取得数
	//	public List<Ranking> getOverallMaxPoker() {
	//		List<Ranking> resultList = jdbcTemplate.query(SELECT_MAX_POKER_OVERALL,
	//				new BeanPropertyRowMapper<Ranking>(Ranking.class));
	//
	//		return resultList;
	//	}

	//（全）ポーカーの役ランク
	public List<Ranking> getOverallPokerRole() {
		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ROLE_OVERALL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//（全）ポーカー１試合の最高取得スコア
	public List<Ranking> getOverallPokerOntimeScore() {
		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ONETIME_SCORE_OVERALL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//-------------------------------------------------------------------------------------------------

	//（個）
	//（個）ポーカー役カウント
	public List<Ranking> getPokerCountPersonal(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ROLE_PERSONAL_COUNT,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//（個）個人ランキング情報取得
	public List<Ranking> getPersonalRanking(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_COIN_RAMKING_PERSONAL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//（個）ブラックジャックの合計取得
	public List<Ranking> getPersonalSumBj(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM_BJ_PERSONAL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//（個）ポーカーの合計取得
	public List<Ranking> getPersonalSumPoker(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM_POKER_PERSONAL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//（個）ポーカー１試合の最高取得スコアかつ役
	public List<Ranking> getPersonalPokerOntimeScore(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ONETIME_SCORE_PERSONAL,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

}
