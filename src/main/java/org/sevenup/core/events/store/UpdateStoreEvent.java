package org.sevenup.core.events.store;

import org.sevenup.core.domain.common.Store;
import org.sevenup.core.events.UpdateEvent;

public class UpdateStoreEvent extends UpdateEvent{
	private Store store;

	public UpdateStoreEvent(Store store) {
		this.store = store;
	}

	public Store getStore() {
		return store;
	}
	
}
