package org.raven.models;


import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelegramProfile {
    @SerializedName("chat_id")
    String chatId;
}
