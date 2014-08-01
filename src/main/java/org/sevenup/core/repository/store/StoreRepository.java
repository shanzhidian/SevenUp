package org.sevenup.core.repository.store;

import java.util.List;
import java.util.Map;

import org.sevenup.core.domain.common.Store;

/**
 * 
 * @author steven.xu
 *
 */
public interface StoreRepository {
	Store save(Store store);
	Store update(Store store);
	void delete(Store store);
	Store findById(String id);
	List<Store> findByCondition(Map map);
}
