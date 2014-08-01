package org.sevenup.core.events.store;

import org.sevenup.core.domain.common.Store;
import org.sevenup.core.events.CreatedEvent;



public class StoreCreatedEvent extends CreatedEvent{
	private Store store;
	public StoreCreatedEvent(Store store) {
		this.store = store;
	}
	public static StoreCreatedEvent creationFailer(Store store){
		StoreCreatedEvent event = new StoreCreatedEvent(store);
		return event;
	}
}
