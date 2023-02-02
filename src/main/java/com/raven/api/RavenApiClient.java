package com.raven.api;

import com.raven.api.client.Authorization;
import com.raven.api.client.ServiceClient;
import com.raven.api.client.device.deviceServiceClient;
import com.raven.api.client.user.userServiceClient;
import com.raven.api.core.Environment;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class RavenApiClient {
  private final Supplier<ServiceClient> serviceClient;

  private final Supplier<deviceServiceClient> deviceServiceClient;

  private final Supplier<userServiceClient> userServiceClient;

  public RavenApiClient(Authorization auth) {
    this(Environment.PROD, auth);
  }

  public RavenApiClient(Environment environment, Authorization auth) {
    this.userServiceClient = memoize(() -> new userServiceClient(environment.getUrl(), auth));
    this.serviceClient = memoize(() -> new ServiceClient(environment.getUrl(), auth));
    this.deviceServiceClient = memoize(() -> new deviceServiceClient(environment.getUrl(), auth));
  }

  public final ServiceClient service() {
    return this.serviceClient.get();
  }

  public final deviceServiceClient device() {
    return this.deviceServiceClient.get();
  }

  public final userServiceClient user() {
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
