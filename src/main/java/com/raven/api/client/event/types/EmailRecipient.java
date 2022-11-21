package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = EmailRecipient.Builder.class
)
public final class EmailRecipient {
  private final String name;

  private final String address;

  private int _cachedHashCode;

  EmailRecipient(String name, String address) {
    this.name = name;
    this.address = address;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EmailRecipient && equalTo((EmailRecipient) other);
  }

  private boolean equalTo(EmailRecipient other) {
    return name.equals(other.name) && address.equals(other.address);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.address);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EmailRecipient{" + "name: " + name + ", address: " + address + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    AddressStage name(String name);

    Builder from(EmailRecipient other);
  }

  public interface AddressStage {
    _FinalStage address(String address);
  }

  public interface _FinalStage {
    EmailRecipient build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, AddressStage, _FinalStage {
    private String name;

    private String address;

    private Builder() {
    }

    @Override
    public Builder from(EmailRecipient other) {
      name(other.getName());
      address(other.getAddress());
      return this;
    }

    @Override
    @JsonSetter("name")
    public AddressStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("address")
    public _FinalStage address(String address) {
      this.address = address;
      return this;
    }

    @Override
    public EmailRecipient build() {
      return new EmailRecipient(name, address);
    }
  }
}
