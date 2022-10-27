package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = SlackMessage.Builder.class
)
public final class SlackMessage {
  private final String text;

  private final Optional<Object> blocks;

  private int _cachedHashCode;

  SlackMessage(String text, Optional<Object> blocks) {
    this.text = text;
    this.blocks = blocks;
  }

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  @JsonProperty("blocks")
  public Optional<Object> getBlocks() {
    return blocks;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SlackMessage && equalTo((SlackMessage) other);
  }

  private boolean equalTo(SlackMessage other) {
    return text.equals(other.text) && blocks.equals(other.blocks);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.text, this.blocks);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SlackMessage{" + "text: " + text + ", blocks: " + blocks + "}";
  }

  public static TextStage builder() {
    return new Builder();
  }

  public interface TextStage {
    _FinalStage text(String text);

    Builder from(SlackMessage other);
  }

  public interface _FinalStage {
    SlackMessage build();

    _FinalStage blocks(Optional<Object> blocks);

    _FinalStage blocks(Object blocks);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements TextStage, _FinalStage {
    private String text;

    private Optional<Object> blocks = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(SlackMessage other) {
      text(other.getText());
      blocks(other.getBlocks());
      return this;
    }

    @Override
    @JsonSetter("text")
    public _FinalStage text(String text) {
      this.text = text;
      return this;
    }

    @Override
    public _FinalStage blocks(Object blocks) {
      this.blocks = Optional.of(blocks);
      return this;
    }

    @Override
    @JsonSetter(
        value = "blocks",
        nulls = Nulls.SKIP
    )
    public _FinalStage blocks(Optional<Object> blocks) {
      this.blocks = blocks;
      return this;
    }

    @Override
    public SlackMessage build() {
      return new SlackMessage(text, blocks);
    }
  }
}
