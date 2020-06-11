import java.sql.Connection;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class ProductService {
	public Product find(Integer productId){
		try (Connection connection = DbUtil.getConnection() ){
			ProductDao productDao = new ProductDao(connection);
			return productDao.findByProductId(productId);
		}catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

}
