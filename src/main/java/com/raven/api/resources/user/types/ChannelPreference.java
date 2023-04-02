package com.raven.api.resources.user.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = ChannelPreference.Builder.class
)
public final class ChannelPreference {
  private final boolean disabled;

  private int _cachedHashCode;

  ChannelPreference(boolean disabled) {
    this.disabled = disabled;
  }

  @JsonProperty("disabled")
  public boolean getDisabled() {
    return disabled;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ChannelPreference && equalTo((ChannelPreference) other);
  }

  private boolean equalTo(ChannelPreference other) {
    return disabled == other.disabled;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.disabled);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ChannelPreference{" + "disabled: " + disabled + "}";
  }

  public static DisabledStage builder() {
    return new Builder();
  }

  public interface DisabledStage {
    _FinalStage disabled(boolean disabled);

    Builder from(ChannelPreference other);
  }

  public interface _FinalStage {
    ChannelPreference build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements DisabledStage, _FinalStage {
    private boolean disabled;

    private Builder() {
    }

    @Override
    public Builder from(ChannelPreference other) {
      disabled(other.getDisabled());
      return this;
    }

    @Override
    @JsonSetter("disabled")
    public _FinalStage disabled(boolean disabled) {
      this.disabled = disabled;
      return this;
    }

    @Override
    public ChannelPreference build() {
      return new ChannelPreference(disabled);
    }
  }
}
