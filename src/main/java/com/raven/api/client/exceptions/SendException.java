package com.raven.api.client.exceptions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.raven.api.client.errors.EventNotFoundError;
import java.io.IOException;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    using = SendException.Deserializer.class
)
public final class SendException extends Exception {
  private final Value value;

  private int statusCode;

  private SendException(Value value, int statusCode) {
    this.value = value;
    this.statusCode = statusCode;
  }

  public <T> T visit(Visitor<T> visitor) {
    return value.visit(visitor);
  }

  public int getStatusCode() {
    return this.statusCode;
  }

  public static SendException eventNotFoundError(EventNotFoundError value) {
    return new SendException(new EventNotFoundErrorValue(value), 404);
  }

  public static SendException other(Object unknownValue, int statusCode) {
    return new SendException(new UnknownErrorValue(unknownValue), statusCode);
  }

  public boolean isEventNotFoundError() {
    return value instanceof EventNotFoundErrorValue;
  }

  public boolean _isOther() {
    return value instanceof UnknownErrorValue;
  }

  public Optional<EventNotFoundError> getEventNotFoundError() {
    if (isEventNotFoundError()) {
      return Optional.of(((EventNotFoundErrorValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<Object> _getOther() {
    if (_isOther()) {
      return Optional.of(((UnknownErrorValue) value).unknownValue);
    }
    return Optional.empty();
  }

  public interface Visitor<T> {
    T visitEventNotFoundError(EventNotFoundError eventNotFoundError);

    T _visitOther(Object otherType);
  }

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      property = "_error",
      visible = true,
      defaultImpl = UnknownErrorValue.class
  )
  @JsonSubTypes(@JsonSubTypes.Type(EventNotFoundErrorValue.class))
  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  private interface Value {
    <T> T visit(Visitor<T> visitor);
  }

  @JsonTypeName("EventNotFoundError")
  private static final class EventNotFoundErrorValue implements Value {
    private EventNotFoundError value;

    private String errorInstanceId;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private EventNotFoundErrorValue(@JsonProperty("value") EventNotFoundError value,
        @JsonProperty("_errorInstanceId") String errorInstanceId) {
      this.value = value;
      this.errorInstanceId = errorInstanceId;
    }

    private EventNotFoundErrorValue(EventNotFoundError value) {
      this.value = value;
      this.errorInstanceId = UUID.randomUUID().toString();
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitEventNotFoundError(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof EventNotFoundErrorValue && equalTo((EventNotFoundErrorValue) other);
    }

    private boolean equalTo(EventNotFoundErrorValue other) {
      return value.equals(other.value) && errorInstanceId.equals(other.errorInstanceId);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.value, this.errorInstanceId);
    }

    @Override
    public String toString() {
      return "SendException{" + "value: " + value + ", errorInstanceId: " + errorInstanceId + "}";
    }
  }

  private static final class UnknownErrorValue implements Value {
    private Object unknownValue;

    @JsonCreator(
        mode = JsonCreator.Mode.DELEGATING
    )
    UnknownErrorValue(@JsonProperty("unknownValue") Object unknownValue) {
      this.unknownValue = unknownValue;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor._visitOther(unknownValue);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof UnknownErrorValue && equalTo((UnknownErrorValue) other);
    }

    private boolean equalTo(UnknownErrorValue other) {
      return unknownValue.equals(other.unknownValue);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.unknownValue);
    }

    @Override
    public String toString() {
      return "SendException{" + "unknownValue: " + unknownValue + "}";
    }
  }

  static final class Deserializer extends JsonDeserializer<SendException> {
    @Override
    public SendException deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
      Value value = ctx.readValue(p, Value.class);
      int statusCode = (int) ctx.getAttribute("statusCode");
      return new SendException(value, statusCode);
    }
  }
}
