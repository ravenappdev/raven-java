package com.raven.api.client.user.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = UserPreferences.Builder.class
)
public final class UserPreferences {
  private final Optional<Channel> preferredChannel;

  private final Optional<ChannelPreferences> channelPreferences;

  private int _cachedHashCode;

  UserPreferences(Optional<Channel> preferredChannel,
      Optional<ChannelPreferences> channelPreferences) {
    this.preferredChannel = preferredChannel;
    this.channelPreferences = channelPreferences;
  }

  @JsonProperty("preferred_channel")
  public Optional<Channel> getPreferredChannel() {
    return preferredChannel;
  }

  @JsonProperty("channel_preferences")
  public Optional<ChannelPreferences> getChannelPreferences() {
    return channelPreferences;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UserPreferences && equalTo((UserPreferences) other);
  }

  private boolean equalTo(UserPreferences other) {
    return preferredChannel.equals(other.preferredChannel) && channelPreferences.equals(other.channelPreferences);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.preferredChannel, this.channelPreferences);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UserPreferences{" + "preferredChannel: " + preferredChannel + ", channelPreferences: " + channelPreferences + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Channel> preferredChannel = Optional.empty();

    private Optional<ChannelPreferences> channelPreferences = Optional.empty();

    private Builder() {
    }

    public Builder from(UserPreferences other) {
      preferredChannel(other.getPreferredChannel());
      channelPreferences(other.getChannelPreferences());
      return this;
    }

    @JsonSetter(
        value = "preferred_channel",
        nulls = Nulls.SKIP
    )
    public Builder preferredChannel(Optional<Channel> preferredChannel) {
      this.preferredChannel = preferredChannel;
      return this;
    }

    public Builder preferredChannel(Channel preferredChannel) {
      this.preferredChannel = Optional.of(preferredChannel);
      return this;
    }

    @JsonSetter(
        value = "channel_preferences",
        nulls = Nulls.SKIP
    )
    public Builder channelPreferences(Optional<ChannelPreferences> channelPreferences) {
      this.channelPreferences = channelPreferences;
      return this;
    }

    public Builder channelPreferences(ChannelPreferences channelPreferences) {
      this.channelPreferences = Optional.of(channelPreferences);
      return this;
    }

    public UserPreferences build() {
      return new UserPreferences(preferredChannel, channelPreferences);
    }
  }
}
