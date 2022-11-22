package com.raven.api.client.event;

import com.raven.api.client.Authorization;
import com.raven.api.client.event.endpoints.Send;
import com.raven.api.client.event.endpoints.SendBulk;
import com.raven.api.client.event.exceptions.SendBulkException;
import com.raven.api.client.event.exceptions.SendException;
import com.raven.api.client.event.types.SendEventResponse;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class EventServiceClient {
  private final EventService service;

  private final Optional<Authorization> auth;

  public EventServiceClient(String url) {
    this.service = EventService.getClient(url);
    this.auth = Optional.empty();
  }

  public EventServiceClient(String url, Authorization auth) {
    this.service = EventService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>This endpoint allows you to send messages</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws SendException Exception that wraps all possible endpoint errors 
   * @return SendEventResponse
   */
  public SendEventResponse send(Send.Request request) throws SendException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.send(authValue, request.getIdempotencyKey(), request.getAppId(), request.getBody());
  }

  public SendEventResponse sendBulk(SendBulk.Request request) throws SendBulkException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.sendBulk(authValue, request.getIdempotencyKey(), request.getAppId(), request.getBody());
  }
}
