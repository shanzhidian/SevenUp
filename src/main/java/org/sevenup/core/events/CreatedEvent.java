package org.sevenup.core.events;
/**
 * 
 * @author steven.xu
 *
 */
public abstract class CreatedEvent {
	private boolean creationCompleted;

	public boolean isCreationCompleted() {
		return creationCompleted;
	}

	public void setCreationCompleted(boolean creationCompleted) {
		this.creationCompleted = creationCompleted;
	}
}
