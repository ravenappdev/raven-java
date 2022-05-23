# Raven

Raven Client SDK for JAVA

## Installation

[//]: # (To install the API client library to your local Maven repository, simply execute:)

[//]: # ()
[//]: # (```shell)

[//]: # (mvn clean install)

[//]: # (```)

[//]: # ()
[//]: # (To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:)

[//]: # ()
[//]: # (```shell)

[//]: # (mvn clean deploy)

[//]: # (```)

[//]: # ()
[//]: # (Refer to the [OSSRH Guide]&#40;http://central.sonatype.org/pages/ossrh-guide.html&#41; for more information.)

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.raven</groupId>
  <artifactId>raven-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.raven:raven-client:1.0.0"
```

[//]: # (### Others)

[//]: # ()
[//]: # (At first generate the JAR by executing:)

[//]: # ()
[//]: # (```shell)

[//]: # (mvn clean package)

[//]: # (```)

[//]: # ()
[//]: # (Then manually install the following JARs:)

[//]: # ()
[//]: # (* `target/raven-client-1.0.0.jar`)

[//]: # (* `target/lib/*.jar`)

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

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

## Documentation for API Endpoints

All URIs are relative to *https://api.ravenapp.dev*

| Class         | Method                                       | HTTP request                                | Description                                          |
|---------------|----------------------------------------------|---------------------------------------------|------------------------------------------------------|
| *RavenClient* | [**sendBulk**](docs/RavenClient.md#sendBulk) | **POST** /v1/apps/{app_id}/events/bulk_send | sends the event in bulk to all the clients specified |
| *RavenClient* | [**send**](docs/RavenClient.md#send)         | **POST** /v1/apps/{app_id}/events/send      | sends the event to the client specified              |

## Documentation for Models

 - [Attachments](docs/Attachments.md)
 - [Data](docs/Data.md)
 - [EmailOverride](docs/EmailOverride.md)
 - [EmailRecipient](docs/EmailRecipient.md)
 - [EventOverride](docs/EventOverride.md)
 - [Param](docs/Param.md)
 - [ProviderOverride](docs/ProviderOverride.md)
 - [PushOverride](docs/PushOverride.md)
 - [Response](docs/SendEventResponse.md)
 - [SendEvent](docs/SendEventRequest.md)
 - [SendEventBulk](docs/SendEventBulkRequest.md)
 - [SlackOverride](docs/SlackOverride.md)
 - [SlackProfile](docs/SlackProfile.md)
 - [SmsOverride](docs/SmsOverride.md)
 - [User](docs/User.md)
 - [VoiceOverride](docs/VoiceOverride.md)
 - [WebhookOverride](docs/WebhookOverride.md)
 - [WhatsappOverride](docs/WhatsappOverride.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### ApiKeyAuth

- **Type**: API key
- **API key parameter name**: Authorization
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

api@ravenapp.dev

