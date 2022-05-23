package org.raven.client;

import com.google.gson.reflect.TypeToken;
import org.raven.models.APIResponse;
import org.raven.config.Configuration;
import org.raven.exceptions.RavenException;
import org.raven.models.SendEventBulkRequest;
import org.raven.models.SendEventRequest;
import org.raven.models.SendEventResponse;
import org.raven.utils.Pair;
import org.raven.utils.ProgressRequestBody;
import org.raven.utils.ProgressResponseBody;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RavenClient {
    private APIClient apiClient;

    public RavenClient(String secretKey) {
        this(Configuration.getDefaultApiClient());
        Configuration.setApiKey(secretKey);
    }

    public RavenClient(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    public APIClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(APIClient APIClient) {
        this.apiClient = APIClient;
    }



    public SendEventResponse send(String appId, SendEventRequest event, String idempotencyKey) throws RavenException {
        APIResponse<SendEventResponse> resp = sendWithHttpInfo(appId, event, idempotencyKey);
        return resp.getData();
    }


    public SendEventResponse sendBulk(String appId, SendEventBulkRequest event, String idempotencyKey) throws RavenException {
        APIResponse<SendEventResponse> resp = sendBulkWithHttpInfo(appId, event, idempotencyKey);
        return resp.getData();
    }


    /**
     * Build call for sendBulkEvent
     * @param appId Raven appID (required)
     * @param event the body for the event that has to be triggered (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws RavenException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call sendBulkCall(String appId, SendEventBulkRequest event, String idempotencyKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
        Object localVarPostBody = event;

        // create path and map variables
        String localVarPath = "/v1/apps/{app_id}/events/bulk_send"
            .replaceAll("\\{" + "app_id" + "\\}", apiClient.escapeString(appId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("Idempotency-Key", idempotencyKey);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private com.squareup.okhttp.Call sendBulkValidateBeforeCall(String appId, SendEventBulkRequest event, String idempotencyKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
        
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new RavenException("Missing the required parameter 'appId' when calling sendBulkEvent");
        }
        
        // verify the required parameter 'event' is set
        if (event == null) {
            throw new RavenException("Missing the required parameter 'event' when calling sendBulkEvent");
        }
        

        com.squareup.okhttp.Call call = sendBulkCall(appId, event, idempotencyKey,  progressListener, progressRequestListener);
        return call;

    }


    /**
     * sends the event in bulk to all the clients specified
     * This API will send the event in bulk to the clients specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws RavenException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private APIResponse<SendEventResponse> sendBulkWithHttpInfo(String appId, SendEventBulkRequest event, String idempotencyKey) throws RavenException {
        com.squareup.okhttp.Call call = sendBulkValidateBeforeCall(appId, event, idempotencyKey,null, null);
        Type localVarReturnType = new TypeToken<SendEventResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Build call for sendEvent
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws RavenException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call sendCall(String appId, SendEventRequest event, String idempotencyKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
        Object localVarPostBody = event;

        // create path and map variables
        String localVarPath = "/v1/apps/{app_id}/events/send"
            .replaceAll("\\{" + "app_id" + "\\}", apiClient.escapeString(appId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("Idempotency-Key", idempotencyKey);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }


    private com.squareup.okhttp.Call sendValidateBeforeCall(String appId, SendEventRequest event, String idempotencyKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
        
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new RavenException("Missing the required parameter 'appId' when calling sendEvent");
        }
        
        // verify the required parameter 'event' is set
        if (event == null) {
            throw new RavenException("Missing the required parameter 'event' when calling sendEvent");
        }
        

        com.squareup.okhttp.Call call = sendCall(appId, event,idempotencyKey, progressListener, progressRequestListener);
        return call;

    }

    /**
     * sends the event to the client specified
     * This API will send the event to the client specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws RavenException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private APIResponse<SendEventResponse> sendWithHttpInfo(String appId, SendEventRequest event, String idempotencyKey) throws RavenException {
        com.squareup.okhttp.Call call = sendValidateBeforeCall(appId, event,idempotencyKey, null, null);
        Type localVarReturnType = new TypeToken<SendEventResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
}
