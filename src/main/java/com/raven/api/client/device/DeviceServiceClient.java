package com.raven.api.client.device;

import com.raven.api.client.Authorization;
import com.raven.api.client.device.endpoints.Add;
import com.raven.api.client.device.endpoints.DeleteDevice;
import com.raven.api.client.device.endpoints.GetDevice;
import com.raven.api.client.device.endpoints.Update;
import com.raven.api.client.device.exceptions.AddException;
import com.raven.api.client.device.exceptions.DeleteDeviceException;
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

  public Device add(Add.Request request) throws AddException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for add")));
    return this.service.add(authValue, request.getAppId(), request.getUserId(), request.getBody());
  }

  public Device update(Update.Request request) throws UpdateException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for update")));
    return this.service.update(authValue, request.getAppId(), request.getUserId(), request.getDeviceId(), request.getBody());
  }

  public void deleteDevice(DeleteDevice.Request request) throws DeleteDeviceException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for deleteDevice")));
    this.service.deleteDevice(authValue, request.getAppId(), request.getUserId(), request.getDeviceId());
  }

  public Device getDevice(GetDevice.Request request) throws GetDeviceException {
    Authorization authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getDevice")));
    return this.service.getDevice(authValue, request.getAppId(), request.getUserId(), request.getDeviceId());
  }
}
