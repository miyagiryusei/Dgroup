package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ProductDao;
import jp.co.example.entity.Product;

	@Repository
	public class PgProductDao implements ProductDao{
		@Autowired
		private NamedParameterJdbcTemplate jdbcTemplate ;

		public Product findById(Integer id) {
			String sql = "select * from products Where product_id = :productId";

			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("productId", id);

			List<Product> resultList = jdbcTemplate.query(sql,param,
					new BeanPropertyRowMapper<Product>(Product.class));

			return resultList.isEmpty() ? null : resultList.get(0);

		}
}
