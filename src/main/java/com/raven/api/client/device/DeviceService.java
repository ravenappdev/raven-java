package com.raven.api.client.device;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.raven.api.client.Authorization;
import com.raven.api.client.device.exceptions.AddException;
import com.raven.api.client.device.exceptions.DeleteException;
import com.raven.api.client.device.exceptions.GetDeviceException;
import com.raven.api.client.device.exceptions.UpdateException;
import com.raven.api.client.device.types.Device;
import com.raven.api.client.ids.types.AppId;
import com.raven.api.client.ids.types.DeviceId;
import com.raven.api.client.ids.types.UserId;
import com.raven.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/apps")
interface DeviceService {
  @POST
  @Path("/{app_id}/users/{user_id}/devices")
  Device add(@HeaderParam("Authorization") Authorization auth, @PathParam("app_id") AppId appId,
      @PathParam("user_id") UserId userId, Device body) throws AddException;

  @PUT
  @Path("/{app_id}/users/{user_id}/devices/{device_id}")
  Device update(@HeaderParam("Authorization") Authorization auth, @PathParam("app_id") AppId appId,
      @PathParam("user_id") UserId userId, @PathParam("device_id") DeviceId deviceId, Device body)
      throws UpdateException;

  @DELETE
  @Path("/{app_id}/users/{user_id}/devices/{device_id}")
  void delete(@HeaderParam("Authorization") Authorization auth, @PathParam("app_id") AppId appId,
      @PathParam("user_id") UserId userId, @PathParam("device_id") DeviceId deviceId) throws
      DeleteException;

  @GET
  @Path("/{app_id}/users/{user_id}/devices/{device_id}")
  Device getDevice(@HeaderParam("Authorization") Authorization auth,
      @PathParam("app_id") AppId appId, @PathParam("user_id") UserId userId,
      @PathParam("device_id") DeviceId deviceId) throws GetDeviceException;

  static DeviceService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new DeviceServiceErrorDecoder()).target(DeviceService.class, url);
  }
}
