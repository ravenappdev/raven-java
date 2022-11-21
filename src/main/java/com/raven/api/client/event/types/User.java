package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.raven.api.client.user.types.SlackProfile;
import com.raven.api.client.user.types.TelegramProfile;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = User.Builder.class
)
public final class User {
  private final Optional<String> userId;

  private final Optional<String> email;

  private final Optional<String> mobile;

  private final Optional<String> whatsappMobile;

  private final Optional<String> onesignalExternalId;

  private final Optional<List<String>> onesignalPlayerIds;

  private final Optional<List<String>> fcmTokens;

  private final Optional<List<String>> iosTokens;

  private final Optional<SlackProfile> slack;

  private final Optional<TelegramProfile> telegram;

  private final Optional<String> fcmTopic;

  private final Optional<String> fcmDeviceGroup;

  private int _cachedHashCode;

  User(Optional<String> userId, Optional<String> email, Optional<String> mobile,
      Optional<String> whatsappMobile, Optional<String> onesignalExternalId,
      Optional<List<String>> onesignalPlayerIds, Optional<List<String>> fcmTokens,
      Optional<List<String>> iosTokens, Optional<SlackProfile> slack,
      Optional<TelegramProfile> telegram, Optional<String> fcmTopic,
      Optional<String> fcmDeviceGroup) {
    this.userId = userId;
    this.email = email;
    this.mobile = mobile;
    this.whatsappMobile = whatsappMobile;
    this.onesignalExternalId = onesignalExternalId;
    this.onesignalPlayerIds = onesignalPlayerIds;
    this.fcmTokens = fcmTokens;
    this.iosTokens = iosTokens;
    this.slack = slack;
    this.telegram = telegram;
    this.fcmTopic = fcmTopic;
    this.fcmDeviceGroup = fcmDeviceGroup;
  }

  @JsonProperty("user_id")
  public Optional<String> getUserId() {
    return userId;
  }

  @JsonProperty("email")
  public Optional<String> getEmail() {
    return email;
  }

  @JsonProperty("mobile")
  public Optional<String> getMobile() {
    return mobile;
  }

  @JsonProperty("whatsapp_mobile")
  public Optional<String> getWhatsappMobile() {
    return whatsappMobile;
  }

  @JsonProperty("onesignal_external_id")
  public Optional<String> getOnesignalExternalId() {
    return onesignalExternalId;
  }

  @JsonProperty("onesignal_player_ids")
  public Optional<List<String>> getOnesignalPlayerIds() {
    return onesignalPlayerIds;
  }

  @JsonProperty("fcm_tokens")
  public Optional<List<String>> getFcmTokens() {
    return fcmTokens;
  }

  @JsonProperty("ios_tokens")
  public Optional<List<String>> getIosTokens() {
    return iosTokens;
  }

  @JsonProperty("slack")
  public Optional<SlackProfile> getSlack() {
    return slack;
  }

  @JsonProperty("telegram")
  public Optional<TelegramProfile> getTelegram() {
    return telegram;
  }

  @JsonProperty("fcm_topic")
  public Optional<String> getFcmTopic() {
    return fcmTopic;
  }

  @JsonProperty("fcm_device_group")
  public Optional<String> getFcmDeviceGroup() {
    return fcmDeviceGroup;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof User && equalTo((User) other);
  }

  private boolean equalTo(User other) {
    return userId.equals(other.userId) && email.equals(other.email) && mobile.equals(other.mobile) && whatsappMobile.equals(other.whatsappMobile) && onesignalExternalId.equals(other.onesignalExternalId) && onesignalPlayerIds.equals(other.onesignalPlayerIds) && fcmTokens.equals(other.fcmTokens) && iosTokens.equals(other.iosTokens) && slack.equals(other.slack) && telegram.equals(other.telegram) && fcmTopic.equals(other.fcmTopic) && fcmDeviceGroup.equals(other.fcmDeviceGroup);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.userId, this.email, this.mobile, this.whatsappMobile, this.onesignalExternalId, this.onesignalPlayerIds, this.fcmTokens, this.iosTokens, this.slack, this.telegram, this.fcmTopic, this.fcmDeviceGroup);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "User{" + "userId: " + userId + ", email: " + email + ", mobile: " + mobile + ", whatsappMobile: " + whatsappMobile + ", onesignalExternalId: " + onesignalExternalId + ", onesignalPlayerIds: " + onesignalPlayerIds + ", fcmTokens: " + fcmTokens + ", iosTokens: " + iosTokens + ", slack: " + slack + ", telegram: " + telegram + ", fcmTopic: " + fcmTopic + ", fcmDeviceGroup: " + fcmDeviceGroup + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> userId = Optional.empty();

    private Optional<String> email = Optional.empty();

    private Optional<String> mobile = Optional.empty();

    private Optional<String> whatsappMobile = Optional.empty();

    private Optional<String> onesignalExternalId = Optional.empty();

    private Optional<List<String>> onesignalPlayerIds = Optional.empty();

    private Optional<List<String>> fcmTokens = Optional.empty();

    private Optional<List<String>> iosTokens = Optional.empty();

    private Optional<SlackProfile> slack = Optional.empty();

    private Optional<TelegramProfile> telegram = Optional.empty();

    private Optional<String> fcmTopic = Optional.empty();

