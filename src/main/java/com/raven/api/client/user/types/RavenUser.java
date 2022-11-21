package com.raven.api.client.user.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = RavenUser.Builder.class
)
public final class RavenUser {
  private final String userId;

  private final Optional<String> userSid;

  private final Optional<String> onesignalExternalId;

  private final Optional<String> mobile;

  private final Optional<String> email;

  private final Optional<String> whatsappMobile;

  private final Optional<SlackProfile> slack;

  private final Optional<TelegramProfile> telegram;

  private final Optional<List<String>> fcmTokens;

  private final Optional<List<String>> onesignalPlayerIds;

  private final Optional<List<String>> iosTokens;

  private final Optional<Long> createdAt;

  private final Optional<Long> updatedAt;

  private int _cachedHashCode;

  RavenUser(String userId, Optional<String> userSid, Optional<String> onesignalExternalId,
      Optional<String> mobile, Optional<String> email, Optional<String> whatsappMobile,
      Optional<SlackProfile> slack, Optional<TelegramProfile> telegram,
      Optional<List<String>> fcmTokens, Optional<List<String>> onesignalPlayerIds,
      Optional<List<String>> iosTokens, Optional<Long> createdAt, Optional<Long> updatedAt) {
    this.userId = userId;
    this.userSid = userSid;
    this.onesignalExternalId = onesignalExternalId;
    this.mobile = mobile;
    this.email = email;
    this.whatsappMobile = whatsappMobile;
    this.slack = slack;
    this.telegram = telegram;
    this.fcmTokens = fcmTokens;
    this.onesignalPlayerIds = onesignalPlayerIds;
    this.iosTokens = iosTokens;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @JsonProperty("user_id")
  public String getUserId() {
    return userId;
  }

  @JsonProperty("user_sid")
  public Optional<String> getUserSid() {
    return userSid;
  }

  @JsonProperty("onesignal_external_id")
  public Optional<String> getOnesignalExternalId() {
    return onesignalExternalId;
  }

  @JsonProperty("mobile")
  public Optional<String> getMobile() {
    return mobile;
  }

  @JsonProperty("email")
  public Optional<String> getEmail() {
    return email;
  }

  @JsonProperty("whatsapp_mobile")
  public Optional<String> getWhatsappMobile() {
    return whatsappMobile;
  }

  @JsonProperty("slack")
  public Optional<SlackProfile> getSlack() {
    return slack;
  }

  @JsonProperty("telegram")
  public Optional<TelegramProfile> getTelegram() {
    return telegram;
  }

  @JsonProperty("fcm_tokens")
  public Optional<List<String>> getFcmTokens() {
    return fcmTokens;
  }

  @JsonProperty("onesignal_player_ids")
  public Optional<List<String>> getOnesignalPlayerIds() {
    return onesignalPlayerIds;
  }

  @JsonProperty("ios_tokens")
  public Optional<List<String>> getIosTokens() {
    return iosTokens;
  }

  @JsonProperty("created_at")
  public Optional<Long> getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updated_at")
  public Optional<Long> getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RavenUser && equalTo((RavenUser) other);
  }

  private boolean equalTo(RavenUser other) {
    return userId.equals(other.userId) && userSid.equals(other.userSid) && onesignalExternalId.equals(other.onesignalExternalId) && mobile.equals(other.mobile) && email.equals(other.email) && whatsappMobile.equals(other.whatsappMobile) && slack.equals(other.slack) && telegram.equals(other.telegram) && fcmTokens.equals(other.fcmTokens) && onesignalPlayerIds.equals(other.onesignalPlayerIds) && iosTokens.equals(other.iosTokens) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.userId, this.userSid, this.onesignalExternalId, this.mobile, this.email, this.whatsappMobile, this.slack, this.telegram, this.fcmTokens, this.onesignalPlayerIds, this.iosTokens, this.createdAt, this.updatedAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RavenUser{" + "userId: " + userId + ", userSid: " + userSid + ", onesignalExternalId: " + onesignalExternalId + ", mobile: " + mobile + ", email: " + email + ", whatsappMobile: " + whatsappMobile + ", slack: " + slack + ", telegram: " + telegram + ", fcmTokens: " + fcmTokens + ", onesignalPlayerIds: " + onesignalPlayerIds + ", iosTokens: " + iosTokens + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + "}";
  }

