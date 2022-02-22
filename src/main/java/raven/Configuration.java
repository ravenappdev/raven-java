/*
 * Raven API
 * This is OpenAPI defintion for the APIs of Raven.  You can find out more about Raven at [https://ravenapp.dev/](https://ravenapp.dev/).
 *
 * OpenAPI spec version: 1.0.0
 * Contact: api@ravenapp.dev
 */

package raven;

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
