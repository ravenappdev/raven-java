package com.raven.api.resources.device.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class Platform {
  public static final Platform WEB = new Platform(Value.WEB, "web");

  public static final Platform IOS = new Platform(Value.IOS, "ios");

  public static final Platform ANDROID = new Platform(Value.ANDROID, "android");

  private final Value value;

  private final String string;

  Platform(Value value, String string) {
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
      || (other instanceof Platform && this.string.equals(((Platform) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case WEB:
        return visitor.visitWeb();
      case IOS:
        return visitor.visitIos();
      case ANDROID:
        return visitor.visitAndroid();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static Platform valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "web":
        return WEB;
      case "ios":
        return IOS;
      case "android":
        return ANDROID;
      default:
        return new Platform(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    ANDROID,

    WEB,

    IOS,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitAndroid();

    T visitWeb();

    T visitIos();

    T visitUnknown(String unknownType);
  }
}
