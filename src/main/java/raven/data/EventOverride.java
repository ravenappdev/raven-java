package raven.data;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventOverride {

    @SerializedName("email")
    EmailOverride email;

    @SerializedName("sms")
    SMSOverride sms;

    @SerializedName("whatsapp")
    WhatsappOverride whatsapp;

    @SerializedName("push")
    PushOverride push;

    @SerializedName("webhook")
    WebhookOverride webhook;

    @SerializedName("voice")
    VoiceOverride voice;

    @SerializedName("slack")
    SlackOverride slack;

    @SerializedName("providers")
    Map<String, ProviderOverride> providers;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class EmailOverride extends ChannelOverride {

        EmailRecipient from;

        List<EmailRecipient> cc;

        List<EmailRecipient> bcc;

        List<Attachment> attachments;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class WhatsappOverride extends ChannelOverride {
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class VoiceOverride extends ChannelOverride {
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class WebhookOverride extends ChannelOverride {
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class PushOverride extends ChannelOverride {
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SlackOverride extends ChannelOverride {
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SMSOverride extends ChannelOverride {

        String sender;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Attachment {

        @SerializedName("file_name")
        String fileName;

        @SerializedName("content")
        String content;

        @SerializedName("url")
        String url;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ChannelOverride {

        @SerializedName("schedule_at")
        @Setter
        protected Long scheduleAt;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ProviderOverride {

        Map<String, Object> payload;

        @SerializedName("form_params")
        List<Param> formParams;

        @SerializedName("query_params")
        List<Param> queryParams;

        Map<String, String> config;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Param {
            String name;

            String value;
        }
    }


}