  public static UserIdStage builder() {
    return new Builder();
  }

  public interface UserIdStage {
    _FinalStage userId(String userId);

    Builder from(RavenUser other);
  }

  public interface _FinalStage {
    RavenUser build();

    _FinalStage userSid(Optional<String> userSid);

    _FinalStage userSid(String userSid);

    _FinalStage onesignalExternalId(Optional<String> onesignalExternalId);

    _FinalStage onesignalExternalId(String onesignalExternalId);

    _FinalStage mobile(Optional<String> mobile);

    _FinalStage mobile(String mobile);

    _FinalStage email(Optional<String> email);

    _FinalStage email(String email);

    _FinalStage whatsappMobile(Optional<String> whatsappMobile);

    _FinalStage whatsappMobile(String whatsappMobile);

    _FinalStage slack(Optional<SlackProfile> slack);

    _FinalStage slack(SlackProfile slack);

    _FinalStage telegram(Optional<TelegramProfile> telegram);

    _FinalStage telegram(TelegramProfile telegram);

    _FinalStage fcmTokens(Optional<List<String>> fcmTokens);

    _FinalStage fcmTokens(List<String> fcmTokens);

    _FinalStage onesignalPlayerIds(Optional<List<String>> onesignalPlayerIds);

    _FinalStage onesignalPlayerIds(List<String> onesignalPlayerIds);

    _FinalStage iosTokens(Optional<List<String>> iosTokens);

    _FinalStage iosTokens(List<String> iosTokens);

    _FinalStage createdAt(Optional<Long> createdAt);

    _FinalStage createdAt(Long createdAt);

    _FinalStage updatedAt(Optional<Long> updatedAt);

