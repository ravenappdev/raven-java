package com.raven.api.client.user;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.raven.api.client.Authorization;
import com.raven.api.client.user.exceptions.CreateOrUpdateException;
import com.raven.api.client.user.exceptions.GetException;
import com.raven.api.client.user.types.CreateUserRequest;
import com.raven.api.client.user.types.RavenUser;
import com.raven.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/apps")
interface userService {
  @POST
  @Path("/{app_id}/users")
  RavenUser createOrUpdate(@HeaderParam("Authorization") Authorization auth,
      @PathParam("app_id") String appId, CreateUserRequest body) throws CreateOrUpdateException;

  @GET
  @Path("/{app_id}/users/{user_id}")
  RavenUser get(@HeaderParam("Authorization") Authorization auth, @PathParam("app_id") String appId,
      @PathParam("user_id") String userId) throws GetException;

  static userService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new userServiceErrorDecoder()).target(userService.class, url);
  }
}
