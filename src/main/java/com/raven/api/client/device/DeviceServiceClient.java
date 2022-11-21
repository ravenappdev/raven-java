package com.raven.api.client.device;

import com.raven.api.client.Authorization;
import com.raven.api.client.device.endpoints.Add;
import com.raven.api.client.device.endpoints.Delete;
import com.raven.api.client.device.endpoints.GetDevice;
import com.raven.api.client.device.endpoints.Update;
import com.raven.api.client.device.exceptions.AddException;
import com.raven.api.client.device.exceptions.DeleteException;
import com.raven.api.client.device.exceptions.GetDeviceException;
import com.raven.api.client.device.exceptions.UpdateException;
import com.raven.api.client.device.types.Device;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class DeviceServiceClient {
  private final DeviceService service;

  private final Optional<Authorization> auth;

  public DeviceServiceClient(String url) {
    this.service = DeviceService.getClient(url);
    this.auth = Optional.empty();
  }

  public DeviceServiceClient(String url, Authorization auth) {
    this.service = DeviceService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * Add Device for a User.
   * If a device_sid is specified, then devices will be merged if one is found.
   * If no device_sid is specified, then a new device will be created.
   */
  public Device add(Add.Request request) throws AddException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.add(authValue, request.getAppId(), request.getUserId(), request.getBody());
  }

  /**
   * Update a Device for a User.
   */
  public Device update(Update.Request request) throws UpdateException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.update(authValue, request.getAppId(), request.getUserId(), request.getDeviceId(), request.getBody());
  }

  /**
   * Delete a Device for a User
   */
  public void delete(Delete.Request request) throws DeleteException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.delete(authValue, request.getAppId(), request.getUserId(), request.getDeviceId());
  }

  /**
   * Get a Device for a User
   */
  public Device getDevice(GetDevice.Request request) throws GetDeviceException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getDevice(authValue, request.getAppId(), request.getUserId(), request.getDeviceId());
  }
}
