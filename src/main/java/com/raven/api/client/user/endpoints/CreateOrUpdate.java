package com.raven.api.client.user.endpoints;

import com.raven.api.client.AuthKey;
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
    private final String appId;

    private final CreateUserRequest body;

    private final Optional<AuthKey> authOverride;

    private int _cachedHashCode;

    Request(String appId, CreateUserRequest body, Optional<AuthKey> authOverride) {
      this.appId = appId;
      this.body = body;
      this.authOverride = authOverride;
    }

    public String getAppId() {
      return appId;
    }

    public CreateUserRequest getBody() {
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
      return appId.equals(other.appId) && body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.appId, this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "CreateOrUpdate.Request{" + "appId: " + appId + ", body: " + body + ", authOverride: " + authOverride + "}";
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

      _FinalStage authOverride(Optional<AuthKey> authOverride);

      _FinalStage authOverride(AuthKey authOverride);
    }

    public static final class Builder implements AppIdStage, BodyStage, _FinalStage {
      private String appId;

      private CreateUserRequest body;

      private Optional<AuthKey> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        appId(other.getAppId());
        body(other.getBody());
        authOverride(other.getAuthOverride());
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
        return new Request(appId, body, authOverride);
      }
    }
  }
}
