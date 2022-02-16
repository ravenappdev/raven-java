/*
 * Raven API
 * This is OpenAPI defintion for the APIs of Raven.  You can find out more about Raven at [https://ravenapp.dev/](https://ravenapp.dev/).
 *
 * OpenAPI spec version: 1.0.0
 * Contact: api@ravenapp.dev
*/


package raven.api;

import raven.*;
import raven.RavenClient;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import raven.data.Response;
import raven.data.SendEvent;
import raven.data.SendEventBulk;
import raven.utils.Pair;
import raven.utils.ProgressRequestBody;
import raven.utils.ProgressResponseBody;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendEventApi {
    private RavenClient apiClient;

    public SendEventApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SendEventApi(RavenClient apiClient) {
        this.apiClient = apiClient;
    }

    public RavenClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(RavenClient ravenClient) {
        this.apiClient = ravenClient;
    }

    /**
     * Build call for sendBulkEvent
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws RavenException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call sendBulkEventCall(String appId, SendEventBulk event, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
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
    private com.squareup.okhttp.Call sendBulkEventValidateBeforeCall(String appId, SendEventBulk event, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
        
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new RavenException("Missing the required parameter 'appId' when calling sendBulkEvent(Async)");
        }
        
        // verify the required parameter 'event' is set
        if (event == null) {
            throw new RavenException("Missing the required parameter 'event' when calling sendBulkEvent(Async)");
        }
        

        com.squareup.okhttp.Call call = sendBulkEventCall(appId, event, progressListener, progressRequestListener);
        return call;

    }

    /**
     * sends the event in bulk to all the clients specified
     * This API will send the event in bulk to the clients specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @return Response
     * @throws RavenException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response sendBulkEvent(String appId, SendEventBulk event) throws RavenException {
        ApiResponse<Response> resp = sendBulkEventWithHttpInfo(appId, event);
        return resp.getData();
    }

    /**
     * sends the event in bulk to all the clients specified
     * This API will send the event in bulk to the clients specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws RavenException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> sendBulkEventWithHttpInfo(String appId, SendEventBulk event) throws RavenException {
        com.squareup.okhttp.Call call = sendBulkEventValidateBeforeCall(appId, event, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * sends the event in bulk to all the clients specified (asynchronously)
     * This API will send the event in bulk to the clients specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws RavenException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call sendBulkEventAsync(String appId, SendEventBulk event, final ApiCallback<Response> callback) throws RavenException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = sendBulkEventValidateBeforeCall(appId, event, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
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
    public com.squareup.okhttp.Call sendEventCall(String appId, SendEvent event, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
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
    private com.squareup.okhttp.Call sendEventValidateBeforeCall(String appId, SendEvent event, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws RavenException {
        
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new RavenException("Missing the required parameter 'appId' when calling sendEvent(Async)");
        }
        
        // verify the required parameter 'event' is set
        if (event == null) {
            throw new RavenException("Missing the required parameter 'event' when calling sendEvent(Async)");
        }
        

        com.squareup.okhttp.Call call = sendEventCall(appId, event, progressListener, progressRequestListener);
        return call;

    }

    /**
     * sends the event to the client specified
     * This API will send the event to the client specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @return Response
     * @throws RavenException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response sendEvent(String appId, SendEvent event) throws RavenException {
        ApiResponse<Response> resp = sendEventWithHttpInfo(appId, event);
        return resp.getData();
    }

    /**
     * sends the event to the client specified
     * This API will send the event to the client specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws RavenException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> sendEventWithHttpInfo(String appId, SendEvent event) throws RavenException {
        com.squareup.okhttp.Call call = sendEventValidateBeforeCall(appId, event, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * sends the event to the client specified (asynchronously)
     * This API will send the event to the client specified
     * @param appId app id of raven app (required)
     * @param event the body for the event that has to be triggered (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws RavenException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call sendEventAsync(String appId, SendEvent event, final ApiCallback<Response> callback) throws RavenException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = sendEventValidateBeforeCall(appId, event, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
