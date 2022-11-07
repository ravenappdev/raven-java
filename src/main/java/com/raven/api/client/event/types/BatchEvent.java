package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = BatchEvent.Builder.class
)
public final class BatchEvent {
  private final Map<String, Object> data;

  private final Optional<User> user;

  private final Optional<EventOverride> override;

  private int _cachedHashCode;

  BatchEvent(Map<String, Object> data, Optional<User> user, Optional<EventOverride> override) {
    this.data = data;
    this.user = user;
    this.override = override;
  }

  @JsonProperty("data")
  public Map<String, Object> getData() {
    return data;
  }

  @JsonProperty("user")
  public Optional<User> getUser() {
    return user;
  }

  @JsonProperty("override")
  public Optional<EventOverride> getOverride() {
    return override;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BatchEvent && equalTo((BatchEvent) other);
  }

  private boolean equalTo(BatchEvent other) {
    return data.equals(other.data) && user.equals(other.user) && override.equals(other.override);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.data, this.user, this.override);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BatchEvent{" + "data: " + data + ", user: " + user + ", override: " + override + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Map<String, Object> data = new LinkedHashMap<>();

    private Optional<User> user = Optional.empty();

    private Optional<EventOverride> override = Optional.empty();

    private Builder() {
    }

    public Builder from(BatchEvent other) {
      data(other.getData());
      user(other.getUser());
      override(other.getOverride());
      return this;
    }

    @JsonSetter(
        value = "data",
        nulls = Nulls.SKIP
    )
    public Builder data(Map<String, Object> data) {
      this.data.clear();
      this.data.putAll(data);
      return this;
    }

    public Builder putAllData(Map<String, Object> data) {
      this.data.putAll(data);
      return this;
    }

    public Builder data(String key, Object value) {
      this.data.put(key, value);
      return this;
    }

    @JsonSetter(
        value = "user",
        nulls = Nulls.SKIP
    )
    public Builder user(Optional<User> user) {
      this.user = user;
      return this;
    }

    public Builder user(User user) {
      this.user = Optional.of(user);
      return this;
    }

    @JsonSetter(
        value = "override",
        nulls = Nulls.SKIP
    )
    public Builder override(Optional<EventOverride> override) {
      this.override = override;
      return this;
    }

    public Builder override(EventOverride override) {
      this.override = Optional.of(override);
      return this;
    }

    public BatchEvent build() {
      return new BatchEvent(data, user, override);
    }
  }
}
