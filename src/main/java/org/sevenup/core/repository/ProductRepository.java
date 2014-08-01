package org.sevenup.core.repository;

import java.util.List;
import java.util.UUID;

import org.sevenup.core.domain.common.Product;
/**
 * 
 * @author steven
 *
 */
public interface ProductRepository {
	Product save(Product item);

	void delete(UUID key);

	Product findById(UUID key);

	List<Product> findAll();
}
