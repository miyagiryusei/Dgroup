package ja.co.example.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.AccounteditDao;
import ja.co.example.entity.Accountedit;

@Repository
public class PgAccounteditDao implements AccounteditDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	MapSqlParameterSource param = new MapSqlParameterSource();

	@Autowired
	HttpSession session;

	@Override
	public int update(String id, String pass) {

		String select = "SELECT * FROM users WHERE login_id:loginid";
		String update = "UPDATE users SET login_id=:id, pass=:pass WHERE login_id =:loginid";

		Accountedit a = (Accountedit) session.getAttribute("loginiser");
		String loginid = a.getLoginId();

		param.addValue("id", id);
		param.addValue("pass", pass);
		param.addValue("loginid", loginid);

		List<Accountedit> resultList = jdbcTemplate.query(select, param,
				new BeanPropertyRowMapper<Accountedit>(Accountedit.class));

		if (resultList.isEmpty()) {
			return jdbcTemplate.update(update, param);
		} else {
			return 2;
		}

	}

}
