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
    builder = Attachment.Builder.class
)
public final class Attachment {
  private final String fileName;

  private final String content;

  private final String url;

  private int _cachedHashCode;

  Attachment(String fileName, String content, String url) {
    this.fileName = fileName;
    this.content = content;
    this.url = url;
  }

  @JsonProperty("file_name")
  public String getFileName() {
    return fileName;
  }

  @JsonProperty("content")
  public String getContent() {
    return content;
  }

  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Attachment && equalTo((Attachment) other);
  }

  private boolean equalTo(Attachment other) {
    return fileName.equals(other.fileName) && content.equals(other.content) && url.equals(other.url);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.fileName, this.content, this.url);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Attachment{" + "fileName: " + fileName + ", content: " + content + ", url: " + url + "}";
  }

  public static FileNameStage builder() {
    return new Builder();
  }

  public interface FileNameStage {
    ContentStage fileName(String fileName);

    Builder from(Attachment other);
  }

  public interface ContentStage {
    UrlStage content(String content);
  }

  public interface UrlStage {
    _FinalStage url(String url);
  }

  public interface _FinalStage {
    Attachment build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements FileNameStage, ContentStage, UrlStage, _FinalStage {
    private String fileName;

    private String content;

    private String url;

    private Builder() {
    }

    @Override
    public Builder from(Attachment other) {
      fileName(other.getFileName());
      content(other.getContent());
      url(other.getUrl());
      return this;
    }

    @Override
    @JsonSetter("file_name")
    public ContentStage fileName(String fileName) {
      this.fileName = fileName;
      return this;
    }

    @Override
    @JsonSetter("content")
    public UrlStage content(String content) {
      this.content = content;
      return this;
    }

    @Override
    @JsonSetter("url")
    public _FinalStage url(String url) {
      this.url = url;
      return this;
    }

    @Override
    public Attachment build() {
      return new Attachment(fileName, content, url);
    }
  }
}
