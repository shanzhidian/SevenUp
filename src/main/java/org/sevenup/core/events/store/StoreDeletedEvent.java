package org.sevenup.core.events.store;


import org.sevenup.core.domain.common.Store;
import org.sevenup.core.events.DeletedEvent;

/**
 * 
 * @author steven.xu
 *
 */
public class StoreDeletedEvent extends DeletedEvent {
	private String key;
	private Store store;
	private boolean deletionCompleted;

	public StoreDeletedEvent(String key) {
		this.key = key;
	}

	public StoreDeletedEvent(String key, Store store) {
		this.key = key;
		this.store = store;
	}

	/**
	 * If deletion is forbidden
	 * @param key
	 * @param store
	 * @return
	 */
	public static StoreDeletedEvent deletionForbidden(String key, Store store) {
		StoreDeletedEvent event = new StoreDeletedEvent(key, store);
		event.entityFound = true;
		event.setDeletionCompleted(false);
		return event;
	}

	/**
	 *  If this record not found by this key
	 * @param key
	 * @return
	 */
	public static StoreDeletedEvent notFound(String key) {
		StoreDeletedEvent event = new StoreDeletedEvent(key);
		event.entityFound = false;
		return event;
	}
	/*
	 * ************** all the event should just return some state************************
	 * **************      set state just by constructor         ************************
	 */
	public String getKey() {
		return key;
	}

	public Store getStore() {
		return store;
	}

	public boolean isDeletionCompleted() {
		return deletionCompleted;
	}
}
