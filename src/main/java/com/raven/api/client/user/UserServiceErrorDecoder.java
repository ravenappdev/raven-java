package com.raven.api.client.user;

import com.fern.java.jackson.ClientObjectMappers;
import com.raven.api.client.user.exceptions.CreateOrUpdateException;
import com.raven.api.client.user.exceptions.GetException;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class UserServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("createOrUpdate")) {
        return decodeException(response, CreateOrUpdateException.class);
      }
      if (methodKey.contains("get")) {
        return decodeException(response, GetException.class);
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
