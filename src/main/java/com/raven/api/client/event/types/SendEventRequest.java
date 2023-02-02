package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = SendEventRequest.Builder.class
)
public final class SendEventRequest {
  private final String event;

  private final Map<String, Object> data;

  private final Optional<User> user;

  private final Optional<Long> scheduleAt;

  private final Optional<EventOverride> override;

  private int _cachedHashCode;

  SendEventRequest(String event, Map<String, Object> data, Optional<User> user,
      Optional<Long> scheduleAt, Optional<EventOverride> override) {
    this.event = event;
    this.data = data;
    this.user = user;
    this.scheduleAt = scheduleAt;
    this.override = override;
  }

  /**
   * @return The name of the event
   */
  @JsonProperty("event")
  public String getEvent() {
    return event;
  }

  @JsonProperty("data")
  public Map<String, Object> getData() {
    return data;
  }

  @JsonProperty("user")
  public Optional<User> getUser() {
    return user;
  }

  /**
   * @return Time to send message expressed as UTC milliseconds.
   * If not present, message will be sent immediately.
   */
  @JsonProperty("scheduleAt")
  public Optional<Long> getScheduleAt() {
    return scheduleAt;
  }

  @JsonProperty("override")
  public Optional<EventOverride> getOverride() {
    return override;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SendEventRequest && equalTo((SendEventRequest) other);
  }

  private boolean equalTo(SendEventRequest other) {
    return event.equals(other.event) && data.equals(other.data) && user.equals(other.user) && scheduleAt.equals(other.scheduleAt) && override.equals(other.override);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.event, this.data, this.user, this.scheduleAt, this.override);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SendEventRequest{" + "event: " + event + ", data: " + data + ", user: " + user + ", scheduleAt: " + scheduleAt + ", override: " + override + "}";
  }

  public static EventStage builder() {
    return new Builder();
  }

  public interface EventStage {
    _FinalStage event(String event);

    Builder from(SendEventRequest other);
  }

  public interface _FinalStage {
    SendEventRequest build();

    _FinalStage data(Map<String, Object> data);

    _FinalStage putAllData(Map<String, Object> data);

    _FinalStage data(String key, Object value);

    _FinalStage user(Optional<User> user);

    _FinalStage user(User user);

    _FinalStage scheduleAt(Optional<Long> scheduleAt);

    _FinalStage scheduleAt(Long scheduleAt);

    _FinalStage override(Optional<EventOverride> override);

    _FinalStage override(EventOverride override);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements EventStage, _FinalStage {
    private String event;

    private Optional<EventOverride> override = Optional.empty();

    private Optional<Long> scheduleAt = Optional.empty();

    private Optional<User> user = Optional.empty();

    private Map<String, Object> data = new LinkedHashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(SendEventRequest other) {
      event(other.getEvent());
      data(other.getData());
      user(other.getUser());
      scheduleAt(other.getScheduleAt());
      override(other.getOverride());
      return this;
    }

    /**
     * <p>The name of the event</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("event")
    public _FinalStage event(String event) {
      this.event = event;
      return this;
    }

    @Override
    public _FinalStage override(EventOverride override) {
      this.override = Optional.of(override);
      return this;
    }

    @Override
    @JsonSetter(
        value = "override",
        nulls = Nulls.SKIP
    )
    public _FinalStage override(Optional<EventOverride> override) {
      this.override = override;
      return this;
    }

    /**
     * <p>Time to send message expressed as UTC milliseconds.
     * If not present, message will be sent immediately.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage scheduleAt(Long scheduleAt) {
      this.scheduleAt = Optional.of(scheduleAt);
      return this;
    }

    @Override
    @JsonSetter(
        value = "scheduleAt",
        nulls = Nulls.SKIP
    )
    public _FinalStage scheduleAt(Optional<Long> scheduleAt) {
      this.scheduleAt = scheduleAt;
      return this;
    }

    @Override
    public _FinalStage user(User user) {
      this.user = Optional.of(user);
      return this;
    }

    @Override
    @JsonSetter(
        value = "user",
        nulls = Nulls.SKIP
    )
    public _FinalStage user(Optional<User> user) {
      this.user = user;
      return this;
    }

    @Override
    public _FinalStage data(String key, Object value) {
      this.data.put(key, value);
      return this;
    }

    @Override
    public _FinalStage putAllData(Map<String, Object> data) {
      this.data.putAll(data);
      return this;
    }

    @Override
    @JsonSetter(
        value = "data",
        nulls = Nulls.SKIP
    )
    public _FinalStage data(Map<String, Object> data) {
      this.data.clear();
      this.data.putAll(data);
      return this;
    }

    @Override
    public SendEventRequest build() {
      return new SendEventRequest(event, data, user, scheduleAt, override);
    }
  }
}
