package com.raven.api.resources.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = EmailOverride.Builder.class
)
public final class EmailOverride implements IChannelOverride {
  private final long scheduleAt;

  private final EmailRecipient from;

  private final List<EmailRecipient> cc;

  private final List<EmailRecipient> bcc;

  private final List<Attachment> attachments;

  private final EmailMessage message;

  private int _cachedHashCode;

  EmailOverride(long scheduleAt, EmailRecipient from, List<EmailRecipient> cc,
      List<EmailRecipient> bcc, List<Attachment> attachments, EmailMessage message) {
    this.scheduleAt = scheduleAt;
    this.from = from;
    this.cc = cc;
    this.bcc = bcc;
    this.attachments = attachments;
    this.message = message;
  }

  @JsonProperty("schedule_at")
  @Override
  public long getScheduleAt() {
    return scheduleAt;
  }

  @JsonProperty("from")
  public EmailRecipient getFrom() {
    return from;
  }

  @JsonProperty("cc")
  public List<EmailRecipient> getCc() {
    return cc;
  }

  @JsonProperty("bcc")
  public List<EmailRecipient> getBcc() {
    return bcc;
  }

  @JsonProperty("attachments")
  public List<Attachment> getAttachments() {
    return attachments;
  }

  @JsonProperty("message")
  public EmailMessage getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EmailOverride && equalTo((EmailOverride) other);
  }

  private boolean equalTo(EmailOverride other) {
    return scheduleAt == other.scheduleAt && from.equals(other.from) && cc.equals(other.cc) && bcc.equals(other.bcc) && attachments.equals(other.attachments) && message.equals(other.message);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.scheduleAt, this.from, this.cc, this.bcc, this.attachments, this.message);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EmailOverride{" + "scheduleAt: " + scheduleAt + ", from: " + from + ", cc: " + cc + ", bcc: " + bcc + ", attachments: " + attachments + ", message: " + message + "}";
  }

  public static ScheduleAtStage builder() {
    return new Builder();
  }

  public interface ScheduleAtStage {
    FromStage scheduleAt(long scheduleAt);

    Builder from(EmailOverride other);
  }

  public interface FromStage {
    MessageStage from(EmailRecipient from);
  }

  public interface MessageStage {
    _FinalStage message(EmailMessage message);
  }

  public interface _FinalStage {
    EmailOverride build();

    _FinalStage cc(List<EmailRecipient> cc);

    _FinalStage addCc(EmailRecipient cc);

    _FinalStage addAllCc(List<EmailRecipient> cc);

    _FinalStage bcc(List<EmailRecipient> bcc);

    _FinalStage addBcc(EmailRecipient bcc);

    _FinalStage addAllBcc(List<EmailRecipient> bcc);

    _FinalStage attachments(List<Attachment> attachments);

    _FinalStage addAttachments(Attachment attachments);

    _FinalStage addAllAttachments(List<Attachment> attachments);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ScheduleAtStage, FromStage, MessageStage, _FinalStage {
    private long scheduleAt;

    private EmailRecipient from;

    private EmailMessage message;

    private List<Attachment> attachments = new ArrayList<>();

    private List<EmailRecipient> bcc = new ArrayList<>();

    private List<EmailRecipient> cc = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(EmailOverride other) {
      scheduleAt(other.getScheduleAt());
      from(other.getFrom());
      cc(other.getCc());
      bcc(other.getBcc());
      attachments(other.getAttachments());
      message(other.getMessage());
      return this;
    }

    @Override
    @JsonSetter("schedule_at")
    public FromStage scheduleAt(long scheduleAt) {
      this.scheduleAt = scheduleAt;
      return this;
    }

    @Override
    @JsonSetter("from")
    public MessageStage from(EmailRecipient from) {
      this.from = from;
      return this;
    }

    @Override
    @JsonSetter("message")
    public _FinalStage message(EmailMessage message) {
      this.message = message;
      return this;
    }

    @Override
    public _FinalStage addAllAttachments(List<Attachment> attachments) {
      this.attachments.addAll(attachments);
      return this;
    }

    @Override
    public _FinalStage addAttachments(Attachment attachments) {
      this.attachments.add(attachments);
      return this;
    }

    @Override
    @JsonSetter(
        value = "attachments",
        nulls = Nulls.SKIP
    )
    public _FinalStage attachments(List<Attachment> attachments) {
      this.attachments.clear();
      this.attachments.addAll(attachments);
      return this;
    }

    @Override
    public _FinalStage addAllBcc(List<EmailRecipient> bcc) {
      this.bcc.addAll(bcc);
      return this;
    }

    @Override
    public _FinalStage addBcc(EmailRecipient bcc) {
      this.bcc.add(bcc);
      return this;
    }

    @Override
    @JsonSetter(
        value = "bcc",
        nulls = Nulls.SKIP
    )
    public _FinalStage bcc(List<EmailRecipient> bcc) {
      this.bcc.clear();
      this.bcc.addAll(bcc);
      return this;
    }

    @Override
    public _FinalStage addAllCc(List<EmailRecipient> cc) {
      this.cc.addAll(cc);
      return this;
    }

    @Override
    public _FinalStage addCc(EmailRecipient cc) {
      this.cc.add(cc);
      return this;
    }

    @Override
    @JsonSetter(
        value = "cc",
        nulls = Nulls.SKIP
    )
    public _FinalStage cc(List<EmailRecipient> cc) {
      this.cc.clear();
      this.cc.addAll(cc);
      return this;
    }

    @Override
    public EmailOverride build() {
      return new EmailOverride(scheduleAt, from, cc, bcc, attachments, message);
    }
  }
}
