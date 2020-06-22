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
			"where u.user_status !=2 and u.user_name= case when :flg = 1 then :userName else u.user_name end ";

	//所持コインランキング用SQL
	private static final String SELECT_COIN_RAMKING = "select rank , user_name , rank_name , coin , difference , count "
			+
			"from " +
			"( select RANK() OVER (ORDER BY u.coin DESC) rank , u.user_id , u.user_name , u.coin, u.rank_id , "
			+ "ra.rank_name, u.insert_time , count(result_id) count " +
			",(first_value(u.coin) OVER () - u.coin) as difference " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"where u.user_status !=2 " +
			"group by u.user_id , u.user_name , u.coin , u.rank_id ,ra.rank_name, u.insert_time ) ran " +
			"where user_name = case when :flg = 1 then :userName else user_name end " +
			"FETCH FIRST 50 ROWS ONLY ";

	//ブラックジャック OR ポーカー合計
	private static final String SELECT_SUM = "select rank , user_name , rank_name , coin , division_name , difference ,count "
			+
			"from ( select  RANK() OVER (ORDER BY sum(case when r.coin < 0 then 0 else r.coin end) DESC) rank , u.user_name , u.rank_id , ra.rank_name , "
			+ "u.insert_time, sum(case when r.coin < 0 then 0 else r.coin end) coin , d.division_name , "
			+ "(first_value(sum(r.coin)) OVER () - sum(r.coin)) as difference , count(u.user_id) count " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"where d.division_name = :divisionName and r.coin is not null and u.user_status !=2 " +
			"group by user_name , d.division_name ,u.rank_id ,ra.rank_name, u.insert_time ) ran " +
			"where user_name = case when :flg = 1 then :userName else user_name end " +
			"FETCH FIRST 50 ROWS ONLY ";

	//ポーカー役ランキング
	private static final String SELECT_POKER_ROLE = "select rank , user_name , rank_name , poker_role_name " +
			"from( " +
			"select RANK() OVER (ORDER BY p.poker_role_id DESC) rank, p.poker_role_id , u.user_name , u.rank_id ,ra.rank_name, "
			+ "u.insert_time, p.poker_role_name "
			+
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 " +
			") run " +
			"where user_name = case when :flg = 1 then :userName else user_name end ";

	//ポーカー１試合の最高スコア
	private static final String SELECT_POKER_ONETIME_SCORE = "select rank , coin , user_name , rank_name , poker_role_name , difference "
			+
			"from( " +
			"select RANK() OVER (ORDER BY (case when r.coin < 0 then 0 else r.coin end) DESC) rank , "
			+ "case when r.coin < 0 then 0 else r.coin end , p.poker_role_id , u.user_name , u.rank_id ,ra.rank_name, "
			+ "u.insert_time, p.poker_role_name , (first_value (r.coin) OVER () - r.coin) as difference " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 " +
			") ran " +
			"where user_name = case when :flg = 1 then :userName else user_name end " +
			"FETCH FIRST 50 ROWS ONLY ";

	//ポーカー役カウント
	private static final String SELECT_POKER_ROLE_COUNT = "select p.poker_role_name ,count(p.poker_role_id) count " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where d.division_name = 'ポーカー' and r.coin IS NOT NULL and u.user_status !=2 and u.user_name= case when :flg = 1 then "
			+ ":userName else u.user_name end " +
			"group by p.poker_role_name " +
			"order by p.poker_role_name desc " +
			"FETCH FIRST 50 ROWS ONLY ";

	//試合数合計
	private static final String SELECT_SUM_MATCH = "select count(r.result_id) count " +
			"from users u " +
			"join result r on r.user_id = u.user_id " +
			"join rank ra on ra.rank_id = u.rank_id " +
			"join division d on d.division_id = r.division_id " +
			"join poker_role p on p.poker_role_id = r.poker_role_id " +
			"where d.division_name = case when :flg = 1 then :divisionName else d.division_name end and r.coin IS NOT NULL and u.user_status !=2 " +
			"FETCH FIRST 50 ROWS ONLY ";

	//---------------------------------------------------------------------------------------------------------------------

	//全権取得
	public List<Ranking> getAll() {

		List<Ranking> resultList = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//所持コインランキング(全)
	public List<Ranking> getOverallRanking() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 2);
		param.addValue("userName", "user_name");
		List<Ranking> resultList = jdbcTemplate.query(SELECT_COIN_RAMKING, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//所持コインランキング(個人)
	public List<Ranking> getPersonalRanking(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 1);
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_COIN_RAMKING, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ブラックジャックSUM(全)
	public List<Ranking> getOverallBjSum() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("divisionName", "ブラックジャック");
		param.addValue("flg", 2);
		param.addValue("userName", "user_name");

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ブラックジャックSUM(個)
	public List<Ranking> getPersonalBjSum(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("divisionName", "ブラックジャック");
		param.addValue("flg", 1);
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカーSUM(全)
	public List<Ranking> getOverallPokerSum() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("divisionName", "ポーカー");
		param.addValue("flg", 2);
		param.addValue("userName", "user_name");

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカーSUM（個）
	public List<Ranking> getPersonalPokerSum(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("divisionName", "ポーカー");
		param.addValue("flg", 1);
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカー役(全)
	public List<Ranking> getOverallPokerRoleRanking() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 2);
		param.addValue("userName", "user_name");

		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ROLE+"FETCH FIRST 50 ROWS ONLY ", param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカー役(個)
	public List<Ranking> getPersonalPokerRoleRanking(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 1);
		param.addValue("userName", userName);
		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ROLE+"FETCH FIRST 1 ROWS ONLY ", param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカー１試合の最高スコアランキング(全)
	public List<Ranking> getOverallPokerOneTimeMaxScore() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 2);
		param.addValue("userName", "user_name");

		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ONETIME_SCORE, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカー１試合の最高スコアランキング(個)
	public List<Ranking> getPersonalPokerOneTimeMaxScore(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 1);
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ONETIME_SCORE, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカー役カウント(全)
	public List<Ranking> getOverallPokerRoleCount() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 2);
		param.addValue("userName", "user_name");

		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ROLE_COUNT, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカー役カウント(個)
	public List<Ranking> getPersonalPokerRoleCount(String userName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 1);
		param.addValue("userName", userName);

		List<Ranking> resultList = jdbcTemplate.query(SELECT_POKER_ROLE_COUNT, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ポーカー合計試合数カウント(全)
	public List<Ranking> getOverallPokerSumMatch() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 1);
		param.addValue("divisionName", "ポーカー");

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM_MATCH, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//ブラックジャック合計試合数カウント(全)
	public List<Ranking> getOverallBjSumMatch() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 1);
		param.addValue("divisionName", "ブラックジャック");

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM_MATCH, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

	//全体試合数カウント
	public List<Ranking> getSumMatch() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("flg", 2);
		param.addValue("divisionName", "division_name");

		List<Ranking> resultList = jdbcTemplate.query(SELECT_SUM_MATCH, param,
				new BeanPropertyRowMapper<Ranking>(Ranking.class));

		return resultList;
	}

}
