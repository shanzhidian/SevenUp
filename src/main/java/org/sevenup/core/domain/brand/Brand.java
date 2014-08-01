package org.sevenup.core.domain.brand;

import java.util.List;

import org.sevenup.core.domain.common.Category;

/**
 * 
 * @author steven this interface is for what Brand to show
 */
public abstract class Brand {
	private String brandId;
	private String brandNumber;
	private String brandName;

	private List<Category> categories;

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandNumber() {
		return brandNumber;
	}

	public void setBrandNumber(String brandNumber) {
		this.brandNumber = brandNumber;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
