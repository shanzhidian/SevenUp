package org.sevenup.core.events;

public abstract class ReadEvent {
  protected boolean entityFound = true;

  public boolean isEntityFound() {
    return entityFound;
  }
}
