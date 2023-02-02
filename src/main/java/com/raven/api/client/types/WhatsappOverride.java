package com.raven.api.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = WhatsappOverride.Builder.class
)
public final class WhatsappOverride implements IChannelOverride {
  private final long scheduleAt;

  private final SmsMessage message;

  private int _cachedHashCode;

  WhatsappOverride(long scheduleAt, SmsMessage message) {
    this.scheduleAt = scheduleAt;
    this.message = message;
  }

  @JsonProperty("schedule_at")
  @Override
  public long getScheduleAt() {
    return scheduleAt;
  }

  @JsonProperty("message")
  public SmsMessage getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof WhatsappOverride && equalTo((WhatsappOverride) other);
  }

  private boolean equalTo(WhatsappOverride other) {
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
    return "WhatsappOverride{" + "scheduleAt: " + scheduleAt + ", message: " + message + "}";
  }

  public static ScheduleAtStage builder() {
    return new Builder();
  }

  public interface ScheduleAtStage {
    MessageStage scheduleAt(long scheduleAt);

    Builder from(WhatsappOverride other);
  }

  public interface MessageStage {
    _FinalStage message(SmsMessage message);
  }

  public interface _FinalStage {
    WhatsappOverride build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ScheduleAtStage, MessageStage, _FinalStage {
    private long scheduleAt;

    private SmsMessage message;

    private Builder() {
    }

    @Override
    public Builder from(WhatsappOverride other) {
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
    public _FinalStage message(SmsMessage message) {
      this.message = message;
      return this;
    }

    @Override
    public WhatsappOverride build() {
      return new WhatsappOverride(scheduleAt, message);
    }
  }
}
