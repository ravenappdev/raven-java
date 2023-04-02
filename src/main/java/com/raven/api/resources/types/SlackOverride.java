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
    builder = SlackOverride.Builder.class
)
public final class SlackOverride implements IChannelOverride {
  private final long scheduleAt;

  private final SlackMessage message;

  private int _cachedHashCode;

  SlackOverride(long scheduleAt, SlackMessage message) {
    this.scheduleAt = scheduleAt;
    this.message = message;
  }

  @JsonProperty("schedule_at")
  @Override
  public long getScheduleAt() {
    return scheduleAt;
  }

  @JsonProperty("message")
  public SlackMessage getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SlackOverride && equalTo((SlackOverride) other);
  }

  private boolean equalTo(SlackOverride other) {
    return scheduleAt == other.scheduleAt && message.equals(other.message);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.scheduleAt, this.message);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SlackOverride{" + "scheduleAt: " + scheduleAt + ", message: " + message + "}";
  }

  public static ScheduleAtStage builder() {
    return new Builder();
  }

  public interface ScheduleAtStage {
    MessageStage scheduleAt(long scheduleAt);

    Builder from(SlackOverride other);
  }

  public interface MessageStage {
    _FinalStage message(SlackMessage message);
  }

  public interface _FinalStage {
    SlackOverride build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ScheduleAtStage, MessageStage, _FinalStage {
    private long scheduleAt;

    private SlackMessage message;

    private Builder() {
    }

    @Override
    public Builder from(SlackOverride other) {
      scheduleAt(other.getScheduleAt());
      message(other.getMessage());
      return this;
    }

    @Override
    @JsonSetter("schedule_at")
    public MessageStage scheduleAt(long scheduleAt) {
      this.scheduleAt = scheduleAt;
      return this;
    }

    @Override
    @JsonSetter("message")
    public _FinalStage message(SlackMessage message) {
      this.message = message;
      return this;
    }

    @Override
    public SlackOverride build() {
      return new SlackOverride(scheduleAt, message);
    }
  }
}
