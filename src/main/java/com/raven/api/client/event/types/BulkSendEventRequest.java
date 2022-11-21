package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = BulkSendEventRequest.Builder.class
)
public final class BulkSendEventRequest {
  private final String event;

  private final List<BatchEvent> batch;

  private int _cachedHashCode;

  BulkSendEventRequest(String event, List<BatchEvent> batch) {
    this.event = event;
    this.batch = batch;
  }

  @JsonProperty("event")
  public String getEvent() {
    return event;
  }

  /**
   * List of events
   */
  @JsonProperty("batch")
  public List<BatchEvent> getBatch() {
    return batch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BulkSendEventRequest && equalTo((BulkSendEventRequest) other);
  }

  private boolean equalTo(BulkSendEventRequest other) {
    return event.equals(other.event) && batch.equals(other.batch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.event, this.batch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BulkSendEventRequest{" + "event: " + event + ", batch: " + batch + "}";
  }

  public static EventStage builder() {
    return new Builder();
  }

  public interface EventStage {
    _FinalStage event(String event);

    Builder from(BulkSendEventRequest other);
  }

  public interface _FinalStage {
    BulkSendEventRequest build();

    _FinalStage batch(List<BatchEvent> batch);

    /**
     * List of events
     */
    _FinalStage batch(BatchEvent batch);

    /**
     * List of events
     */
    _FinalStage addAllBatch(List<BatchEvent> batch);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements EventStage, _FinalStage {
    private String event;

    private List<BatchEvent> batch = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(BulkSendEventRequest other) {
      event(other.getEvent());
      batch(other.getBatch());
      return this;
    }

    @Override
    @JsonSetter("event")
    public _FinalStage event(String event) {
      this.event = event;
      return this;
    }

    /**
     * List of events
     */
    @Override
    public _FinalStage addAllBatch(List<BatchEvent> batch) {
      this.batch.addAll(batch);
      return this;
    }

    /**
     * List of events
     */
    @Override
    public _FinalStage batch(BatchEvent batch) {
      this.batch.add(batch);
      return this;
    }

    @Override
    @JsonSetter(
        value = "batch",
        nulls = Nulls.SKIP
    )
    public _FinalStage batch(List<BatchEvent> batch) {
      this.batch.clear();
      this.batch.addAll(batch);
      return this;
    }

    @Override
    public BulkSendEventRequest build() {
      return new BulkSendEventRequest(event, batch);
    }
  }
}
