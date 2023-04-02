package com.raven.api.resources.user.types;

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
    builder = ChannelPreferences.Builder.class
)
public final class ChannelPreferences {
  private final Optional<ChannelPreference> sms;

  private final Optional<ChannelPreference> push;

  private final Optional<ChannelPreference> whatsapp;

  private final Optional<ChannelPreference> email;

  private final Optional<ChannelPreference> slack;

  private final Optional<ChannelPreference> voice;

  private final Optional<ChannelPreference> teams;

  private int _cachedHashCode;

  ChannelPreferences(Optional<ChannelPreference> sms, Optional<ChannelPreference> push,
      Optional<ChannelPreference> whatsapp, Optional<ChannelPreference> email,
      Optional<ChannelPreference> slack, Optional<ChannelPreference> voice,
      Optional<ChannelPreference> teams) {
    this.sms = sms;
    this.push = push;
    this.whatsapp = whatsapp;
    this.email = email;
    this.slack = slack;
    this.voice = voice;
    this.teams = teams;
  }

  @JsonProperty("sms")
  public Optional<ChannelPreference> getSms() {
    return sms;
  }

  @JsonProperty("push")
  public Optional<ChannelPreference> getPush() {
    return push;
  }

  @JsonProperty("whatsapp")
  public Optional<ChannelPreference> getWhatsapp() {
    return whatsapp;
  }

  @JsonProperty("email")
  public Optional<ChannelPreference> getEmail() {
    return email;
  }

  @JsonProperty("slack")
  public Optional<ChannelPreference> getSlack() {
    return slack;
  }

  @JsonProperty("voice")
  public Optional<ChannelPreference> getVoice() {
    return voice;
  }

  @JsonProperty("teams")
  public Optional<ChannelPreference> getTeams() {
    return teams;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ChannelPreferences && equalTo((ChannelPreferences) other);
  }

  private boolean equalTo(ChannelPreferences other) {
    return sms.equals(other.sms) && push.equals(other.push) && whatsapp.equals(other.whatsapp) && email.equals(other.email) && slack.equals(other.slack) && voice.equals(other.voice) && teams.equals(other.teams);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.sms, this.push, this.whatsapp, this.email, this.slack, this.voice, this.teams);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ChannelPreferences{" + "sms: " + sms + ", push: " + push + ", whatsapp: " + whatsapp + ", email: " + email + ", slack: " + slack + ", voice: " + voice + ", teams: " + teams + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<ChannelPreference> sms = Optional.empty();

    private Optional<ChannelPreference> push = Optional.empty();

    private Optional<ChannelPreference> whatsapp = Optional.empty();

    private Optional<ChannelPreference> email = Optional.empty();

    private Optional<ChannelPreference> slack = Optional.empty();

    private Optional<ChannelPreference> voice = Optional.empty();

    private Optional<ChannelPreference> teams = Optional.empty();

    private Builder() {
    }

    public Builder from(ChannelPreferences other) {
      sms(other.getSms());
      push(other.getPush());
      whatsapp(other.getWhatsapp());
      email(other.getEmail());
      slack(other.getSlack());
      voice(other.getVoice());
      teams(other.getTeams());
      return this;
    }

    @JsonSetter(
        value = "sms",
        nulls = Nulls.SKIP
    )
    public Builder sms(Optional<ChannelPreference> sms) {
      this.sms = sms;
      return this;
    }

    public Builder sms(ChannelPreference sms) {
      this.sms = Optional.of(sms);
      return this;
    }

    @JsonSetter(
        value = "push",
        nulls = Nulls.SKIP
    )
    public Builder push(Optional<ChannelPreference> push) {
      this.push = push;
      return this;
    }

    public Builder push(ChannelPreference push) {
      this.push = Optional.of(push);
      return this;
    }

    @JsonSetter(
        value = "whatsapp",
        nulls = Nulls.SKIP
    )
    public Builder whatsapp(Optional<ChannelPreference> whatsapp) {
      this.whatsapp = whatsapp;
      return this;
    }

    public Builder whatsapp(ChannelPreference whatsapp) {
      this.whatsapp = Optional.of(whatsapp);
      return this;
    }

    @JsonSetter(
        value = "email",
        nulls = Nulls.SKIP
    )
    public Builder email(Optional<ChannelPreference> email) {
      this.email = email;
      return this;
    }

    public Builder email(ChannelPreference email) {
      this.email = Optional.of(email);
      return this;
    }

    @JsonSetter(
        value = "slack",
        nulls = Nulls.SKIP
    )
    public Builder slack(Optional<ChannelPreference> slack) {
      this.slack = slack;
      return this;
    }

    public Builder slack(ChannelPreference slack) {
      this.slack = Optional.of(slack);
      return this;
    }

    @JsonSetter(
        value = "voice",
        nulls = Nulls.SKIP
    )
    public Builder voice(Optional<ChannelPreference> voice) {
      this.voice = voice;
      return this;
    }

    public Builder voice(ChannelPreference voice) {
      this.voice = Optional.of(voice);
      return this;
    }

    @JsonSetter(
        value = "teams",
        nulls = Nulls.SKIP
    )
    public Builder teams(Optional<ChannelPreference> teams) {
      this.teams = teams;
      return this;
    }

    public Builder teams(ChannelPreference teams) {
      this.teams = Optional.of(teams);
      return this;
    }

    public ChannelPreferences build() {
      return new ChannelPreferences(sms, push, whatsapp, email, slack, voice, teams);
    }
  }
}
