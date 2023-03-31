package com.raven.api.client;

import com.raven.api.client.endpoints.Send;
import com.raven.api.client.endpoints.SendBulk;
import com.raven.api.client.exceptions.SendBulkException;
import com.raven.api.client.exceptions.SendException;
import com.raven.api.client.types.SendEventResponse;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class ServiceClient {
  private final Service service;

  private final Optional<AuthKey> auth;

  public ServiceClient(String url) {
    this.service = Service.getClient(url);
    this.auth = Optional.empty();
  }

  public ServiceClient(String url, AuthKey auth) {
    this.service = Service.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>This endpoint allows you to send messages</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws SendException Exception that wraps all possible endpoint errors 
   * @return SendEventResponse
   */
  public SendEventResponse send(Send.Request request) throws SendException {
    AuthKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.send(authValue, request.getIdempotencyKey(), request.getAppId(), request.getBody());
  }

  public SendEventResponse sendBulk(SendBulk.Request request) throws SendBulkException {
    AuthKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.sendBulk(authValue, request.getIdempotencyKey(), request.getAppId(), request.getBody());
  }
}