    _FinalStage updatedAt(Long updatedAt);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements UserIdStage, _FinalStage {
    private String userId;

    private Optional<Long> updatedAt = Optional.empty();

    private Optional<Long> createdAt = Optional.empty();

    private Optional<List<String>> iosTokens = Optional.empty();

    private Optional<List<String>> onesignalPlayerIds = Optional.empty();

    private Optional<List<String>> fcmTokens = Optional.empty();

    private Optional<TelegramProfile> telegram = Optional.empty();

    private Optional<SlackProfile> slack = Optional.empty();

    private Optional<String> whatsappMobile = Optional.empty();

    private Optional<String> email = Optional.empty();

    private Optional<String> mobile = Optional.empty();

    private Optional<String> onesignalExternalId = Optional.empty();

    private Optional<String> userSid = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(RavenUser other) {
      userId(other.getUserId());
      userSid(other.getUserSid());
      onesignalExternalId(other.getOnesignalExternalId());
      mobile(other.getMobile());
      email(other.getEmail());
      whatsappMobile(other.getWhatsappMobile());
      slack(other.getSlack());
      telegram(other.getTelegram());
      fcmTokens(other.getFcmTokens());
      onesignalPlayerIds(other.getOnesignalPlayerIds());
      iosTokens(other.getIosTokens());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      return this;
    }

    @Override
    @JsonSetter("user_id")
    public _FinalStage userId(String userId) {
      this.userId = userId;
      return this;
    }

    @Override
    public _FinalStage updatedAt(Long updatedAt) {
      this.updatedAt = Optional.of(updatedAt);
      return this;
    }

    @Override
    @JsonSetter(
        value = "updated_at",
        nulls = Nulls.SKIP
    )
    public _FinalStage updatedAt(Optional<Long> updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    public _FinalStage createdAt(Long createdAt) {
      this.createdAt = Optional.of(createdAt);
      return this;
    }

    @Override
    @JsonSetter(
        value = "created_at",
        nulls = Nulls.SKIP
    )
    public _FinalStage createdAt(Optional<Long> createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    @Override
    public _FinalStage iosTokens(List<String> iosTokens) {
      this.iosTokens = Optional.of(iosTokens);
      return this;
    }

    @Override
    @JsonSetter(
        value = "ios_tokens",
        nulls = Nulls.SKIP
    )
    public _FinalStage iosTokens(Optional<List<String>> iosTokens) {
      this.iosTokens = iosTokens;
      return this;
    }

    @Override
    public _FinalStage onesignalPlayerIds(List<String> onesignalPlayerIds) {
      this.onesignalPlayerIds = Optional.of(onesignalPlayerIds);
      return this;
    }

    @Override
    @JsonSetter(
        value = "onesignal_player_ids",
        nulls = Nulls.SKIP
    )
    public _FinalStage onesignalPlayerIds(Optional<List<String>> onesignalPlayerIds) {
      this.onesignalPlayerIds = onesignalPlayerIds;
      return this;
    }

    @Override
    public _FinalStage fcmTokens(List<String> fcmTokens) {
      this.fcmTokens = Optional.of(fcmTokens);
      return this;
    }

    @Override
    @JsonSetter(
        value = "fcm_tokens",
        nulls = Nulls.SKIP
    )
    public _FinalStage fcmTokens(Optional<List<String>> fcmTokens) {
      this.fcmTokens = fcmTokens;
      return this;
    }

    @Override
    public _FinalStage telegram(TelegramProfile telegram) {
      this.telegram = Optional.of(telegram);
      return this;
    }

    @Override
    @JsonSetter(
        value = "telegram",
        nulls = Nulls.SKIP
    )
    public _FinalStage telegram(Optional<TelegramProfile> telegram) {
      this.telegram = telegram;
      return this;
    }

    @Override
    public _FinalStage slack(SlackProfile slack) {
      this.slack = Optional.of(slack);
      return this;
    }

    @Override
    @JsonSetter(
        value = "slack",
        nulls = Nulls.SKIP
    )
    public _FinalStage slack(Optional<SlackProfile> slack) {
      this.slack = slack;
      return this;
    }

    @Override
    public _FinalStage whatsappMobile(String whatsappMobile) {
      this.whatsappMobile = Optional.of(whatsappMobile);
      return this;
    }

    @Override
    @JsonSetter(
        value = "whatsapp_mobile",
        nulls = Nulls.SKIP
    )
    public _FinalStage whatsappMobile(Optional<String> whatsappMobile) {
      this.whatsappMobile = whatsappMobile;
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
    public _FinalStage mobile(String mobile) {
      this.mobile = Optional.of(mobile);
      return this;
    }

    @Override
    @JsonSetter(
        value = "mobile",
        nulls = Nulls.SKIP
    )
    public _FinalStage mobile(Optional<String> mobile) {
      this.mobile = mobile;
      return this;
    }

    @Override
    public _FinalStage onesignalExternalId(String onesignalExternalId) {
      this.onesignalExternalId = Optional.of(onesignalExternalId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "onesignal_external_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage onesignalExternalId(Optional<String> onesignalExternalId) {
      this.onesignalExternalId = onesignalExternalId;
      return this;
    }

    @Override
    public _FinalStage userSid(String userSid) {
      this.userSid = Optional.of(userSid);
      return this;
    }

    @Override
    @JsonSetter(
        value = "user_sid",
        nulls = Nulls.SKIP
    )
    public _FinalStage userSid(Optional<String> userSid) {
      this.userSid = userSid;
      return this;
    }

    @Override
    public RavenUser build() {
      return new RavenUser(userId, userSid, onesignalExternalId, mobile, email, whatsappMobile, slack, telegram, fcmTokens, onesignalPlayerIds, iosTokens, createdAt, updatedAt);
    }
  }
}
