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
	private static final String UPDATE_RANK_BY_LOGIN_ID = "update users set rank_id=(select max(rank_id) from rank where rank_area < (select sum(case when coin < 0 then 0 else coin end ) from result where user_id=:userId))where user_id=:userId";

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

}
