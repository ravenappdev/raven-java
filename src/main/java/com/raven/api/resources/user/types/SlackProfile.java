package com.raven.api.resources.user.types;

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
    builder = SlackProfile.Builder.class
)
public final class SlackProfile {
  private final String accessToken;

  private final Optional<String> email;

  private final Optional<String> channelId;

  private int _cachedHashCode;

  SlackProfile(String accessToken, Optional<String> email, Optional<String> channelId) {
    this.accessToken = accessToken;
    this.email = email;
    this.channelId = channelId;
  }

  @JsonProperty("access_token")
  public String getAccessToken() {
    return accessToken;
  }

  @JsonProperty("email")
  public Optional<String> getEmail() {
    return email;
  }

  @JsonProperty("channel_id")
  public Optional<String> getChannelId() {
    return channelId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SlackProfile && equalTo((SlackProfile) other);
  }

  private boolean equalTo(SlackProfile other) {
    return accessToken.equals(other.accessToken) && email.equals(other.email) && channelId.equals(other.channelId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.accessToken, this.email, this.channelId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SlackProfile{" + "accessToken: " + accessToken + ", email: " + email + ", channelId: " + channelId + "}";
  }

  public static AccessTokenStage builder() {
    return new Builder();
  }

  public interface AccessTokenStage {
    _FinalStage accessToken(String accessToken);

    Builder from(SlackProfile other);
  }

  public interface _FinalStage {
    SlackProfile build();

    _FinalStage email(Optional<String> email);

    _FinalStage email(String email);

    _FinalStage channelId(Optional<String> channelId);

    _FinalStage channelId(String channelId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements AccessTokenStage, _FinalStage {
    private String accessToken;

    private Optional<String> channelId = Optional.empty();

    private Optional<String> email = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(SlackProfile other) {
      accessToken(other.getAccessToken());
      email(other.getEmail());
      channelId(other.getChannelId());
      return this;
    }

    @Override
    @JsonSetter("access_token")
    public _FinalStage accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    @Override
    public _FinalStage channelId(String channelId) {
      this.channelId = Optional.of(channelId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "channel_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage channelId(Optional<String> channelId) {
      this.channelId = channelId;
      return this;
    }

    @Override
    public _FinalStage email(String email) {
      this.email = Optional.of(email);
      return this;
    }

    @Override
    @JsonSetter(
        value = "email",
        nulls = Nulls.SKIP
    )
    public _FinalStage email(Optional<String> email) {
      this.email = email;
      return this;
    }

    @Override
    public SlackProfile build() {
      return new SlackProfile(accessToken, email, channelId);
    }
  }
}
