package ja.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.UsersDao;
import ja.co.example.entity.Users;

@Repository
public class PgUsersDao implements UsersDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String SELECT_BY_LOGIN_ID_AND_PASS = "SELECT * FROM users WHERE login_id = :loginId AND pass = :pass";

	@Override
	public Users findByLoginIdAndPassword(String loginId, String pass) {
		MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", loginId);
        param.addValue("pass", pass);

        List<Users> resultList = jdbcTemplate.query(SELECT_BY_LOGIN_ID_AND_PASS, param,
                new BeanPropertyRowMapper<Users>(Users.class));

        return resultList.isEmpty() ? null : resultList.get(0);

	}

}
