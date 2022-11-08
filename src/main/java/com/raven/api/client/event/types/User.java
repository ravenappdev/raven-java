package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

  private final Optional<List<String>> fcmTokens;

  private int _cachedHashCode;

  User(Optional<String> userId, Optional<String> email, Optional<String> mobile,
      Optional<String> whatsappMobile, Optional<String> onesignalExternalId,
      Optional<List<String>> fcmTokens) {
    this.userId = userId;
    this.email = email;
    this.mobile = mobile;
    this.whatsappMobile = whatsappMobile;
    this.onesignalExternalId = onesignalExternalId;
    this.fcmTokens = fcmTokens;
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

  @JsonProperty("fcm_tokens")
  public Optional<List<String>> getFcmTokens() {
    return fcmTokens;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof User && equalTo((User) other);
  }

  private boolean equalTo(User other) {
    return userId.equals(other.userId) && email.equals(other.email) && mobile.equals(other.mobile) && whatsappMobile.equals(other.whatsappMobile) && onesignalExternalId.equals(other.onesignalExternalId) && fcmTokens.equals(other.fcmTokens);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.userId, this.email, this.mobile, this.whatsappMobile, this.onesignalExternalId, this.fcmTokens);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "User{" + "userId: " + userId + ", email: " + email + ", mobile: " + mobile + ", whatsappMobile: " + whatsappMobile + ", onesignalExternalId: " + onesignalExternalId + ", fcmTokens: " + fcmTokens + "}";
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

    private Optional<List<String>> fcmTokens = Optional.empty();

    private Builder() {
    }

    public Builder from(User other) {
      userId(other.getUserId());
      email(other.getEmail());
      mobile(other.getMobile());
      whatsappMobile(other.getWhatsappMobile());
      onesignalExternalId(other.getOnesignalExternalId());
      fcmTokens(other.getFcmTokens());
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

    public User build() {
      return new User(userId, email, mobile, whatsappMobile, onesignalExternalId, fcmTokens);
    }
  }
}
