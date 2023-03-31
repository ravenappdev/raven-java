package com.raven.api.client.device;

import com.raven.api.client.AuthKey;
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

  private final Optional<AuthKey> auth;

  public DeviceServiceClient(String url) {
    this.service = DeviceService.getClient(url);
    this.auth = Optional.empty();
  }

  public DeviceServiceClient(String url, AuthKey auth) {
    this.service = DeviceService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>Add Device for a User.
   * If a device_sid is specified, then devices will be merged if one is found.
   * If no device_sid is specified, then a new device will be created.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws AddException Exception that wraps all possible endpoint errors 
   * @return <p>the updated Device</p>
   */
  public Device add(Add.Request request) throws AddException {
    AuthKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.add(authValue, request.getAppId(), request.getUserId(), request.getBody());
  }

  /**
   * <p>Update a Device for a User.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws UpdateException Exception that wraps all possible endpoint errors 
   * @return <p>the updated Device</p>
   */
  public Device update(Update.Request request) throws UpdateException {
    AuthKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.update(authValue, request.getAppId(), request.getUserId(), request.getDeviceId(), request.getBody());
  }

  /**
   * <p>Delete a Device for a User</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws DeleteException Exception that wraps all possible endpoint errors 
   */
  public void delete(Delete.Request request) throws DeleteException {
    AuthKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.delete(authValue, request.getAppId(), request.getUserId(), request.getDeviceId());
  }

  /**
   * <p>Get a Device for a User</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetDeviceException Exception that wraps all possible endpoint errors 
   * @return Device
   */
  public Device getDevice(GetDevice.Request request) throws GetDeviceException {
    AuthKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getDevice(authValue, request.getAppId(), request.getUserId(), request.getDeviceId());
  }
}
