package com.raven.api.client.user.endpoints;

import com.raven.api.client.Authorization;
import com.raven.api.client.user.types.CreateUserRequest;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class CreateOrUpdate {
  private CreateOrUpdate() {
  }

  public static final class Request {
    private final Optional<Authorization> authOverride;

    private final String appId;

    private final CreateUserRequest body;

    private int _cachedHashCode;

    Request(Optional<Authorization> authOverride, String appId, CreateUserRequest body) {
      this.authOverride = authOverride;
      this.appId = appId;
      this.body = body;
    }

    public Optional<Authorization> getAuthOverride() {
      return authOverride;
    }

    public String getAppId() {
      return appId;
    }

    public CreateUserRequest getBody() {
      return body;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && appId.equals(other.appId) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.appId, this.body);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "CreateOrUpdate.Request{" + "authOverride: " + authOverride + ", appId: " + appId + ", body: " + body + "}";
    }

    public static AppIdStage builder() {
      return new Builder();
    }

    public interface AppIdStage {
      BodyStage appId(String appId);

      Builder from(Request other);
    }

    public interface BodyStage {
      _FinalStage body(CreateUserRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<Authorization> authOverride);

      _FinalStage authOverride(Authorization authOverride);
    }

    static final class Builder implements AppIdStage, BodyStage, _FinalStage {
      private String appId;

      private CreateUserRequest body;

      private Optional<Authorization> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        appId(other.getAppId());
        body(other.getBody());
        return this;
      }

      @Override
      public BodyStage appId(String appId) {
        this.appId = appId;
        return this;
      }

      @Override
      public _FinalStage body(CreateUserRequest body) {
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
        return new Request(authOverride, appId, body);
      }
    }
  }
}
