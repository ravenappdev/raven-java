# raven-java
Java SDK for Raven
## Installation
```

```
## Documentation

### 1. Introduction
Java SDK helps you send notifications through Raven

APIs supported:

-	Send Event
-	Send Event Bulk 

### 3. Usage
Create a NewAPIClient using your secretKey as shown below:

``` java
RavenClient client = new RavenClient();
```

Here is an example for sending a notification event using Raven API.

```java
import raven.RavenException;
import raven.data.SendEventRequest;
import raven.data.User;

import java.util.HashMap;
import java.util.Map;

public class RavenExample {

    public static void main(String[] args) {
        RavenClient client = new RavenClient("<secret_key>");
        String appId = "<app_id>";
        SendEventRequest request = new SendEventRequest.Builder().event("payment_complete")
                                            .user(new User.Builder()
                                                    .email("john.doe@gmail.com")
                                                    .mobile("+19876543210")
                                                 )
                                            .data(Map.of("name", "John Doe", "amount", "123456"));
        
        try {
            client.send(appId, request);
        } catch (RavenException e) {
            e.printStackTrace();
        }
    }
}
	
```
