/*
 * Raven API
 * This is OpenAPI defintion for the APIs of Raven.  You can find out more about Raven at [https://ravenapp.dev/](https://ravenapp.dev/).
 *
 * OpenAPI spec version: 1.0.0
 * Contact: api@ravenapp.dev
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package raven.data;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * User
 */
public class User {
  @SerializedName("user_id")
  private String userId = null;

  @SerializedName("mobile")
  private String mobile = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("whatsapp_mobile")
  private String whatsappMobile = null;

  @SerializedName("onesignal_external_id")
  private String onesignalExternalId = null;

  @SerializedName("fcm_tokens")
  private List<String> fcmTokens = null;

  @SerializedName("ios_tokens")
  private List<String> iosTokens = null;

  public User userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(example = "raven user-id", value = "")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public User mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

   /**
   * Get mobile
   * @return mobile
  **/
  @ApiModelProperty(example = "+919876543210", value = "")
  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User whatsappMobile(String whatsappMobile) {
    this.whatsappMobile = whatsappMobile;
    return this;
  }

   /**
   * Get whatsappMobile
   * @return whatsappMobile
  **/
  @ApiModelProperty(example = "+919876543210", value = "")
  public String getWhatsappMobile() {
    return whatsappMobile;
  }

  public void setWhatsappMobile(String whatsappMobile) {
    this.whatsappMobile = whatsappMobile;
  }

  public User onesignalExternalId(String onesignalExternalId) {
    this.onesignalExternalId = onesignalExternalId;
    return this;
  }

   /**
   * Get onesignalExternalId
   * @return onesignalExternalId
  **/
  @ApiModelProperty(example = "onesignal external user-id", value = "")
  public String getOnesignalExternalId() {
    return onesignalExternalId;
  }

  public void setOnesignalExternalId(String onesignalExternalId) {
    this.onesignalExternalId = onesignalExternalId;
  }

  public User fcmTokens(List<String> fcmTokens) {
    this.fcmTokens = fcmTokens;
    return this;
  }

  public User addFcmTokensItem(String fcmTokensItem) {
    if (this.fcmTokens == null) {
      this.fcmTokens = new ArrayList<String>();
    }
    this.fcmTokens.add(fcmTokensItem);
    return this;
  }

   /**
   * Get fcmTokens
   * @return fcmTokens
  **/
  @ApiModelProperty(example = "[\"fcm_token1\",\"fcm_token2\"]", value = "")
  public List<String> getFcmTokens() {
    return fcmTokens;
  }

  public void setFcmTokens(List<String> fcmTokens) {
    this.fcmTokens = fcmTokens;
  }

  public User iosTokens(List<String> iosTokens) {
    this.iosTokens = iosTokens;
    return this;
  }

  public User addIosTokensItem(String iosTokensItem) {
    if (this.iosTokens == null) {
      this.iosTokens = new ArrayList<String>();
    }
    this.iosTokens.add(iosTokensItem);
    return this;
  }

   /**
   * Get iosTokens
   * @return iosTokens
  **/
  @ApiModelProperty(example = "[\"ios_token1\",\"ios_token2\"]", value = "")
  public List<String> getIosTokens() {
    return iosTokens;
  }

  public void setIosTokens(List<String> iosTokens) {
    this.iosTokens = iosTokens;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userId, user.userId) &&
        Objects.equals(this.mobile, user.mobile) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.whatsappMobile, user.whatsappMobile) &&
        Objects.equals(this.onesignalExternalId, user.onesignalExternalId) &&
        Objects.equals(this.fcmTokens, user.fcmTokens) &&
        Objects.equals(this.iosTokens, user.iosTokens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, mobile, email, whatsappMobile, onesignalExternalId, fcmTokens, iosTokens);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    whatsappMobile: ").append(toIndentedString(whatsappMobile)).append("\n");
    sb.append("    onesignalExternalId: ").append(toIndentedString(onesignalExternalId)).append("\n");
    sb.append("    fcmTokens: ").append(toIndentedString(fcmTokens)).append("\n");
    sb.append("    iosTokens: ").append(toIndentedString(iosTokens)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
