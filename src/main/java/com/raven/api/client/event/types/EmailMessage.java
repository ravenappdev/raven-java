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
    builder = EmailMessage.Builder.class
)
public final class EmailMessage {
  private final String text;

  private final String htmlBody;

  private final String subject;

  private int _cachedHashCode;

  EmailMessage(String text, String htmlBody, String subject) {
    this.text = text;
    this.htmlBody = htmlBody;
    this.subject = subject;
  }

  @JsonProperty("text")
  public String getText() {
    return text;
  }

  @JsonProperty("html_body")
  public String getHtmlBody() {
    return htmlBody;
  }

  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EmailMessage && equalTo((EmailMessage) other);
  }

  private boolean equalTo(EmailMessage other) {
    return text.equals(other.text) && htmlBody.equals(other.htmlBody) && subject.equals(other.subject);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.text, this.htmlBody, this.subject);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EmailMessage{" + "text: " + text + ", htmlBody: " + htmlBody + ", subject: " + subject + "}";
  }

  public static TextStage builder() {
    return new Builder();
  }

  public interface TextStage {
    HtmlBodyStage text(String text);

    Builder from(EmailMessage other);
  }

  public interface HtmlBodyStage {
    SubjectStage htmlBody(String htmlBody);
  }

  public interface SubjectStage {
    _FinalStage subject(String subject);
  }

  public interface _FinalStage {
    EmailMessage build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements TextStage, HtmlBodyStage, SubjectStage, _FinalStage {
    private String text;

    private String htmlBody;

    private String subject;

    private Builder() {
    }

    @Override
    public Builder from(EmailMessage other) {
      text(other.getText());
      htmlBody(other.getHtmlBody());
      subject(other.getSubject());
      return this;
    }

    @Override
    @JsonSetter("text")
    public HtmlBodyStage text(String text) {
      this.text = text;
      return this;
    }

    @Override
    @JsonSetter("html_body")
    public SubjectStage htmlBody(String htmlBody) {
      this.htmlBody = htmlBody;
      return this;
    }

    @Override
    @JsonSetter("subject")
    public _FinalStage subject(String subject) {
      this.subject = subject;
      return this;
    }

    @Override
    public EmailMessage build() {
      return new EmailMessage(text, htmlBody, subject);
    }
  }
}
