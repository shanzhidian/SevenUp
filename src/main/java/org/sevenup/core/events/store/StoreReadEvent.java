package org.sevenup.core.events.store;

import java.util.List;

import org.sevenup.core.domain.common.Store;
import org.sevenup.core.events.ReadEvent;
/**
 * 
 * @author steven.xu
 *
 */
public class StoreReadEvent extends ReadEvent{
	private final List<Store> storesList;

	public StoreReadEvent(List<Store> storesList) {
		this.storesList = storesList;
	}

	public List<Store> getStoresList() {
		return storesList;
	}
	
}
