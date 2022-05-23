package org.raven.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventOverride {

    @SerializedName("email")
    private EmailOverride email = null;

    @SerializedName("sms")
    private SMSOverride sms = null;

    @SerializedName("whatsapp")
    private WhatsappOverride whatsapp = null;

    @SerializedName("push")
    private PushOverride push = null;

    @SerializedName("webhook")
    private WebhookOverride webhook = null;

    @SerializedName("voice")
    private VoiceOverride voice = null;

    @SerializedName("slack")
    private SlackOverride slack = null;

    @SerializedName("telegram")
    private TelegramOverride telegram = null;

    @SerializedName("providers")
    private Map<String, ProviderOverride> providers = null;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChannelOverride {
        @SerializedName("schedule_at")
         Long scheduleAt;
    }

    @Getter
    @Setter
    public static class EmailOverride extends ChannelOverride {

        EmailRecipient from;

        List<EmailRecipient> cc;

        List<EmailRecipient> bcc;

        List<Attachment> attachments;

        @Builder
        EmailOverride(EmailRecipient from, List<EmailRecipient> cc,List<EmailRecipient> bcc,List<Attachment> attachments,Long scheduleAt){
           super(scheduleAt);
           this.from = from;
           this.cc = cc;
           this.bcc = bcc;
           this.attachments = attachments;
           this.scheduleAt = scheduleAt;

        }

    }

    @Getter
    @Setter
    public static class WhatsappOverride extends ChannelOverride {
        @Builder
        WhatsappOverride(Long scheduleAt){
            super(scheduleAt);
        }
    }

    @Getter
    @Setter
    public static class VoiceOverride extends ChannelOverride {
        @Builder
        VoiceOverride(Long scheduleAt){
            super(scheduleAt);
        }
    }

    @Getter
    @Setter
    public static class WebhookOverride extends ChannelOverride {
        @Builder
        WebhookOverride(Long scheduleAt){
            super(scheduleAt);
        }
    }

    @Getter
    @Setter
    public static class PushOverride extends ChannelOverride {
        @Builder
        PushOverride(Long scheduleAt){
            super(scheduleAt);
        }
    }

    @Getter
    @Setter
    public static class SlackOverride extends ChannelOverride {
        @Builder
        SlackOverride(Long scheduleAt){
            super(scheduleAt);
        }
    }

    @Getter
    @Setter
    public static class TelegramOverride extends ChannelOverride {
        @Builder
        TelegramOverride(Long scheduleAt){
            super(scheduleAt);
        }
    }

    @Getter
    @Setter
    public static class SMSOverride extends ChannelOverride {
        String sender;
        @Builder
        SMSOverride(String sender,Long scheduleAt){
            super(scheduleAt);
            this.sender = sender;
        }
    }

    @Getter
    @Setter
    @Builder
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
    @Builder
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



