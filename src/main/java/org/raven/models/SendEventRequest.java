package org.raven.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SendEventRequest {
    @SerializedName("event")
    @NonNull
    private String event;

    @SerializedName("user")
    @NonNull
    private User user;

    @SerializedName("data")
    private Data data = null;

    @SerializedName("schedule_at")
    private String scheduleAt = null;

    @SerializedName("override")
    private EventOverride override = null;
}

