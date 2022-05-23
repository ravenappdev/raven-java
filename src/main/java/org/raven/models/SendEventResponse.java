package org.raven.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.ArrayList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SendEventResponse {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("id")
    private String id;

    @SerializedName("error")
    private String error;

    @SerializedName("errors")
    private ArrayList<String> errors;


}

