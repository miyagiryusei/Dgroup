package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {
	private static final String SQL_SELECT_ALL = "select * from products order by product_id";
	private static final String SQL_INSERT = "insert into products (product_name,price) values (?,?)";
	private static final String SQL_SELECT_FINDID ="select * from products where product_id=?";
	private static final String SQL_UPDATE ="update products set product_name=?,price=? where product_id=? ";
	private static final String SQL_DELETE="delete from products where product_name=?";

	private Connection connection;

	public ProductDao() {

	}

	public ProductDao(Connection connection) {
		this.connection = connection;
	}

	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;

	}

	public void register(Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setString(1,product.getProductName());
			stmt.setInt(2,product.getPrice());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);


		}
	}

	public Product findByProductId(Integer productId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_FINDID)) {
			stmt.setInt(1,productId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public void update(Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1,product.getProductName());
			stmt.setInt(2,product.getPrice());
			stmt.setInt(3, product.getProductId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);


		}
	}

	public void delete(String productName ) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
			stmt.setString(1,productName);

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);


		}
	}




}
