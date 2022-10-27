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
    builder = SlackProfile.Builder.class
)
public final class SlackProfile {
  private final String accessToken;

  private final String email;

  private final String channelId;

  private int _cachedHashCode;

  SlackProfile(String accessToken, String email, String channelId) {
    this.accessToken = accessToken;
    this.email = email;
    this.channelId = channelId;
  }

  @JsonProperty("access_token")
  public String getAccessToken() {
    return accessToken;
  }

  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @JsonProperty("channel_id")
  public String getChannelId() {
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
    EmailStage accessToken(String accessToken);

    Builder from(SlackProfile other);
  }

  public interface EmailStage {
    ChannelIdStage email(String email);
  }

  public interface ChannelIdStage {
    _FinalStage channelId(String channelId);
  }

  public interface _FinalStage {
    SlackProfile build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements AccessTokenStage, EmailStage, ChannelIdStage, _FinalStage {
    private String accessToken;

    private String email;

    private String channelId;

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
    public EmailStage accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    @Override
    @JsonSetter("email")
    public ChannelIdStage email(String email) {
      this.email = email;
      return this;
    }

    @Override
    @JsonSetter("channel_id")
    public _FinalStage channelId(String channelId) {
      this.channelId = channelId;
      return this;
    }

    @Override
    public SlackProfile build() {
      return new SlackProfile(accessToken, email, channelId);
    }
  }
}
