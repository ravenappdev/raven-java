/*
 * Raven API
 * This is OpenAPI defintion for the APIs of Raven.  You can find out more about Raven at [https://ravenapp.dev/](https://ravenapp.dev/).
 *
 * OpenAPI spec version: 1.0.0
 * Contact: api@ravenapp.dev
*/

package raven.api;

import raven.*;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import raven.data.SendEventResponse;
import raven.data.SendEventRequest;
import raven.data.SendEventBulkRequest;
import raven.utils.Pair;
import raven.utils.ProgressRequestBody;
import raven.utils.ProgressResponseBody;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RavenClient {
    private APIClient apiClient;

    public RavenClient() {
        this(Configuration.getDefaultApiClient());
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


    /**
     * sends the event to the client specified
     * This API will send the event to the client specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @return Response
     * @throws RavenException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SendEventResponse send(String appId, SendEventRequest event) throws RavenException {
        APIResponse<SendEventResponse> resp = sendWithHttpInfo(appId, event);
        return resp.getData();
    }

    /**
     * sends the event in bulk to all the users specified
     * This API will send the event in bulk to the clients specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @return Response
     * @throws RavenException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SendEventResponse sendBulk(String appId, SendEventBulkRequest event) throws RavenException {
        APIResponse<SendEventResponse> resp = sendBulkWithHttpInfo(appId, event);
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
    private com.squareup.okhttp.Call sendBulkCall(String appId, SendEventBulkRequest event, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
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

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call sendBulkValidateBeforeCall(String appId, SendEventBulkRequest event, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
        
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new RavenException("Missing the required parameter 'appId' when calling sendBulkEvent(Async)");
        }
        
        // verify the required parameter 'event' is set
        if (event == null) {
            throw new RavenException("Missing the required parameter 'event' when calling sendBulkEvent(Async)");
        }
        

        com.squareup.okhttp.Call call = sendBulkCall(appId, event, progressListener, progressRequestListener);
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
    private APIResponse<SendEventResponse> sendBulkWithHttpInfo(String appId, SendEventBulkRequest event) throws RavenException {
        com.squareup.okhttp.Call call = sendBulkValidateBeforeCall(appId, event, null, null);
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
    private com.squareup.okhttp.Call sendCall(String appId, SendEventRequest event, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
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

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call sendValidateBeforeCall(String appId, SendEventRequest event, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
        
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new RavenException("Missing the required parameter 'appId' when calling sendEvent(Async)");
        }
        
        // verify the required parameter 'event' is set
        if (event == null) {
            throw new RavenException("Missing the required parameter 'event' when calling sendEvent(Async)");
        }
        

        com.squareup.okhttp.Call call = sendCall(appId, event, progressListener, progressRequestListener);
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
    private APIResponse<SendEventResponse> sendWithHttpInfo(String appId, SendEventRequest event) throws RavenException {
        com.squareup.okhttp.Call call = sendValidateBeforeCall(appId, event, null, null);
        Type localVarReturnType = new TypeToken<SendEventResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
}
