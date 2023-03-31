package com.raven.api;

import com.raven.api.client.AuthKey;
import com.raven.api.client.ServiceClient;
import com.raven.api.client.device.DeviceServiceClient;
import com.raven.api.client.user.UserServiceClient;
import com.raven.api.core.Environment;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class RavenApiClient {
  private final Supplier<ServiceClient> serviceClient;

  private final Supplier<DeviceServiceClient> deviceServiceClient;

  private final Supplier<UserServiceClient> userServiceClient;

  public RavenApiClient(AuthKey auth) {
    this(Environment.PROD, auth);
  }

  public RavenApiClient(Environment environment, AuthKey auth) {
    this.userServiceClient = memoize(() -> new UserServiceClient(environment.getUrl(), auth));
    this.serviceClient = memoize(() -> new ServiceClient(environment.getUrl(), auth));
    this.deviceServiceClient = memoize(() -> new DeviceServiceClient(environment.getUrl(), auth));
  }

  public final ServiceClient service() {
    return this.serviceClient.get();
  }

  public final DeviceServiceClient device() {
    return this.deviceServiceClient.get();
  }

  public final UserServiceClient user() {
    return this.userServiceClient.get();
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
