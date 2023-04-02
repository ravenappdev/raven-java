package com.raven.api.resources.user;

import com.raven.api.resources.user.requests.CreateUserRequest;
import com.raven.api.resources.user.types.RavenUser;
import java.lang.String;

public interface UserClient {
  RavenUser createOrUpdate(String appId, CreateUserRequest request);

  RavenUser get(String appId, String userId);
}
