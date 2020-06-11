package jp.co.example.entity;

public class Product {
	private Integer productId;
	private String productName;
	private Integer price;


	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPrice() {
		return this.price;
	}
}
