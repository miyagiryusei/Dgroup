package ja.co.example.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.ItemShopDao;
import ja.co.example.entity.ItemShop;

@Repository
public class PgItemShopDao implements ItemShopDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	MapSqlParameterSource param = new MapSqlParameterSource();


	@Autowired
	HttpSession session;

	@Override

	public List<ItemShop> select() {

		String sql = "SELECT * FROM item" ;

		MapSqlParameterSource param = new MapSqlParameterSource();
		//param.addValue("item_id", id);

		List<ItemShop> que = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<ItemShop>(ItemShop.class));
		if (que.isEmpty()) {
			return null;
		}
		return que;
	}

	public ItemShop insert (Integer id, Integer itemId, Integer itemCount) {

		String sql1 = "INSERT INTO item_list (user_id,item_id,item_count) VALUES"
				+ "(:user_id ,:item_id , :item_count) ";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", id);
		param.addValue("item_id", itemId);
		param.addValue("item_count", itemCount);

			jdbcTemplate.update(sql1, param);
			return null;
	}

	@Override
	public void buyResult(Integer user_id, Integer coin, Integer division_id) {

		String sql1 = "INSERT INTO result (user_id,coin,division_id, result_time) VALUES"
				+ "(:user_id ,-:coin , :division_id, now() ) ";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user_id);
		param.addValue("coin", coin);
		param.addValue("division_id", division_id);

			jdbcTemplate.update(sql1, param);



	}

	@Override
	public ItemShop selectPrice(Integer itemId) {
		String sql = "SELECT * FROM item where item_id=:item_id" ;

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("item_id", itemId);

		List<ItemShop> que = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<ItemShop>(ItemShop.class));
		if (que.isEmpty()) {
			return null;
		}
		return que.get(0);
	}
}
