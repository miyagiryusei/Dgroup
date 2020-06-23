package ja.co.example.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.AccountDao;
import ja.co.example.entity.Account;

@Repository
public class PgAccountDao implements AccountDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	MapSqlParameterSource param = new MapSqlParameterSource();

	public List<Account> findAll() {
		return jdbcTemplate.query("SELECT * FROM users ORDER BY user_id",
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Autowired
	HttpSession session;

	@Override

	public Account select(String id) {

		String sql = "SELECT * FROM users WHERE login_id = :login_id";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("login_id", id);

		List<Account> que = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Account>(Account.class));
		if (que.isEmpty()) {
			return null;
		}
		return que.get(0);
	}

	public Account insert(String id, String pass, String name) {



		String sql1 = "INSERT INTO users (login_id,user_name,pass,coin, rank_id, insert_time, user_status) VALUES"
				+ "(:login_id ,:user_name , :pass , 1000,1,now(),1) ";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("login_id", id);
		param.addValue("user_name", name);
		param.addValue("pass", pass);



			jdbcTemplate.update(sql1, param);
			return null;

	}

}
