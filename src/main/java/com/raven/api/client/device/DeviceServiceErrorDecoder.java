package com.raven.api.client.device;

import com.fern.java.jackson.ClientObjectMappers;
import com.raven.api.client.device.exceptions.AddException;
import com.raven.api.client.device.exceptions.DeleteDeviceException;
import com.raven.api.client.device.exceptions.GetDeviceException;
import com.raven.api.client.device.exceptions.UpdateException;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class DeviceServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("add")) {
        return decodeException(response, AddException.class);
      }
      if (methodKey.contains("update")) {
        return decodeException(response, UpdateException.class);
      }
      if (methodKey.contains("deleteDevice")) {
        return decodeException(response, DeleteDeviceException.class);
      }
      if (methodKey.contains("getDevice")) {
        return decodeException(response, GetDeviceException.class);
      }
    }
    catch (IOException e) {
    }
    return new RuntimeException("Failed to read response body. Received status " + response.status() + " for method " + methodKey);
  }

  private static <T extends Exception> Exception decodeException(Response response, Class<T> clazz)
      throws IOException {
    return ClientObjectMappers.JSON_MAPPER.reader().withAttribute("statusCode", response.status()).readValue(response.body().asInputStream(), clazz);
  }
}
