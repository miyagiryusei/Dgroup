package ja.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ja.co.example.dao.UsersDao;
import ja.co.example.entity.Users;

@Repository
@Transactional
public class PgUsersDao implements UsersDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String SELECT_BY_LOGIN_ID_AND_PASS = "SELECT * ,rank_name FROM users join rank on users.rank_id=rank.rank_id WHERE login_id = :loginId AND pass = :pass";
	private static final String UPDATE_RANK_BY_LOGIN_ID = "update users set rank_id=(select max(rank_id) from rank where rank_area < (select sum(case when coin < 0 then 0 else coin end ) from result where user_id=:userId))where user_id=:userId and rank_id!=100 and (select sum(case when coin < 0 then 0 else coin end )from result where user_id=:userId) != 0";
	private static final String UPDATE_FAILED = "update users set rank_id=100 where user_id=:userId";
	private static final String UPDATE_COIN_ITEM = "update users set coin=1000 where user_id=:userId";

	//ログイン
	@Override
	public Users findByLoginIdAndPassword(String loginId, String pass) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		param.addValue("pass", pass);

		List<Users> resultList = jdbcTemplate.query(SELECT_BY_LOGIN_ID_AND_PASS, param,
				new BeanPropertyRowMapper<Users>(Users.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	//ランク更新（ゲーム終了時に呼ぶ）
	@Override
	public void rank(Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		jdbcTemplate.update(UPDATE_RANK_BY_LOGIN_ID, param);

	}

	//ランク更新（所持コインマイナス時）
	@Override
	public void rankFailed(Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		jdbcTemplate.update(UPDATE_FAILED, param);

	}

	//ユーザーコイン更新（自己破産使用時）
		@Override
		public void coinUpdateItem(Integer userId,Integer itemId) {
			String sql2 ="update item_list set item_count=item_count-1 " +
					"where user_id=:userId and item_id =:itemId";

			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("userId", userId);
			param.addValue("itemId", itemId);

			jdbcTemplate.update(UPDATE_COIN_ITEM, param);
			jdbcTemplate.update(sql2, param);

		}



}
