package org.raven.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlackProfile {
    @SerializedName("access_token")
    String accessToken;
    @SerializedName("email")
    String email;
    @SerializedName("channel_id")
    String channelId;
}
