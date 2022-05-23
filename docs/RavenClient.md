# RavenClient

All URIs are relative to *https://api.ravenapp.dev*

| Method                    | HTTP request                                | Description                                          |
|---------------------------|---------------------------------------------|------------------------------------------------------|
| [**sendBulk**](#sendBulk) | **POST** /v1/apps/{app_id}/events/bulk_send | sends the event in bulk to all the clients specified |
| [**send**](#send)         | **POST** /v1/apps/{app_id}/events/send      | sends the event to the client specified              |

# **sendBulk**
> SendEventResponse sendBulk(appId, event, idempotencyKey)

sends the event in bulk to all the clients specified

This API will send the event in bulk to the clients specified

### Example
```java
    import org.raven.config.*;
    import org.raven.client.*;
    import org.raven.auth.*;
    import org.raven.exceptions.RavenException;
    import org.raven.models.*;
    
    public class RavenClientExample {
    
        public static void main(String[] args) {
            RavenClient apiInstance = new RavenClient("YOU_API_KEY");
            String appId = "appId_example"; // String | app id of raven app
            SendEventBulkRequest event = SendEventBulkRequest.builder().event("test").batch(/*BATCH ARRAY*/).build(); // SendEventBulk | the body for the event that has to be triggered
            String idempotencyKey = "idempotencyKey_example"; // String | idempotency key of api
            try {
                SendEventResponse result = apiInstance.sendBulk(appId, event, idempotencyKey);
                System.out.println(result);
            } catch (RavenException e) {
                System.err.println("Exception when calling RavenClient#sendBulk");
                e.printStackTrace();
            }
        }
    }

```

### Parameters

| Name               | Type                                                | Description                                     | Notes      |
|--------------------|-----------------------------------------------------|-------------------------------------------------|------------|
| **appId**          | **String**                                          | app id of raven app                             |            |
| **event**          | [**SendEventBulkRequest**](SendEventBulkRequest.md) | the body for the event that has to be triggered |            |
| **idempotencyKey** | **String**                                          | idempotency key of api                          | [optional] |

### Return type

[**SendEventResponse**](SendEventResponse.md)

### Authorization

**ApiKeyAuth**

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

# **send**
> SendEventResponse send(appId, event, idempotencyKey)

sends the event to the client specified

This API will send the event to the client specified

### Example
```java
    import org.raven.config.*;
    import org.raven.client.*;
    import org.raven.auth.*;
    import org.raven.exceptions.RavenException;
    import org.raven.models.*;
    
    public class RavenClientExample {
    
        public static void main(String[] args) {
            RavenClient apiInstance = new RavenClient("YOU_API_KEY");
            String appId = "appId_example"; // String | app id of raven app
            SendEventRequest event = SendEventRequest.builder().event("test").user(/*RAVEN USER*/).data(/*YOUR DATA*/).override(/*override*/).build(); // SendEventBulk | the body for the event that has to be triggered
            String idempotencyKey = "idempotencyKey_example"; // String | idempotency key of api
            try {
                SendEventResponse result = apiInstance.send(appId, event, idempotencyKey);
                System.out.println(result);
            } catch (RavenException e) {
                System.err.println("Exception when calling RavenClient#sendBulk");
                e.printStackTrace();
            }
        }
    }

```

### Parameters

| Name               | Type                                        | Description                                     | Notes      |
|--------------------|---------------------------------------------|-------------------------------------------------|------------|
| **appId**          | **String**                                  | app id of raven app                             |            |
| **event**          | [**SendEventRequest**](SendEventRequest.md) | the body for the event that has to be triggered |            |
| **idempotencyKey** | **String**                                  | idempotency key of api                          | [optional] |

### Return type

[**SendEventResponse**](SendEventResponse.md)

### Authorization

**ApiKeyAuth**

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

