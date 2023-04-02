package com.raven.api;

import com.raven.api.core.Environment;
import com.raven.api.resources.device.DeviceClient;
import com.raven.api.resources.requests.BulkSendEventRequest;
import com.raven.api.resources.requests.SendEventRequest;
import com.raven.api.resources.types.SendEventResponse;
import com.raven.api.resources.user.UserClient;
import java.lang.String;

public interface RavenApiClient {
  SendEventResponse send(String appId, SendEventRequest request);

  SendEventResponse sendBulk(String appId, BulkSendEventRequest request);

  DeviceClient device();

  UserClient user();

  static Builder builder() {
    return new RavenApiClientImpl.Builder();
  }

  interface Builder {
    Builder authKey(String authKey);

    Builder environment(Environment environment);

    Builder url(String url);

    RavenApiClient build();
  }
}
