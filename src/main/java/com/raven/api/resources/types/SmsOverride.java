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
    builder = SmsOverride.Builder.class
)
public final class SmsOverride implements IChannelOverride {
  private final long scheduleAt;

  private final String sender;

  private final SmsMessage message;

  private int _cachedHashCode;

  SmsOverride(long scheduleAt, String sender, SmsMessage message) {
    this.scheduleAt = scheduleAt;
    this.sender = sender;
    this.message = message;
  }

  @JsonProperty("schedule_at")
  @Override
  public long getScheduleAt() {
    return scheduleAt;
  }

  @JsonProperty("sender")
  public String getSender() {
    return sender;
  }

  @JsonProperty("message")
  public SmsMessage getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SmsOverride && equalTo((SmsOverride) other);
  }

  private boolean equalTo(SmsOverride other) {
    return scheduleAt == other.scheduleAt && sender.equals(other.sender) && message.equals(other.message);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.scheduleAt, this.sender, this.message);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SmsOverride{" + "scheduleAt: " + scheduleAt + ", sender: " + sender + ", message: " + message + "}";
  }

  public static ScheduleAtStage builder() {
    return new Builder();
  }

  public interface ScheduleAtStage {
    SenderStage scheduleAt(long scheduleAt);

    Builder from(SmsOverride other);
  }

  public interface SenderStage {
    MessageStage sender(String sender);
  }

  public interface MessageStage {
    _FinalStage message(SmsMessage message);
  }

  public interface _FinalStage {
    SmsOverride build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ScheduleAtStage, SenderStage, MessageStage, _FinalStage {
    private long scheduleAt;

    private String sender;

    private SmsMessage message;

    private Builder() {
    }

    @Override
    public Builder from(SmsOverride other) {
      scheduleAt(other.getScheduleAt());
      sender(other.getSender());
      message(other.getMessage());
      return this;
    }

    @Override
    @JsonSetter("schedule_at")
    public SenderStage scheduleAt(long scheduleAt) {
      this.scheduleAt = scheduleAt;
      return this;
    }

    @Override
    @JsonSetter("sender")
    public MessageStage sender(String sender) {
      this.sender = sender;
      return this;
    }

    @Override
    @JsonSetter("message")
    public _FinalStage message(SmsMessage message) {
      this.message = message;
      return this;
    }

    @Override
    public SmsOverride build() {
      return new SmsOverride(scheduleAt, sender, message);
    }
  }
}
