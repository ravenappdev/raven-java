package com.raven.api.client;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.raven.api.client.exceptions.SendBulkException;
import com.raven.api.client.exceptions.SendException;
import com.raven.api.client.types.BulkSendEventRequest;
import com.raven.api.client.types.SendEventRequest;
import com.raven.api.client.types.SendEventResponse;
import com.raven.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/apps")
interface Service {
  @POST
  @Path("/{app_id}/events/send")
  SendEventResponse send(@HeaderParam("Authorization") AuthKey auth,
      @HeaderParam("Idempotency-Key") Optional<String> idempotencyKey,
      @PathParam("app_id") String appId, SendEventRequest body) throws SendException;

  @POST
  @Path("/{app_id}/events/bulk_send")
  SendEventResponse sendBulk(@HeaderParam("Authorization") AuthKey auth,
      @HeaderParam("Idempotency-Key") Optional<String> idempotencyKey,
      @PathParam("app_id") String appId, BulkSendEventRequest body) throws SendBulkException;

  static Service getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new ServiceErrorDecoder()).target(Service.class, url);
  }
}
