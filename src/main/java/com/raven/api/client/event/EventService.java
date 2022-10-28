package com.raven.api.client.event;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.raven.api.client.Authorization;
import com.raven.api.client.event.exceptions.SendBulkException;
import com.raven.api.client.event.exceptions.SendException;
import com.raven.api.client.event.types.BulkSendEventRequest;
import com.raven.api.client.event.types.SendEventRequest;
import com.raven.api.client.event.types.SendEventResponse;
import com.raven.api.client.ids.types.AppId;
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
interface EventService {
  @POST
  @Path("/{app_id}/events/send")
  SendEventResponse send(@HeaderParam("Authorization") Authorization auth,
      @HeaderParam("Idempotency-Key") Optional<String> idempotencyKey,
      @PathParam("app_id") AppId appId, SendEventRequest body) throws SendException;

  @POST
  @Path("/{app_id}/events/bulk_send")
  SendEventResponse sendBulk(@HeaderParam("Authorization") Authorization auth,
      @HeaderParam("Idempotency-Key") Optional<String> idempotencyKey,
      @PathParam("app_id") AppId appId, BulkSendEventRequest body) throws SendBulkException;

  static EventService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new EventServiceErrorDecoder()).target(EventService.class, url);
  }
}
