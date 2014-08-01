package org.sevenup.core.domain.wishlist;

import java.util.List;

import org.sevenup.core.domain.common.Product;

/**
 * 
 * @author steven
 * 
 */
public class WishList {
	private String wishListId;
	private String wishListNumber;
	private String wishListName;
	private List<Product> products;

	public String getWishListId() {
		return wishListId;
	}

	public void setWishListId(String wishListId) {
		this.wishListId = wishListId;
	}

	public String getWishListNumber() {
		return wishListNumber;
	}

	public void setWishListNumber(String wishListNumber) {
		this.wishListNumber = wishListNumber;
	}

	public String getWishListName() {
		return wishListName;
	}

	public void setWishListName(String wishListName) {
		this.wishListName = wishListName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
