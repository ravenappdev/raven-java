package com.raven.api.client.user.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = InAppProfile.Builder.class
)
public final class InAppProfile {
  private final String lastOpen;

  private int _cachedHashCode;

  InAppProfile(String lastOpen) {
    this.lastOpen = lastOpen;
  }

  @JsonProperty("last_open")
  public String getLastOpen() {
    return lastOpen;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof InAppProfile && equalTo((InAppProfile) other);
  }

  private boolean equalTo(InAppProfile other) {
    return lastOpen.equals(other.lastOpen);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.lastOpen);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "InAppProfile{" + "lastOpen: " + lastOpen + "}";
  }

  public static LastOpenStage builder() {
    return new Builder();
  }

  public interface LastOpenStage {
    _FinalStage lastOpen(String lastOpen);

    Builder from(InAppProfile other);
  }

  public interface _FinalStage {
    InAppProfile build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements LastOpenStage, _FinalStage {
    private String lastOpen;

    private Builder() {
    }

    @Override
    public Builder from(InAppProfile other) {
      lastOpen(other.getLastOpen());
      return this;
    }

    @Override
    @JsonSetter("last_open")
    public _FinalStage lastOpen(String lastOpen) {
      this.lastOpen = lastOpen;
      return this;
    }

    @Override
    public InAppProfile build() {
      return new InAppProfile(lastOpen);
    }
  }
}
