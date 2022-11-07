package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = SendEventResponse.Builder.class
)
public final class SendEventResponse {
  private final String id;

  private final boolean success;

  private int _cachedHashCode;

  SendEventResponse(String id, boolean success) {
    this.id = id;
    this.success = success;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("success")
  public boolean getSuccess() {
    return success;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SendEventResponse && equalTo((SendEventResponse) other);
  }

  private boolean equalTo(SendEventResponse other) {
    return id.equals(other.id) && success == other.success;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.success);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SendEventResponse{" + "id: " + id + ", success: " + success + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    SuccessStage id(String id);

    Builder from(SendEventResponse other);
  }

  public interface SuccessStage {
    _FinalStage success(boolean success);
  }

  public interface _FinalStage {
    SendEventResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, SuccessStage, _FinalStage {
    private String id;

    private boolean success;

    private Builder() {
    }

    @Override
    public Builder from(SendEventResponse other) {
      id(other.getId());
      success(other.getSuccess());
      return this;
    }

    @Override
    @JsonSetter("id")
    public SuccessStage id(String id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("success")
    public _FinalStage success(boolean success) {
      this.success = success;
      return this;
    }

    @Override
    public SendEventResponse build() {
      return new SendEventResponse(id, success);
    }
  }
}
