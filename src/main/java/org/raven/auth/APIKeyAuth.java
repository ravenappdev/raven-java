package org.raven.auth;

import lombok.Getter;
import lombok.Setter;
import org.raven.utils.Pair;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class APIKeyAuth implements Authentication {
    private final String location;
    private final String paramName;

    private String apiKey;
    private String apiKeyPrefix;

    public APIKeyAuth(String location, String paramName) {
        this.location = location;
        this.paramName = paramName;
    }

    @Override
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
        if (apiKey == null) {
            return;
        }
        String value;
        if (apiKeyPrefix != null) {
            value = apiKeyPrefix + " " + apiKey;
        } else {
            value = apiKey;
        }
        if ("query".equals(location)) {
            queryParams.add(new Pair(paramName, value));
        } else if ("header".equals(location)) {
            headerParams.put(paramName, value);
        }
    }
}
