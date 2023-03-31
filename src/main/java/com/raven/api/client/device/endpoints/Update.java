package com.raven.api.client.device.endpoints;

import com.raven.api.client.AuthKey;
import com.raven.api.client.device.types.Device;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Update {
  private Update() {
  }

  public static final class Request {
    private final String appId;

    private final String userId;

    private final String deviceId;

    private final Device body;

    private final Optional<AuthKey> authOverride;

    private int _cachedHashCode;

    Request(String appId, String userId, String deviceId, Device body,
        Optional<AuthKey> authOverride) {
      this.appId = appId;
      this.userId = userId;
      this.deviceId = deviceId;
      this.body = body;
      this.authOverride = authOverride;
    }

    /**
     * @return your app identifier
     */
    public String getAppId() {
      return appId;
    }

    /**
     * @return your user identifier
     */
    public String getUserId() {
      return userId;
    }

    /**
     * @return your device identifier; the same as device_sid
     */
    public String getDeviceId() {
      return deviceId;
    }

    public Device getBody() {
      return body;
    }

    public Optional<AuthKey> getAuthOverride() {
      return authOverride;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return appId.equals(other.appId) && userId.equals(other.userId) && deviceId.equals(other.deviceId) && body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.appId, this.userId, this.deviceId, this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Update.Request{" + "appId: " + appId + ", userId: " + userId + ", deviceId: " + deviceId + ", body: " + body + ", authOverride: " + authOverride + "}";
    }

    public static AppIdStage builder() {
      return new Builder();
    }

    public interface AppIdStage {
      UserIdStage appId(String appId);

      Builder from(Request other);
    }

    public interface UserIdStage {
      DeviceIdStage userId(String userId);
    }

    public interface DeviceIdStage {
      BodyStage deviceId(String deviceId);
    }

    public interface BodyStage {
      _FinalStage body(Device body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<AuthKey> authOverride);

      _FinalStage authOverride(AuthKey authOverride);
    }

    public static final class Builder implements AppIdStage, UserIdStage, DeviceIdStage, BodyStage, _FinalStage {
      private String appId;

      private String userId;

      private String deviceId;

      private Device body;

      private Optional<AuthKey> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        appId(other.getAppId());
        userId(other.getUserId());
        deviceId(other.getDeviceId());
        body(other.getBody());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>your app identifier</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public UserIdStage appId(String appId) {
        this.appId = appId;
        return this;
      }

      /**
       * <p>your user identifier</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public DeviceIdStage userId(String userId) {
        this.userId = userId;
        return this;
      }

      /**
       * <p>your device identifier; the same as device_sid</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public BodyStage deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
      }

      @Override
      public _FinalStage body(Device body) {
        this.body = body;
        return this;
      }

      @Override
      public _FinalStage authOverride(AuthKey authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<AuthKey> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(appId, userId, deviceId, body, authOverride);
      }
    }
  }
}
