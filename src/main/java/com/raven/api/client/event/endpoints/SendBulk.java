package com.raven.api.client.event.endpoints;

import com.raven.api.client.Authorization;
import com.raven.api.client.event.types.BulkSendEventRequest;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class SendBulk {
  private SendBulk() {
  }

  public static final class Request {
    private final Optional<Authorization> authOverride;

    private final Optional<String> idempotencyKey;

    private final String appId;

    private final BulkSendEventRequest body;

    private int _cachedHashCode;

    Request(Optional<Authorization> authOverride, Optional<String> idempotencyKey, String appId,
        BulkSendEventRequest body) {
      this.authOverride = authOverride;
      this.idempotencyKey = idempotencyKey;
      this.appId = appId;
      this.body = body;
    }

    public Optional<Authorization> getAuthOverride() {
      return authOverride;
    }

    public Optional<String> getIdempotencyKey() {
      return idempotencyKey;
    }

    public String getAppId() {
      return appId;
    }

    public BulkSendEventRequest getBody() {
      return body;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && idempotencyKey.equals(other.idempotencyKey) && appId.equals(other.appId) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.idempotencyKey, this.appId, this.body);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "SendBulk.Request{" + "authOverride: " + authOverride + ", idempotencyKey: " + idempotencyKey + ", appId: " + appId + ", body: " + body + "}";
    }

    public static AppIdStage builder() {
      return new Builder();
    }

    public interface AppIdStage {
      BodyStage appId(String appId);

      Builder from(Request other);
    }

    public interface BodyStage {
      _FinalStage body(BulkSendEventRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<Authorization> authOverride);

      _FinalStage authOverride(Authorization authOverride);

      _FinalStage idempotencyKey(Optional<String> idempotencyKey);

      _FinalStage idempotencyKey(String idempotencyKey);
    }

    static final class Builder implements AppIdStage, BodyStage, _FinalStage {
      private String appId;

      private BulkSendEventRequest body;

      private Optional<String> idempotencyKey = Optional.empty();

      private Optional<Authorization> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        idempotencyKey(other.getIdempotencyKey());
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
      public _FinalStage body(BulkSendEventRequest body) {
        this.body = body;
        return this;
      }

      @Override
      public _FinalStage idempotencyKey(String idempotencyKey) {
        this.idempotencyKey = Optional.of(idempotencyKey);
        return this;
      }

      @Override
      public _FinalStage idempotencyKey(Optional<String> idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
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
        return new Request(authOverride, idempotencyKey, appId, body);
      }
    }
  }
}
