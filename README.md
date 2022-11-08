# Raven Java Library

![Maven Central](https://img.shields.io/maven-central/v/dev.ravenapp/raven-java) 
![Sonatype Nexus (Releases)](https://img.shields.io/nexus/r/dev.ravenapp/raven-java?server=https%3A%2F%2Fs01.oss.sonatype.org)

## Documentation

API documentation is available at <https://docs.ravenapp.dev/introduction>.

## Installation

### Gradle users

Add this dependency to your project's build file:

```groovy
implementation "dev.ravenapp:raven-java:0.0.24"
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>dev.ravenapp</groupId>
  <artifactId>raven-java</artifactId>
  <version>0.0.31</version>
</dependency>
```

## Usage

```java
RavenApiClient ravenApiClient = new RavenApiClient("api.ravenapp.dev", Authorization.of("AuthKey <auth>"));
try {
    var response = client.send(Send.Request.builder()
                .appId("<app_id>")
                .body(SendEventRequest.builder()
                    .event("payment_alert")
                    .data(Map.of("name", "Adam"))
                    .user(User.builder().mobile("+1234567890").build())
                    .build())
                .build());
    
    System.out.println(response.getId());
} catch (SendException e) {
   System.out.println("Failed to send request" + e.getMessage());
}
```

## Sample app

Check out the [sample app](sample-app/src/main/java/sample/App.java) which consumes this SDK.

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning the package version to a specific version in your build.gradle file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest [opening an issue](https://github.com/ravenappdev/raven-java) first to discuss with us!

On the other hand, contributions to the README are always very welcome!
