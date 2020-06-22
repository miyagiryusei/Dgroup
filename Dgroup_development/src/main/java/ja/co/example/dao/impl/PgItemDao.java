package ja.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.ItemDao;
import ja.co.example.entity.Itemlist;



@Repository
public class PgItemDao implements ItemDao {



	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	@Override
	public List<Itemlist> itemlist(Integer id) {
		String sql= "SELECT i.name, i.effect, il.item_count FROM users as u "
				+"join item_list as il ON u.user_id = il.user_id "
				+"join item as i ON il.item_id = i.item_id "
				+"where u.user_id=:id ";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("id", id);
		List<Itemlist> list = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Itemlist>(Itemlist.class));

		return list.isEmpty() ? null : list;



	}

}
