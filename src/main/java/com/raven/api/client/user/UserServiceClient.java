package com.raven.api.client.user;

import com.raven.api.client.Authorization;
import com.raven.api.client.user.endpoints.CreateOrUpdate;
import com.raven.api.client.user.endpoints.Get;
import com.raven.api.client.user.exceptions.CreateOrUpdateException;
import com.raven.api.client.user.exceptions.GetException;
import com.raven.api.client.user.types.RavenUser;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class UserServiceClient {
  private final UserService service;

  private final Optional<Authorization> auth;

  public UserServiceClient(String url) {
    this.service = UserService.getClient(url);
    this.auth = Optional.empty();
  }

  public UserServiceClient(String url, Authorization auth) {
    this.service = UserService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * Creates an AppUser if doesn't exist already, or updates user properties
   */
  public RavenUser createOrUpdate(CreateOrUpdate.Request request) throws CreateOrUpdateException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.createOrUpdate(authValue, request.getAppId(), request.getBody());
  }

  /**
   * Gets the requested user
   */
  public RavenUser get(Get.Request request) throws GetException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.get(authValue, request.getAppId(), request.getUserId());
  }
}
