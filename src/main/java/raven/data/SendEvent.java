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

import com.google.gson.annotations.SerializedName;

/**
 * SendEvent
 */
public class SendEvent {
    @SerializedName("event")
    private String event = null;

    @SerializedName("user")
    private User user = null;

    @SerializedName("data")
    private Data data = null;

    @SerializedName("override")
    private EventOverride override = null;


    private SendEvent(Builder builder) {
        this.event = builder.event;
        this.user = builder.user;
        this.data = builder.data;
        this.override = builder.override;
    }

    /**
     * Get event
     *
     * @return event
     **/
    public String getEvent() {
        return event;
    }

    /**
     * Get user
     *
     * @return user
     **/
    public User getUser() {
        return user;
    }

    /**
     * Get data
     *
     * @return data
     **/
    public Data getData() {
        return data;
    }

    /**
     * Get override
     *
     * @return override
     **/
    public EventOverride getOverride() {
        return override;
    }

    /**
     * Builder for the SendEvent class objects
     **/
    public static class Builder {
        private String event;
        private User user;
        private Data data;
        private EventOverride override;

        public Builder() {
        }

        public Builder event(String event) {
            this.event = event;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder data(Data data) {
            this.data = data;
            return this;
        }

        public Builder override(EventOverride override) {
            this.override = override;
            return this;
        }

        public SendEvent build() {
            SendEvent obj = new SendEvent(this);
            validateObject(obj);
            return obj;
        }

        private void validateObject(SendEvent obj) {
            if (obj.event == null || obj.user == null) {
                throw new IllegalStateException("event or user is null");
            }
        }
    }
}

