package com.raven.api;

import com.raven.api.client.Authorization;
import com.raven.api.client.device.DeviceServiceClient;
import com.raven.api.client.event.EventServiceClient;
import com.raven.api.client.event.endpoints.Send;
import com.raven.api.client.event.endpoints.SendBulk;
import com.raven.api.client.event.exceptions.SendBulkException;
import com.raven.api.client.event.exceptions.SendException;
import com.raven.api.client.event.types.SendEventResponse;
import com.raven.api.client.user.UserServiceClient;
import java.lang.String;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class RavenApiClient {
  private final Supplier<DeviceServiceClient> deviceServiceClient;

  private final Supplier<EventServiceClient> eventServiceClient;

  private final Supplier<UserServiceClient> userServiceClient;

  public RavenApiClient(String url) {
    this.userServiceClient = memoize(() -> new UserServiceClient(url));
    this.eventServiceClient = memoize(() -> new EventServiceClient(url));
    this.deviceServiceClient = memoize(() -> new DeviceServiceClient(url));
  }

  public RavenApiClient(String url, Authorization auth) {
    this.userServiceClient = memoize(() -> new UserServiceClient(url, auth));
    this.eventServiceClient = memoize(() -> new EventServiceClient(url, auth));
    this.deviceServiceClient = memoize(() -> new DeviceServiceClient(url, auth));
  }

  public final DeviceServiceClient device() {
    return this.deviceServiceClient.get();
  }

  public final EventServiceClient event() {
    return this.eventServiceClient.get();
  }

  public final UserServiceClient user() {
    return this.userServiceClient.get();
  }

  public SendEventResponse send(Send.Request request) throws SendException {
    return event().send(request);
  }

  public SendEventResponse sendBulk(SendBulk.Request request) throws SendBulkException {
    return event().sendBulk(request);
  }

  private static <T> Supplier<T> memoize(Supplier<T> delegate) {
    AtomicReference<T> value = new AtomicReference<>();
    return () ->  {
      T val = value.get();
      if (val == null) {
        val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
      }
      return val;
    } ;
  }
}
