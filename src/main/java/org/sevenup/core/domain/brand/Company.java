package org.sevenup.core.domain.brand;

import java.util.List;

import org.sevenup.core.domain.common.Category;

/**
 * 
 * @author steven this class is for Company to show
 */
public abstract class Company {
	private String companyId;
	private String companyNumber;
	private String companyName;

	private List<Category> categories;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
