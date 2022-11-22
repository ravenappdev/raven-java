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
    builder = InAppOverride.Builder.class
)
public final class InAppOverride implements IChannelOverride {
  private final long scheduleAt;

  private int _cachedHashCode;

  InAppOverride(long scheduleAt) {
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
    return other instanceof InAppOverride && equalTo((InAppOverride) other);
  }

  private boolean equalTo(InAppOverride other) {
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
    return "InAppOverride{" + "scheduleAt: " + scheduleAt + "}";
  }

  public static ScheduleAtStage builder() {
    return new Builder();
  }

  public interface ScheduleAtStage {
    _FinalStage scheduleAt(long scheduleAt);

    Builder from(InAppOverride other);
  }

  public interface _FinalStage {
    InAppOverride build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ScheduleAtStage, _FinalStage {
    private long scheduleAt;

    private Builder() {
    }

    @Override
    public Builder from(InAppOverride other) {
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
    public InAppOverride build() {
      return new InAppOverride(scheduleAt);
    }
  }
}
