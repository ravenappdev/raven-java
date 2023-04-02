package com.raven.api.resources.user.requests;

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
    builder = CreateUserRequest.Builder.class
)
public final class CreateUserRequest {
  private final String userId;

  private final Optional<String> mobile;

  private final Optional<String> email;

  private final Optional<String> whatsApp;

  private int _cachedHashCode;

  CreateUserRequest(String userId, Optional<String> mobile, Optional<String> email,
      Optional<String> whatsApp) {
    this.userId = userId;
    this.mobile = mobile;
    this.email = email;
    this.whatsApp = whatsApp;
  }

  /**
   * @return Your user identifier.
   * if user_id already exists, user properties will be updated else a new user will be created
   */
  @JsonProperty("user_id")
  public String getUserId() {
    return userId;
  }

  @JsonProperty("mobile")
  public Optional<String> getMobile() {
    return mobile;
  }

  @JsonProperty("email")
  public Optional<String> getEmail() {
    return email;
  }

  /**
   * @return include this only when user's whatsapp mobile is different than primary mobile
   */
  @JsonProperty("whats_app")
  public Optional<String> getWhatsApp() {
    return whatsApp;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateUserRequest && equalTo((CreateUserRequest) other);
  }

  private boolean equalTo(CreateUserRequest other) {
    return userId.equals(other.userId) && mobile.equals(other.mobile) && email.equals(other.email) && whatsApp.equals(other.whatsApp);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.userId, this.mobile, this.email, this.whatsApp);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateUserRequest{" + "userId: " + userId + ", mobile: " + mobile + ", email: " + email + ", whatsApp: " + whatsApp + "}";
  }

  public static UserIdStage builder() {
    return new Builder();
  }

  public interface UserIdStage {
    _FinalStage userId(String userId);

    Builder from(CreateUserRequest other);
  }

  public interface _FinalStage {
    CreateUserRequest build();

    _FinalStage mobile(Optional<String> mobile);

    _FinalStage mobile(String mobile);

    _FinalStage email(Optional<String> email);

    _FinalStage email(String email);

    _FinalStage whatsApp(Optional<String> whatsApp);

    _FinalStage whatsApp(String whatsApp);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UserIdStage, _FinalStage {
    private String userId;

    private Optional<String> whatsApp = Optional.empty();

    private Optional<String> email = Optional.empty();

    private Optional<String> mobile = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(CreateUserRequest other) {
      userId(other.getUserId());
      mobile(other.getMobile());
      email(other.getEmail());
      whatsApp(other.getWhatsApp());
      return this;
    }

    /**
     * <p>Your user identifier.
     * if user_id already exists, user properties will be updated else a new user will be created</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("user_id")
    public _FinalStage userId(String userId) {
      this.userId = userId;
      return this;
    }

    /**
     * <p>include this only when user's whatsapp mobile is different than primary mobile</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage whatsApp(String whatsApp) {
      this.whatsApp = Optional.of(whatsApp);
      return this;
    }

    @Override
    @JsonSetter(
        value = "whats_app",
        nulls = Nulls.SKIP
    )
    public _FinalStage whatsApp(Optional<String> whatsApp) {
      this.whatsApp = whatsApp;
      return this;
    }

    @Override
    public _FinalStage email(String email) {
      this.email = Optional.of(email);
      return this;
    }

    @Override
    @JsonSetter(
        value = "email",
        nulls = Nulls.SKIP
    )
    public _FinalStage email(Optional<String> email) {
      this.email = email;
      return this;
    }

    @Override
    public _FinalStage mobile(String mobile) {
      this.mobile = Optional.of(mobile);
      return this;
    }

    @Override
    @JsonSetter(
        value = "mobile",
        nulls = Nulls.SKIP
    )
    public _FinalStage mobile(Optional<String> mobile) {
      this.mobile = mobile;
      return this;
    }

    @Override
    public CreateUserRequest build() {
      return new CreateUserRequest(userId, mobile, email, whatsApp);
    }
  }
}
