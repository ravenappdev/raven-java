package org.raven.config;

import org.raven.client.APIClient;

public class Configuration {
    private static APIClient defaultApiClient = new APIClient();

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public static APIClient getDefaultApiClient() {
        return defaultApiClient;
    }

    /**
     * Set the ApiKey value of the client
     *
     */
    public static void setApiKey(String secretKey) {
        defaultApiClient.setApiKey(secretKey);
        defaultApiClient.setApiKeyPrefix("AuthKey");
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param apiClient API client
     */
    public static void setDefaultApiClient(APIClient apiClient) {
        defaultApiClient = apiClient;
    }
}
