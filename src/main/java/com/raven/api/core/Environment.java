package com.raven.api.core;

import java.lang.String;

public final class Environment {
  public static final Environment PROD = new Environment("https://api.ravenapp.dev");

  private final String url;

  private Environment(String url) {
    this.url = url;
  }

  public String getUrl() {
    return this.url;
  }

  public static Environment custom(String url) {
    return new Environment(url);
  }
}
