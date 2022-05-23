package org.raven.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
public class SendEventBulkRequest {
    @SerializedName("event")
    @NonNull
    private String event;

    @SerializedName("batch")
    @NonNull
    private List<EventPayload> batch;

    @Builder
    @AllArgsConstructor
    @Getter
    @Setter
    public static class EventPayload {
        @SerializedName("user")
        @NonNull
        User user;
        @SerializedName("data")
        Data data;
        @SerializedName("override")
        EventOverride override;
    }

}

