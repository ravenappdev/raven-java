package com.raven.api.client.event.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = EventOverride.Builder.class
)
public final class EventOverride {
  private final Optional<EmailOverride> email;

  private final Optional<SmsOverride> sms;

  private final Optional<WhatsappOverride> whatsapp;

  private final Optional<PushOverride> push;

  private final Optional<WebhookOverride> webhook;

  private final Optional<VoiceOverride> voice;

  private final Optional<SlackOverride> slack;

  private final Optional<InAppOverride> inApp;

  private final Optional<TelegramOverride> telegram;

  private final Map<String, ProviderOverride> providers;

  private int _cachedHashCode;

  EventOverride(Optional<EmailOverride> email, Optional<SmsOverride> sms,
      Optional<WhatsappOverride> whatsapp, Optional<PushOverride> push,
      Optional<WebhookOverride> webhook, Optional<VoiceOverride> voice,
      Optional<SlackOverride> slack, Optional<InAppOverride> inApp,
      Optional<TelegramOverride> telegram, Map<String, ProviderOverride> providers) {
    this.email = email;
    this.sms = sms;
    this.whatsapp = whatsapp;
    this.push = push;
    this.webhook = webhook;
    this.voice = voice;
    this.slack = slack;
    this.inApp = inApp;
    this.telegram = telegram;
    this.providers = providers;
  }

  @JsonProperty("email")
  public Optional<EmailOverride> getEmail() {
    return email;
  }

  @JsonProperty("sms")
  public Optional<SmsOverride> getSms() {
    return sms;
  }

  @JsonProperty("whatsapp")
  public Optional<WhatsappOverride> getWhatsapp() {
    return whatsapp;
  }

  @JsonProperty("push")
  public Optional<PushOverride> getPush() {
    return push;
  }

  @JsonProperty("webhook")
  public Optional<WebhookOverride> getWebhook() {
    return webhook;
  }

  @JsonProperty("voice")
  public Optional<VoiceOverride> getVoice() {
    return voice;
  }

  @JsonProperty("slack")
  public Optional<SlackOverride> getSlack() {
    return slack;
  }

  @JsonProperty("in_app")
  public Optional<InAppOverride> getInApp() {
    return inApp;
  }

  @JsonProperty("telegram")
  public Optional<TelegramOverride> getTelegram() {
    return telegram;
  }

  @JsonProperty("providers")
  public Map<String, ProviderOverride> getProviders() {
    return providers;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EventOverride && equalTo((EventOverride) other);
  }

