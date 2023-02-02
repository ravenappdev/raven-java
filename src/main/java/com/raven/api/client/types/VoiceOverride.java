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
    builder = VoiceOverride.Builder.class
)
public final class VoiceOverride implements IChannelOverride {
  private final long scheduleAt;

  private int _cachedHashCode;

  VoiceOverride(long scheduleAt) {
    this.scheduleAt = scheduleAt;
  }

  @JsonProperty("schedule_at")
  @Override
  public long getScheduleAt() {
    return scheduleAt;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof VoiceOverride && equalTo((VoiceOverride) other);
  }

  private boolean equalTo(VoiceOverride other) {
    return scheduleAt == other.scheduleAt;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.scheduleAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "VoiceOverride{" + "scheduleAt: " + scheduleAt + "}";
  }

  public static ScheduleAtStage builder() {
    return new Builder();
  }

  public interface ScheduleAtStage {
    _FinalStage scheduleAt(long scheduleAt);

    Builder from(VoiceOverride other);
  }

  public interface _FinalStage {
    VoiceOverride build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ScheduleAtStage, _FinalStage {
    private long scheduleAt;

    private Builder() {
    }

    @Override
    public Builder from(VoiceOverride other) {
      scheduleAt(other.getScheduleAt());
      return this;
    }

    @Override
    @JsonSetter("schedule_at")
    public _FinalStage scheduleAt(long scheduleAt) {
      this.scheduleAt = scheduleAt;
      return this;
    }

    @Override
    public VoiceOverride build() {
      return new VoiceOverride(scheduleAt);
    }
  }
}