    private Optional<String> fcmDeviceGroup = Optional.empty();

    private Builder() {
    }

    public Builder from(User other) {
      userId(other.getUserId());
      email(other.getEmail());
      mobile(other.getMobile());
      whatsappMobile(other.getWhatsappMobile());
      onesignalExternalId(other.getOnesignalExternalId());
      onesignalPlayerIds(other.getOnesignalPlayerIds());
      fcmTokens(other.getFcmTokens());
      iosTokens(other.getIosTokens());
      slack(other.getSlack());
      telegram(other.getTelegram());
      fcmTopic(other.getFcmTopic());
      fcmDeviceGroup(other.getFcmDeviceGroup());
      return this;
    }

    @JsonSetter(
        value = "user_id",
        nulls = Nulls.SKIP
    )
    public Builder userId(Optional<String> userId) {
      this.userId = userId;
      return this;
    }

    public Builder userId(String userId) {
      this.userId = Optional.of(userId);
      return this;
    }

    @JsonSetter(
        value = "email",
        nulls = Nulls.SKIP
    )
    public Builder email(Optional<String> email) {
      this.email = email;
      return this;
    }

    public Builder email(String email) {
      this.email = Optional.of(email);
      return this;
    }

    @JsonSetter(
        value = "mobile",
        nulls = Nulls.SKIP
    )
    public Builder mobile(Optional<String> mobile) {
      this.mobile = mobile;
      return this;
    }

    public Builder mobile(String mobile) {
      this.mobile = Optional.of(mobile);
      return this;
    }

    @JsonSetter(
        value = "whatsapp_mobile",
        nulls = Nulls.SKIP
    )
    public Builder whatsappMobile(Optional<String> whatsappMobile) {
      this.whatsappMobile = whatsappMobile;
      return this;
    }

    public Builder whatsappMobile(String whatsappMobile) {
      this.whatsappMobile = Optional.of(whatsappMobile);
      return this;
    }

    @JsonSetter(
        value = "onesignal_external_id",
        nulls = Nulls.SKIP
    )
    public Builder onesignalExternalId(Optional<String> onesignalExternalId) {
      this.onesignalExternalId = onesignalExternalId;
      return this;
    }

    public Builder onesignalExternalId(String onesignalExternalId) {
      this.onesignalExternalId = Optional.of(onesignalExternalId);
      return this;
    }

    @JsonSetter(
        value = "onesignal_player_ids",
        nulls = Nulls.SKIP
    )
    public Builder onesignalPlayerIds(Optional<List<String>> onesignalPlayerIds) {
      this.onesignalPlayerIds = onesignalPlayerIds;
      return this;
    }

    public Builder onesignalPlayerIds(List<String> onesignalPlayerIds) {
      this.onesignalPlayerIds = Optional.of(onesignalPlayerIds);
      return this;
    }

    @JsonSetter(
        value = "fcm_tokens",
        nulls = Nulls.SKIP
    )
    public Builder fcmTokens(Optional<List<String>> fcmTokens) {
      this.fcmTokens = fcmTokens;
      return this;
    }

    public Builder fcmTokens(List<String> fcmTokens) {
      this.fcmTokens = Optional.of(fcmTokens);
      return this;
    }

    @JsonSetter(
        value = "ios_tokens",
        nulls = Nulls.SKIP
    )
    public Builder iosTokens(Optional<List<String>> iosTokens) {
      this.iosTokens = iosTokens;
      return this;
    }

    public Builder iosTokens(List<String> iosTokens) {
      this.iosTokens = Optional.of(iosTokens);
      return this;
    }

    @JsonSetter(
        value = "slack",
        nulls = Nulls.SKIP
    )
    public Builder slack(Optional<SlackProfile> slack) {
      this.slack = slack;
      return this;
    }

    public Builder slack(SlackProfile slack) {
      this.slack = Optional.of(slack);
      return this;
    }

    @JsonSetter(
        value = "telegram",
        nulls = Nulls.SKIP
    )
    public Builder telegram(Optional<TelegramProfile> telegram) {
      this.telegram = telegram;
      return this;
    }

    public Builder telegram(TelegramProfile telegram) {
      this.telegram = Optional.of(telegram);
      return this;
    }

    @JsonSetter(
        value = "fcm_topic",
        nulls = Nulls.SKIP
    )
    public Builder fcmTopic(Optional<String> fcmTopic) {
      this.fcmTopic = fcmTopic;
      return this;
    }

    public Builder fcmTopic(String fcmTopic) {
      this.fcmTopic = Optional.of(fcmTopic);
      return this;
    }

    @JsonSetter(
        value = "fcm_device_group",
        nulls = Nulls.SKIP
    )
    public Builder fcmDeviceGroup(Optional<String> fcmDeviceGroup) {
      this.fcmDeviceGroup = fcmDeviceGroup;
      return this;
    }

    public Builder fcmDeviceGroup(String fcmDeviceGroup) {
      this.fcmDeviceGroup = Optional.of(fcmDeviceGroup);
      return this;
    }

    public User build() {
      return new User(userId, email, mobile, whatsappMobile, onesignalExternalId, onesignalPlayerIds, fcmTokens, iosTokens, slack, telegram, fcmTopic, fcmDeviceGroup);
    }
  }
}
