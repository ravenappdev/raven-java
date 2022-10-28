package com.raven.api.client.device.endpoints;

import com.raven.api.client.Authorization;
import com.raven.api.client.ids.types.AppId;
import com.raven.api.client.ids.types.DeviceId;
import com.raven.api.client.ids.types.UserId;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Delete {
  private Delete() {
  }

  public static final class Request {
    private final Optional<Authorization> authOverride;

    private final AppId appId;

    private final UserId userId;

    private final DeviceId deviceId;

    private int _cachedHashCode;

    Request(Optional<Authorization> authOverride, AppId appId, UserId userId, DeviceId deviceId) {
      this.authOverride = authOverride;
      this.appId = appId;
      this.userId = userId;
      this.deviceId = deviceId;
    }

    public Optional<Authorization> getAuthOverride() {
      return authOverride;
    }

    public AppId getAppId() {
      return appId;
    }

    public UserId getUserId() {
      return userId;
    }

    public DeviceId getDeviceId() {
      return deviceId;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && appId.equals(other.appId) && userId.equals(other.userId) && deviceId.equals(other.deviceId);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.appId, this.userId, this.deviceId);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Delete.Request{" + "authOverride: " + authOverride + ", appId: " + appId + ", userId: " + userId + ", deviceId: " + deviceId + "}";
    }

    public static AppIdStage builder() {
      return new Builder();
    }

    public interface AppIdStage {
      UserIdStage appId(AppId appId);

      Builder from(Request other);
    }

    public interface UserIdStage {
      DeviceIdStage userId(UserId userId);
    }

    public interface DeviceIdStage {
      _FinalStage deviceId(DeviceId deviceId);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<Authorization> authOverride);

      _FinalStage authOverride(Authorization authOverride);
    }

    static final class Builder implements AppIdStage, UserIdStage, DeviceIdStage, _FinalStage {
      private AppId appId;

      private UserId userId;

      private DeviceId deviceId;

      private Optional<Authorization> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        appId(other.getAppId());
        userId(other.getUserId());
        deviceId(other.getDeviceId());
        return this;
      }

      @Override
      public UserIdStage appId(AppId appId) {
        this.appId = appId;
        return this;
      }

      @Override
      public DeviceIdStage userId(UserId userId) {
        this.userId = userId;
        return this;
      }

      @Override
      public _FinalStage deviceId(DeviceId deviceId) {
        this.deviceId = deviceId;
        return this;
      }

      @Override
      public _FinalStage authOverride(Authorization authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<Authorization> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(authOverride, appId, userId, deviceId);
      }
    }
  }
}
