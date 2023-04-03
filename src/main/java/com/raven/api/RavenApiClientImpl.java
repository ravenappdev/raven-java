package com.raven.api;

import com.raven.api.core.ClientOptions;
import com.raven.api.core.Environment;
import com.raven.api.core.ObjectMappers;
import com.raven.api.core.Suppliers;
import com.raven.api.resources.device.DeviceClient;
import com.raven.api.resources.device.DeviceClientImpl;
import com.raven.api.resources.requests.BulkSendEventRequest;
import com.raven.api.resources.requests.SendEventRequest;
import com.raven.api.resources.types.SendEventResponse;
import com.raven.api.resources.user.UserClient;
import com.raven.api.resources.user.UserClientImpl;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class RavenApiClientImpl implements RavenApiClient {
  private final ClientOptions clientOptions;

  private final Supplier<DeviceClient> deviceClient;

  private final Supplier<UserClient> userClient;

  public RavenApiClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.deviceClient = Suppliers.memoize(() -> new DeviceClientImpl(clientOptions));
    this.userClient = Suppliers.memoize(() -> new UserClientImpl(clientOptions));
  }

  @Override
  public SendEventResponse send(String appId, SendEventRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("v1/apps")
      .addPathSegment(appId)
      .addPathSegments("events/send")
      ;HttpUrl _httpUrl = _httpUrlBuilder.build();
      Map<String, Object> _requestBodyProperties = new HashMap<>();
      _requestBodyProperties.put("event", request.getEvent());
      _requestBodyProperties.put("data", request.getData());
      _requestBodyProperties.put("user", request.getUser());
      _requestBodyProperties.put("scheduleAt", request.getScheduleAt());
      _requestBodyProperties.put("override", request.getOverride());
      RequestBody _requestBody;
      try {
        _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties), MediaType.parse("application/json"));
      }
      catch(Exception e) {
        throw new RuntimeException(e);
      }
      Request.Builder _requestBuilder = new Request.Builder()
        .url(_httpUrl)
        .method("POST", _requestBody)
        .headers(Headers.of(clientOptions.headers()));
      if (request.getIdempotencyKey().isPresent()) {
        _requestBuilder.addHeader("Idempotency-Key", request.getIdempotencyKey().get());
      }
      Request _request = _requestBuilder.build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SendEventResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public SendEventResponse sendBulk(String appId, BulkSendEventRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("v1/apps")
        .addPathSegment(appId)
        .addPathSegments("events/bulk_send")
        ;HttpUrl _httpUrl = _httpUrlBuilder.build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("event", request.getEvent());
        _requestBodyProperties.put("batch", request.getBatch());
        RequestBody _requestBody;
        try {
          _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties), MediaType.parse("application/json"));
        }
        catch(Exception e) {
          throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
          .url(_httpUrl)
          .method("POST", _requestBody)
          .headers(Headers.of(clientOptions.headers()));
        if (request.getIdempotencyKey().isPresent()) {
          _requestBuilder.addHeader("Idempotency-Key", request.getIdempotencyKey().get());
        }
        Request _request = _requestBuilder.build();
        try {
          Response _response = clientOptions.httpClient().newCall(_request).execute();
          if (_response.isSuccessful()) {
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SendEventResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public DeviceClient device() {
        return this.deviceClient.get();
      }

      @Override
      public UserClient user() {
        return this.userClient.get();
      }

      public static final class Builder implements RavenApiClient.Builder {
        ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

        Environment environment = Environment.PROD;

        @Override
        public RavenApiClient.Builder authKey(String authKey) {
          this.clientOptionsBuilder.addHeader("Authorization", authKey);
          return this;
        }

        @Override
        public RavenApiClient.Builder environment(Environment environment) {
          this.environment = environment;
          return this;
        }

        @Override
        public RavenApiClient.Builder url(String url) {
          this.environment = Environment.custom(url);
          return this;
        }

        @Override
        public RavenApiClient build() {
          clientOptionsBuilder.environment(this.environment);
          return new RavenApiClientImpl(clientOptionsBuilder.build());
        }
      }
    }
