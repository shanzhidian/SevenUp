package org.sevenup.core.events;
/**
 * 
 * @author steven.xu
 *
 */
public abstract class CreateEvent {
	private boolean isCorrect = true;

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
