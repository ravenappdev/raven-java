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
   * <p>Creates an AppUser if doesn't exist already, or updates user properties</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws CreateOrUpdateException Exception that wraps all possible endpoint errors 
   * @return <p>updated or newly created user.</p>
   */
  public RavenUser createOrUpdate(CreateOrUpdate.Request request) throws CreateOrUpdateException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.createOrUpdate(authValue, request.getAppId(), request.getBody());
  }

  /**
   * <p>Gets the requested user</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetException Exception that wraps all possible endpoint errors 
   * @return RavenUser
   */
  public RavenUser get(Get.Request request) throws GetException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.get(authValue, request.getAppId(), request.getUserId());
  }
}
