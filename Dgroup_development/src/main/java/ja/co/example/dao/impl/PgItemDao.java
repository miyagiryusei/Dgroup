package ja.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ja.co.example.dao.GameResultDao;
import ja.co.example.dao.ItemDao;
import ja.co.example.entity.Itemlist;
import ja.co.example.entity.Users;



@Repository
public class PgItemDao implements ItemDao {



	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	GameResultDao gameresult;


	@Override
	public List<Itemlist> itemlist(Integer id) {
		String sql= "SELECT i.item_id,i.name, i.effect, il.item_count FROM users as u "
				+"join item_list as il ON u.user_id = il.user_id "
				+"join item as i ON il.item_id = i.item_id "
				+"where u.user_id=:id ";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("id", id);
		List<Itemlist> list = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Itemlist>(Itemlist.class));

		return list.isEmpty() ? null : list;



	}
	public Integer Goddess(Integer id, Integer userid, Integer itemcoin, Users user) {

		String sql1 = "INSERT INTO result (user_id,coin,division_id, result_time) VALUES"
				+ "(:user_id ,:itemcoin , 3, now() ) ";

		String sql2 ="update item_list set item_count=item_count-1 " +
				"where user_id=:user_id and item_id =:itemid";



		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("itemid", id);
		param.addValue("user_id", userid);
		param.addValue("itemcoin", itemcoin);
		param.addValue("itemid", id);


		jdbcTemplate.update(sql1, param);
		jdbcTemplate.update(sql2, param);
		gameresult.userGetCoin(user);

		return id;

	}
	@Override
	public void itemListDelete(Integer userId, Integer itemId) {
		String sql_delete = "delete from item_list where user_id=:userId and item_id=:itemId";
;

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("itemId",itemId );

			jdbcTemplate.update(sql_delete, param);


	}


}
