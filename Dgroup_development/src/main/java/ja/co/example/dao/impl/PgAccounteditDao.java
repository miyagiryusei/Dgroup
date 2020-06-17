package ja.co.example.dao.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.AccounteditDao;

@Repository
public class PgAccounteditDao implements AccounteditDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	MapSqlParameterSource param = new MapSqlParameterSource();

	@Autowired
	HttpSession session;

	@Override
	public int update(String name, String pass,String logid) {

		String update = "UPDATE users SET user_name=:name, pass=:pass, edit_time=now() WHERE login_id =:loginid";


		param.addValue("name", name);
		param.addValue("pass", pass);
		param.addValue("loginid", logid);


			return jdbcTemplate.update(update, param);
	}




}
