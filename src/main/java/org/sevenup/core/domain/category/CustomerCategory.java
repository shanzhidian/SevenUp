package org.sevenup.core.domain.category;

import java.util.List;
import java.util.Map;

import org.sevenup.core.domain.common.Category;

/**
 * Category based on customers
 * @author steven.xu
 *
 */
public class CustomerCategory extends Category{
	private Map<Integer, List<Category>> subcategoryMap;

	public Map<Integer, List<Category>> getSubcategoryMap() {
		return subcategoryMap;
	}

	public void setSubcategoryMap(Map<Integer, List<Category>> subcategoryMap) {
		this.subcategoryMap = subcategoryMap;
	}
}
