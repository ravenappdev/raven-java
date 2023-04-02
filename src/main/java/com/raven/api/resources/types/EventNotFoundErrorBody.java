package com.raven.api.resources.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = EventNotFoundErrorBody.Builder.class
)
public final class EventNotFoundErrorBody {
  private final boolean success;

  private final String error;

  private int _cachedHashCode;

  EventNotFoundErrorBody(boolean success, String error) {
    this.success = success;
    this.error = error;
  }

  @JsonProperty("success")
  public boolean getSuccess() {
    return success;
  }

  @JsonProperty("error")
  public String getError() {
    return error;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EventNotFoundErrorBody && equalTo((EventNotFoundErrorBody) other);
  }

  private boolean equalTo(EventNotFoundErrorBody other) {
    return success == other.success && error.equals(other.error);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.success, this.error);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EventNotFoundErrorBody{" + "success: " + success + ", error: " + error + "}";
  }

  public static SuccessStage builder() {
    return new Builder();
  }

  public interface SuccessStage {
    ErrorStage success(boolean success);

    Builder from(EventNotFoundErrorBody other);
  }

  public interface ErrorStage {
    _FinalStage error(String error);
  }

  public interface _FinalStage {
    EventNotFoundErrorBody build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements SuccessStage, ErrorStage, _FinalStage {
    private boolean success;

    private String error;

    private Builder() {
    }

    @Override
    public Builder from(EventNotFoundErrorBody other) {
      success(other.getSuccess());
      error(other.getError());
      return this;
    }

    @Override
    @JsonSetter("success")
    public ErrorStage success(boolean success) {
      this.success = success;
      return this;
    }

    @Override
    @JsonSetter("error")
    public _FinalStage error(String error) {
      this.error = error;
      return this;
    }

    @Override
    public EventNotFoundErrorBody build() {
      return new EventNotFoundErrorBody(success, error);
    }
  }
}
