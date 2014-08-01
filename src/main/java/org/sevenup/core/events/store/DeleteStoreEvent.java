package org.sevenup.core.events.store;


import org.sevenup.core.events.DeleteEvent;
/**
 * 
 * @author steven.xu
 *
 */
public class DeleteStoreEvent extends DeleteEvent{
	private final String key;

	public DeleteStoreEvent(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
