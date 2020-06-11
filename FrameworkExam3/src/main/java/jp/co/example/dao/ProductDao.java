package jp.co.example.dao;

import jp.co.example.entity.Product;

public interface ProductDao {
	public Product findById(Integer id);
}
