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
    builder = SmsMessage.Builder.class
)
public final class SmsMessage {
  private final String text;

  private int _cachedHashCode;

  SmsMessage(String text) {
    this.text = text;
  }

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SmsMessage && equalTo((SmsMessage) other);
  }

  private boolean equalTo(SmsMessage other) {
    return text.equals(other.text);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.text);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SmsMessage{" + "text: " + text + "}";
  }

  public static TextStage builder() {
    return new Builder();
  }

  public interface TextStage {
    _FinalStage text(String text);

    Builder from(SmsMessage other);
  }

  public interface _FinalStage {
    SmsMessage build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TextStage, _FinalStage {
    private String text;

    private Builder() {
    }

    @Override
    public Builder from(SmsMessage other) {
      text(other.getText());
      return this;
    }

    @Override
    @JsonSetter("text")
    public _FinalStage text(String text) {
      this.text = text;
      return this;
    }

    @Override
    public SmsMessage build() {
      return new SmsMessage(text);
    }
  }
}