  private boolean equalTo(EventOverride other) {
    return email.equals(other.email) && sms.equals(other.sms) && whatsapp.equals(other.whatsapp) && push.equals(other.push) && webhook.equals(other.webhook) && voice.equals(other.voice) && slack.equals(other.slack) && inApp.equals(other.inApp) && telegram.equals(other.telegram) && providers.equals(other.providers);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.email, this.sms, this.whatsapp, this.push, this.webhook, this.voice, this.slack, this.inApp, this.telegram, this.providers);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EventOverride{" + "email: " + email + ", sms: " + sms + ", whatsapp: " + whatsapp + ", push: " + push + ", webhook: " + webhook + ", voice: " + voice + ", slack: " + slack + ", inApp: " + inApp + ", telegram: " + telegram + ", providers: " + providers + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<EmailOverride> email = Optional.empty();

    private Optional<SmsOverride> sms = Optional.empty();

    private Optional<WhatsappOverride> whatsapp = Optional.empty();

    private Optional<PushOverride> push = Optional.empty();

    private Optional<WebhookOverride> webhook = Optional.empty();

    private Optional<VoiceOverride> voice = Optional.empty();

    private Optional<SlackOverride> slack = Optional.empty();

    private Optional<InAppOverride> inApp = Optional.empty();

    private Optional<TelegramOverride> telegram = Optional.empty();

    private Map<String, ProviderOverride> providers = new LinkedHashMap<>();

    private Builder() {
    }

    public Builder from(EventOverride other) {
      email(other.getEmail());
      sms(other.getSms());
      whatsapp(other.getWhatsapp());
      push(other.getPush());
      webhook(other.getWebhook());
      voice(other.getVoice());
      slack(other.getSlack());
      inApp(other.getInApp());
      telegram(other.getTelegram());
      providers(other.getProviders());
      return this;
    }

    @JsonSetter(
        value = "email",
        nulls = Nulls.SKIP
    )
    public Builder email(Optional<EmailOverride> email) {
      this.email = email;
      return this;
    }

    public Builder email(EmailOverride email) {
      this.email = Optional.of(email);
      return this;
    }

    @JsonSetter(
        value = "sms",
        nulls = Nulls.SKIP
    )
    public Builder sms(Optional<SmsOverride> sms) {
      this.sms = sms;
      return this;
    }

    public Builder sms(SmsOverride sms) {
      this.sms = Optional.of(sms);
      return this;
    }

    @JsonSetter(
        value = "whatsapp",
        nulls = Nulls.SKIP
    )
    public Builder whatsapp(Optional<WhatsappOverride> whatsapp) {
      this.whatsapp = whatsapp;
      return this;
    }

    public Builder whatsapp(WhatsappOverride whatsapp) {
      this.whatsapp = Optional.of(whatsapp);
      return this;
    }

    @JsonSetter(
        value = "push",
        nulls = Nulls.SKIP
    )
    public Builder push(Optional<PushOverride> push) {
      this.push = push;
      return this;
    }

    public Builder push(PushOverride push) {
      this.push = Optional.of(push);
      return this;
    }

    @JsonSetter(
        value = "webhook",
        nulls = Nulls.SKIP
    )
    public Builder webhook(Optional<WebhookOverride> webhook) {
      this.webhook = webhook;
      return this;
    }

    public Builder webhook(WebhookOverride webhook) {
      this.webhook = Optional.of(webhook);
      return this;
    }

    @JsonSetter(
        value = "voice",
        nulls = Nulls.SKIP
    )
    public Builder voice(Optional<VoiceOverride> voice) {
      this.voice = voice;
      return this;
    }

    public Builder voice(VoiceOverride voice) {
      this.voice = Optional.of(voice);
      return this;
    }

    @JsonSetter(
        value = "slack",
        nulls = Nulls.SKIP
    )
    public Builder slack(Optional<SlackOverride> slack) {
      this.slack = slack;
      return this;
    }

    public Builder slack(SlackOverride slack) {
      this.slack = Optional.of(slack);
      return this;
    }

    @JsonSetter(
        value = "in_app",
        nulls = Nulls.SKIP
    )
    public Builder inApp(Optional<InAppOverride> inApp) {
      this.inApp = inApp;
      return this;
    }

    public Builder inApp(InAppOverride inApp) {
      this.inApp = Optional.of(inApp);
      return this;
    }

    @JsonSetter(
        value = "telegram",
        nulls = Nulls.SKIP
    )
    public Builder telegram(Optional<TelegramOverride> telegram) {
      this.telegram = telegram;
      return this;
    }

    public Builder telegram(TelegramOverride telegram) {
      this.telegram = Optional.of(telegram);
      return this;
    }

    @JsonSetter(
        value = "providers",
        nulls = Nulls.SKIP
    )
    public Builder providers(Map<String, ProviderOverride> providers) {
      this.providers.clear();
      this.providers.putAll(providers);
      return this;
    }

    public Builder putAllProviders(Map<String, ProviderOverride> providers) {
      this.providers.putAll(providers);
      return this;
    }

    public Builder providers(String key, ProviderOverride value) {
      this.providers.put(key, value);
      return this;
    }

    public EventOverride build() {
      return new EventOverride(email, sms, whatsapp, push, webhook, voice, slack, inApp, telegram, providers);
    }
  }
}
