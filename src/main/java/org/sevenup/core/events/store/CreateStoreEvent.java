package org.sevenup.core.events.store;

import org.sevenup.core.domain.common.Store;
import org.sevenup.core.events.CreateEvent;

/**
 * 
 * @author steven.xu
 * 
 */
public class CreateStoreEvent extends CreateEvent {
	private Store store;
    /**
     * this method is for store validation
     * @param store
     */
	public void checkStore(Store store) {
//		setCorrect(true);
	}

	public CreateStoreEvent(Store store) {
		this.store = store;
		checkStore(store);
	}

	public Store getStore() {
		return store;
	}
}
