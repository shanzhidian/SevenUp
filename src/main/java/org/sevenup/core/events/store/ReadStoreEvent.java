package org.sevenup.core.events.store;

import org.sevenup.core.events.RequestReadEvent;

public class ReadStoreEvent extends RequestReadEvent{
	private String key;

	public ReadStoreEvent(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
