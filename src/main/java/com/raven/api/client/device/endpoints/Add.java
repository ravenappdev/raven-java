package com.raven.api.client.device.endpoints;

import com.raven.api.client.Authorization;
import com.raven.api.client.device.types.Device;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Add {
  private Add() {
  }

  public static final class Request {
    private final String appId;

    private final String userId;

    private final Device body;

    private final Optional<Authorization> authOverride;

    private int _cachedHashCode;

    Request(String appId, String userId, Device body, Optional<Authorization> authOverride) {
      this.appId = appId;
      this.userId = userId;
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

    public Device getBody() {
      return body;
    }

    public Optional<Authorization> getAuthOverride() {
      return authOverride;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return appId.equals(other.appId) && userId.equals(other.userId) && body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.appId, this.userId, this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Add.Request{" + "appId: " + appId + ", userId: " + userId + ", body: " + body + ", authOverride: " + authOverride + "}";
    }

    public static AppIdStage builder() {
      return new Builder();
    }

    public interface AppIdStage {
      UserIdStage appId(String appId);

      Builder from(Request other);
    }

    public interface UserIdStage {
      BodyStage userId(String userId);
    }

    public interface BodyStage {
      _FinalStage body(Device body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<Authorization> authOverride);

      _FinalStage authOverride(Authorization authOverride);
    }

    public static final class Builder implements AppIdStage, UserIdStage, BodyStage, _FinalStage {
      private String appId;

      private String userId;

      private Device body;

      private Optional<Authorization> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        appId(other.getAppId());
        userId(other.getUserId());
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
      public BodyStage userId(String userId) {
        this.userId = userId;
        return this;
      }

      @Override
      public _FinalStage body(Device body) {
        this.body = body;
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
        return new Request(appId, userId, body, authOverride);
      }
    }
  }
}
