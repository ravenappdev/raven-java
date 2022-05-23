package org.raven.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

  @SerializedName("fcm_topic")
  private List<String> fcmTopic = null;

  @SerializedName("fcm_device_group")
  private List<String> fcmDeviceGroup = null;

  @SerializedName("slack")
  private SlackProfile slack = null;

  @SerializedName("telegram")
  TelegramProfile telegramProfile;

  @SerializedName("onesignal_player_ids")
  private List<String> onesignalPlayerIds = null;

}

