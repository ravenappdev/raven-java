package com.raven.api.resources.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonDeserialize(
    builder = ProviderOverride.Builder.class
)
public final class ProviderOverride {
  private final Map<String, Object> payload;

  private final List<Param> formParams;

  private final List<Param> queryParams;

  private final List<Param> pathParams;

  private final List<Param> headers;

  private int _cachedHashCode;

  ProviderOverride(Map<String, Object> payload, List<Param> formParams, List<Param> queryParams,
      List<Param> pathParams, List<Param> headers) {
    this.payload = payload;
    this.formParams = formParams;
    this.queryParams = queryParams;
    this.pathParams = pathParams;
    this.headers = headers;
  }

  @JsonProperty("payload")
  public Map<String, Object> getPayload() {
    return payload;
  }

  @JsonProperty("form_params")
  public List<Param> getFormParams() {
    return formParams;
  }

  @JsonProperty("query_params")
  public List<Param> getQueryParams() {
    return queryParams;
  }

  @JsonProperty("path_params")
  public List<Param> getPathParams() {
    return pathParams;
  }

  @JsonProperty("headers")
  public List<Param> getHeaders() {
    return headers;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ProviderOverride && equalTo((ProviderOverride) other);
  }

  private boolean equalTo(ProviderOverride other) {
    return payload.equals(other.payload) && formParams.equals(other.formParams) && queryParams.equals(other.queryParams) && pathParams.equals(other.pathParams) && headers.equals(other.headers);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.payload, this.formParams, this.queryParams, this.pathParams, this.headers);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ProviderOverride{" + "payload: " + payload + ", formParams: " + formParams + ", queryParams: " + queryParams + ", pathParams: " + pathParams + ", headers: " + headers + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Map<String, Object> payload = new LinkedHashMap<>();

    private List<Param> formParams = new ArrayList<>();

    private List<Param> queryParams = new ArrayList<>();

    private List<Param> pathParams = new ArrayList<>();

    private List<Param> headers = new ArrayList<>();

    private Builder() {
    }

    public Builder from(ProviderOverride other) {
      payload(other.getPayload());
      formParams(other.getFormParams());
      queryParams(other.getQueryParams());
      pathParams(other.getPathParams());
      headers(other.getHeaders());
      return this;
    }

    @JsonSetter(
        value = "payload",
        nulls = Nulls.SKIP
    )
    public Builder payload(Map<String, Object> payload) {
      this.payload.clear();
      this.payload.putAll(payload);
      return this;
    }

    public Builder putAllPayload(Map<String, Object> payload) {
      this.payload.putAll(payload);
      return this;
    }

    public Builder payload(String key, Object value) {
      this.payload.put(key, value);
      return this;
    }

    @JsonSetter(
        value = "form_params",
        nulls = Nulls.SKIP
    )
    public Builder formParams(List<Param> formParams) {
      this.formParams.clear();
      this.formParams.addAll(formParams);
      return this;
    }

    public Builder addFormParams(Param formParams) {
      this.formParams.add(formParams);
      return this;
    }

    public Builder addAllFormParams(List<Param> formParams) {
      this.formParams.addAll(formParams);
      return this;
    }

    @JsonSetter(
        value = "query_params",
        nulls = Nulls.SKIP
    )
    public Builder queryParams(List<Param> queryParams) {
      this.queryParams.clear();
      this.queryParams.addAll(queryParams);
      return this;
    }

    public Builder addQueryParams(Param queryParams) {
      this.queryParams.add(queryParams);
      return this;
    }

    public Builder addAllQueryParams(List<Param> queryParams) {
      this.queryParams.addAll(queryParams);
      return this;
    }

    @JsonSetter(
        value = "path_params",
        nulls = Nulls.SKIP
    )
    public Builder pathParams(List<Param> pathParams) {
      this.pathParams.clear();
      this.pathParams.addAll(pathParams);
      return this;
    }

    public Builder addPathParams(Param pathParams) {
      this.pathParams.add(pathParams);
      return this;
    }

    public Builder addAllPathParams(List<Param> pathParams) {
      this.pathParams.addAll(pathParams);
      return this;
    }

    @JsonSetter(
        value = "headers",
        nulls = Nulls.SKIP
    )
    public Builder headers(List<Param> headers) {
      this.headers.clear();
      this.headers.addAll(headers);
      return this;
    }

    public Builder addHeaders(Param headers) {
      this.headers.add(headers);
      return this;
    }

    public Builder addAllHeaders(List<Param> headers) {
      this.headers.addAll(headers);
      return this;
    }

    public ProviderOverride build() {
      return new ProviderOverride(payload, formParams, queryParams, pathParams, headers);
    }
  }
}
