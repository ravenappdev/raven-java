package com.raven.api.resources.user.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = TelegramProfile.Builder.class
)
public final class TelegramProfile {
  private final String chatId;

  private int _cachedHashCode;

  TelegramProfile(String chatId) {
    this.chatId = chatId;
  }

  @JsonProperty("chat_id")
  public String getChatId() {
    return chatId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof TelegramProfile && equalTo((TelegramProfile) other);
  }

  private boolean equalTo(TelegramProfile other) {
    return chatId.equals(other.chatId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.chatId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "TelegramProfile{" + "chatId: " + chatId + "}";
  }

  public static ChatIdStage builder() {
    return new Builder();
  }

  public interface ChatIdStage {
    _FinalStage chatId(String chatId);

    Builder from(TelegramProfile other);
  }

  public interface _FinalStage {
    TelegramProfile build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ChatIdStage, _FinalStage {
    private String chatId;

    private Builder() {
    }

    @Override
    public Builder from(TelegramProfile other) {
      chatId(other.getChatId());
      return this;
    }

    @Override
    @JsonSetter("chat_id")
    public _FinalStage chatId(String chatId) {
      this.chatId = chatId;
      return this;
    }

    @Override
    public TelegramProfile build() {
      return new TelegramProfile(chatId);
    }
  }
}
