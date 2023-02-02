package com.raven.api.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = SlackMessage.Builder.class
)
public final class SlackMessage {
  private final String text;

  private final Object blocks;

  private int _cachedHashCode;

  SlackMessage(String text, Object blocks) {
    this.text = text;
    this.blocks = blocks;
  }

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  @JsonProperty("blocks")
  public Object getBlocks() {
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
    BlocksStage text(String text);

    Builder from(SlackMessage other);
  }

  public interface BlocksStage {
    _FinalStage blocks(Object blocks);
  }

  public interface _FinalStage {
    SlackMessage build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TextStage, BlocksStage, _FinalStage {
    private String text;

    private Object blocks;

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
    public BlocksStage text(String text) {
      this.text = text;
      return this;
    }

    @Override
    @JsonSetter("blocks")
    public _FinalStage blocks(Object blocks) {
      this.blocks = blocks;
      return this;
    }

    @Override
    public SlackMessage build() {
      return new SlackMessage(text, blocks);
    }
  }
}
