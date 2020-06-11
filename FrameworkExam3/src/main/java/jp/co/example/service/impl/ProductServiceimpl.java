package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ProductDao;
import jp.co.example.entity.Product;
import jp.co.example.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	public Product findById(Integer id) {
		return productDao.findById(id);
    }

}
