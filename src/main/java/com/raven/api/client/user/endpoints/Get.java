package com.raven.api.client.user.endpoints;

import com.raven.api.client.Authorization;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Get {
  private Get() {
  }

  public static final class Request {
    private final Optional<Authorization> authOverride;

    private final String appId;

    private final String userId;

    private int _cachedHashCode;

    Request(Optional<Authorization> authOverride, String appId, String userId) {
      this.authOverride = authOverride;
      this.appId = appId;
      this.userId = userId;
    }

    public Optional<Authorization> getAuthOverride() {
      return authOverride;
    }

    public String getAppId() {
      return appId;
    }

    public String getUserId() {
      return userId;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && appId.equals(other.appId) && userId.equals(other.userId);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.appId, this.userId);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Get.Request{" + "authOverride: " + authOverride + ", appId: " + appId + ", userId: " + userId + "}";
    }

    public static AppIdStage builder() {
      return new Builder();
    }

    public interface AppIdStage {
      UserIdStage appId(String appId);

      Builder from(Request other);
    }

    public interface UserIdStage {
      _FinalStage userId(String userId);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<Authorization> authOverride);

      _FinalStage authOverride(Authorization authOverride);
    }

    static final class Builder implements AppIdStage, UserIdStage, _FinalStage {
      private String appId;

      private String userId;

      private Optional<Authorization> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        appId(other.getAppId());
        userId(other.getUserId());
        return this;
      }

      @Override
      public UserIdStage appId(String appId) {
        this.appId = appId;
        return this;
      }

      @Override
      public _FinalStage userId(String userId) {
        this.userId = userId;
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
        return new Request(authOverride, appId, userId);
      }
    }
  }
}
