package com.raven.api.resources.device;

import com.raven.api.resources.device.types.Device;
import java.lang.String;

public interface DeviceClient {
  Device add(String appId, String userId, Device request);

  Device update(String appId, String userId, String deviceId, Device request);

  void delete(String appId, String userId, String deviceId);

  Device getDevice(String appId, String userId, String deviceId);
}
