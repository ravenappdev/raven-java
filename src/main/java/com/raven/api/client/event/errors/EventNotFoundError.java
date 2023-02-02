package com.raven.api.client.event.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.raven.api.client.event.types.EventNotFoundErrorBody;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public final class EventNotFoundError {
  private final EventNotFoundErrorBody value;

  private EventNotFoundError(EventNotFoundErrorBody value) {
    this.value = value;
  }

  @JsonValue
  public EventNotFoundErrorBody get() {
    return this.value;
  }

  @Override
  public boolean equals(Object other) {
    return this == other || (other instanceof EventNotFoundError && this.value.equals(((EventNotFoundError) other).value));
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return value.toString();
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static EventNotFoundError of(EventNotFoundErrorBody value) {
    return new EventNotFoundError(value);
  }
}
