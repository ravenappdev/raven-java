package com.raven.api.resources.device.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Device.Builder.class
)
public final class Device {
  private final Optional<String> id;

  private final Optional<Platform> platform;

  private final Optional<String> onesignalPlayerId;

  private final Optional<String> xiaomiToken;

  private final Optional<String> oppoToken;

  private final Optional<String> vivoToken;

  private final Optional<String> huaweiToken;

  private final Optional<String> fcmToken;

  private final Optional<String> ravenId;

  private final Optional<String> deviceSid;

  private final Optional<Boolean> notificationsDisabled;

  private final Optional<Long> createdAt;

  private final Optional<Long> updatedAt;

  private int _cachedHashCode;

  Device(Optional<String> id, Optional<Platform> platform, Optional<String> onesignalPlayerId,
      Optional<String> xiaomiToken, Optional<String> oppoToken, Optional<String> vivoToken,
      Optional<String> huaweiToken, Optional<String> fcmToken, Optional<String> ravenId,
      Optional<String> deviceSid, Optional<Boolean> notificationsDisabled, Optional<Long> createdAt,
      Optional<Long> updatedAt) {
    this.id = id;
    this.platform = platform;
    this.onesignalPlayerId = onesignalPlayerId;
    this.xiaomiToken = xiaomiToken;
    this.oppoToken = oppoToken;
    this.vivoToken = vivoToken;
    this.huaweiToken = huaweiToken;
    this.fcmToken = fcmToken;
    this.ravenId = ravenId;
    this.deviceSid = deviceSid;
    this.notificationsDisabled = notificationsDisabled;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @JsonProperty("id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("platform")
  public Optional<Platform> getPlatform() {
    return platform;
  }

  @JsonProperty("onesignal_player_id")
  public Optional<String> getOnesignalPlayerId() {
    return onesignalPlayerId;
  }

  @JsonProperty("xiaomi_token")
  public Optional<String> getXiaomiToken() {
    return xiaomiToken;
  }

  @JsonProperty("oppo_token")
  public Optional<String> getOppoToken() {
    return oppoToken;
  }

  @JsonProperty("vivo_token")
  public Optional<String> getVivoToken() {
    return vivoToken;
  }

  @JsonProperty("huaweiToken")
  public Optional<String> getHuaweiToken() {
    return huaweiToken;
  }

  /**
   * @return firebase device token
   */
  @JsonProperty("fcm_token")
  public Optional<String> getFcmToken() {
    return fcmToken;
  }

  /**
   * @return user id affiliated with device
   */
  @JsonProperty("raven_id")
  public Optional<String> getRavenId() {
    return ravenId;
  }

  @JsonProperty("device_sid")
  public Optional<String> getDeviceSid() {
    return deviceSid;
  }

  @JsonProperty("notifications_disabled")
  public Optional<Boolean> getNotificationsDisabled() {
    return notificationsDisabled;
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
    return other instanceof Device && equalTo((Device) other);
  }

  private boolean equalTo(Device other) {
    return id.equals(other.id) && platform.equals(other.platform) && onesignalPlayerId.equals(other.onesignalPlayerId) && xiaomiToken.equals(other.xiaomiToken) && oppoToken.equals(other.oppoToken) && vivoToken.equals(other.vivoToken) && huaweiToken.equals(other.huaweiToken) && fcmToken.equals(other.fcmToken) && ravenId.equals(other.ravenId) && deviceSid.equals(other.deviceSid) && notificationsDisabled.equals(other.notificationsDisabled) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.platform, this.onesignalPlayerId, this.xiaomiToken, this.oppoToken, this.vivoToken, this.huaweiToken, this.fcmToken, this.ravenId, this.deviceSid, this.notificationsDisabled, this.createdAt, this.updatedAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Device{" + "id: " + id + ", platform: " + platform + ", onesignalPlayerId: " + onesignalPlayerId + ", xiaomiToken: " + xiaomiToken + ", oppoToken: " + oppoToken + ", vivoToken: " + vivoToken + ", huaweiToken: " + huaweiToken + ", fcmToken: " + fcmToken + ", ravenId: " + ravenId + ", deviceSid: " + deviceSid + ", notificationsDisabled: " + notificationsDisabled + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> id = Optional.empty();

    private Optional<Platform> platform = Optional.empty();

    private Optional<String> onesignalPlayerId = Optional.empty();

    private Optional<String> xiaomiToken = Optional.empty();

    private Optional<String> oppoToken = Optional.empty();

    private Optional<String> vivoToken = Optional.empty();

    private Optional<String> huaweiToken = Optional.empty();

    private Optional<String> fcmToken = Optional.empty();

    private Optional<String> ravenId = Optional.empty();

    private Optional<String> deviceSid = Optional.empty();

    private Optional<Boolean> notificationsDisabled = Optional.empty();

    private Optional<Long> createdAt = Optional.empty();

    private Optional<Long> updatedAt = Optional.empty();

    private Builder() {
    }

    public Builder from(Device other) {
      id(other.getId());
      platform(other.getPlatform());
      onesignalPlayerId(other.getOnesignalPlayerId());
      xiaomiToken(other.getXiaomiToken());
      oppoToken(other.getOppoToken());
      vivoToken(other.getVivoToken());
      huaweiToken(other.getHuaweiToken());
      fcmToken(other.getFcmToken());
      ravenId(other.getRavenId());
      deviceSid(other.getDeviceSid());
      notificationsDisabled(other.getNotificationsDisabled());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      return this;
    }

    @JsonSetter(
        value = "id",
        nulls = Nulls.SKIP
    )
    public Builder id(Optional<String> id) {
      this.id = id;
      return this;
    }

    public Builder id(String id) {
      this.id = Optional.of(id);
      return this;
    }

    @JsonSetter(
        value = "platform",
        nulls = Nulls.SKIP
    )
    public Builder platform(Optional<Platform> platform) {
      this.platform = platform;
      return this;
    }

    public Builder platform(Platform platform) {
      this.platform = Optional.of(platform);
      return this;
    }

    @JsonSetter(
        value = "onesignal_player_id",
        nulls = Nulls.SKIP
    )
    public Builder onesignalPlayerId(Optional<String> onesignalPlayerId) {
      this.onesignalPlayerId = onesignalPlayerId;
      return this;
    }

    public Builder onesignalPlayerId(String onesignalPlayerId) {
      this.onesignalPlayerId = Optional.of(onesignalPlayerId);
      return this;
    }

    @JsonSetter(
        value = "xiaomi_token",
        nulls = Nulls.SKIP
    )
    public Builder xiaomiToken(Optional<String> xiaomiToken) {
      this.xiaomiToken = xiaomiToken;
      return this;
    }

    public Builder xiaomiToken(String xiaomiToken) {
      this.xiaomiToken = Optional.of(xiaomiToken);
      return this;
    }

    @JsonSetter(
        value = "oppo_token",
        nulls = Nulls.SKIP
    )
    public Builder oppoToken(Optional<String> oppoToken) {
      this.oppoToken = oppoToken;
      return this;
    }

    public Builder oppoToken(String oppoToken) {
      this.oppoToken = Optional.of(oppoToken);
      return this;
    }

    @JsonSetter(
        value = "vivo_token",
        nulls = Nulls.SKIP
    )
    public Builder vivoToken(Optional<String> vivoToken) {
      this.vivoToken = vivoToken;
      return this;
    }

    public Builder vivoToken(String vivoToken) {
      this.vivoToken = Optional.of(vivoToken);
      return this;
    }

    @JsonSetter(
        value = "huaweiToken",
        nulls = Nulls.SKIP
    )
    public Builder huaweiToken(Optional<String> huaweiToken) {
      this.huaweiToken = huaweiToken;
      return this;
    }

    public Builder huaweiToken(String huaweiToken) {
      this.huaweiToken = Optional.of(huaweiToken);
      return this;
    }

    @JsonSetter(
        value = "fcm_token",
        nulls = Nulls.SKIP
    )
    public Builder fcmToken(Optional<String> fcmToken) {
      this.fcmToken = fcmToken;
      return this;
    }

    public Builder fcmToken(String fcmToken) {
      this.fcmToken = Optional.of(fcmToken);
      return this;
    }

    @JsonSetter(
        value = "raven_id",
        nulls = Nulls.SKIP
    )
    public Builder ravenId(Optional<String> ravenId) {
      this.ravenId = ravenId;
      return this;
    }

    public Builder ravenId(String ravenId) {
      this.ravenId = Optional.of(ravenId);
      return this;
    }

    @JsonSetter(
        value = "device_sid",
        nulls = Nulls.SKIP
    )
    public Builder deviceSid(Optional<String> deviceSid) {
      this.deviceSid = deviceSid;
      return this;
    }

    public Builder deviceSid(String deviceSid) {
      this.deviceSid = Optional.of(deviceSid);
      return this;
    }

    @JsonSetter(
        value = "notifications_disabled",
        nulls = Nulls.SKIP
    )
    public Builder notificationsDisabled(Optional<Boolean> notificationsDisabled) {
      this.notificationsDisabled = notificationsDisabled;
      return this;
    }

    public Builder notificationsDisabled(Boolean notificationsDisabled) {
      this.notificationsDisabled = Optional.of(notificationsDisabled);
      return this;
    }

    @JsonSetter(
        value = "created_at",
        nulls = Nulls.SKIP
    )
    public Builder createdAt(Optional<Long> createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Builder createdAt(Long createdAt) {
      this.createdAt = Optional.of(createdAt);
      return this;
    }

    @JsonSetter(
        value = "updated_at",
        nulls = Nulls.SKIP
    )
    public Builder updatedAt(Optional<Long> updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Builder updatedAt(Long updatedAt) {
      this.updatedAt = Optional.of(updatedAt);
      return this;
    }

    public Device build() {
      return new Device(id, platform, onesignalPlayerId, xiaomiToken, oppoToken, vivoToken, huaweiToken, fcmToken, ravenId, deviceSid, notificationsDisabled, createdAt, updatedAt);
    }
  }
}
