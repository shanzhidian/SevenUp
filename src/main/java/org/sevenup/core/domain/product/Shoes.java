package org.sevenup.core.domain.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sevenup.core.domain.common.Product;

public class Shoes extends Product{
	private Map<String, List<Double>> shoesSize;
	private String shoesColor;
	private Map<String, Double> priceMap;
	
	/**
	 * 
	 * @param standard
	 * @param size
	 */
	public void setShoesSize(String standard,Double size){
		
	}
}
