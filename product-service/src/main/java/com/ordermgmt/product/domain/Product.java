package com.ordermgmt.product.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "products")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
	
	@Id
	private String id;
	private String productId;
	private String productName;
	private int productPrice;
	
	public Product() {
	}
	
	public String getId() {
		return id;
	}



	public int getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	

	
}
