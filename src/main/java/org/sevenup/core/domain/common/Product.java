package org.sevenup.core.domain.common;

import java.util.List;

/**
 * This class is the parent Product
 * 
 * @author steven.xu
 * 
 */
public abstract class Product {
	private String productId;
	private String procuctNumber;
	private String productName;
	private List<Category> categories;
	private String description = "Product";

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProcuctNumber() {
		return procuctNumber;
	}

	public void setProcuctNumber(String procuctNumber) {
		this.procuctNumber = procuctNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
