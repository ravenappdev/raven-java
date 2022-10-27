package com.raven.api.client.user.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class Channel {
  public static final Channel SMS = new Channel(Value.SMS, "SMS");

  public static final Channel IN_APP = new Channel(Value.IN_APP, "IN_APP");

  public static final Channel VOICE = new Channel(Value.VOICE, "VOICE");

  public static final Channel WHATSAPP = new Channel(Value.WHATSAPP, "WHATSAPP");

  public static final Channel PUSH = new Channel(Value.PUSH, "PUSH");

  public static final Channel EMAIL = new Channel(Value.EMAIL, "EMAIL");

  public static final Channel TELEGRAM = new Channel(Value.TELEGRAM, "TELEGRAM");

  public static final Channel SLACK = new Channel(Value.SLACK, "SLACK");

  public static final Channel WEBHOOK = new Channel(Value.WEBHOOK, "WEBHOOK");

  private final Value value;

  private final String string;

  Channel(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof Channel && this.string.equals(((Channel) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case SMS:
        return visitor.visitSms();
      case IN_APP:
        return visitor.visitInApp();
      case VOICE:
        return visitor.visitVoice();
      case WHATSAPP:
        return visitor.visitWhatsapp();
      case PUSH:
        return visitor.visitPush();
      case EMAIL:
        return visitor.visitEmail();
      case TELEGRAM:
        return visitor.visitTelegram();
      case SLACK:
        return visitor.visitSlack();
      case WEBHOOK:
        return visitor.visitWebhook();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static Channel valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "SMS":
        return SMS;
      case "IN_APP":
        return IN_APP;
      case "VOICE":
        return VOICE;
      case "WHATSAPP":
        return WHATSAPP;
      case "PUSH":
        return PUSH;
      case "EMAIL":
        return EMAIL;
      case "TELEGRAM":
        return TELEGRAM;
      case "SLACK":
        return SLACK;
      case "WEBHOOK":
        return WEBHOOK;
      default:
        return new Channel(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    VOICE,

    PUSH,

    SMS,

    EMAIL,

    WHATSAPP,

    WEBHOOK,

    SLACK,

    IN_APP,

    TELEGRAM,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitVoice();

    T visitPush();

    T visitSms();

    T visitEmail();

    T visitWhatsapp();

    T visitWebhook();

    T visitSlack();

    T visitInApp();

    T visitTelegram();

    T visitUnknown(String unknownType);
  }
}
