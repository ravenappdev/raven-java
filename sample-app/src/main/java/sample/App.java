package sample;

import com.raven.api.RavenApiClient;
import com.raven.api.resources.device.types.Device;

public final class App {
  public static void main(String[] args) {
      RavenApiClient ravenApiClient = RavenApiClient.builder()
              .authKey(System.getenv("RAVEN_TOKEN"))
              .build();

      Device device = ravenApiClient.device().add("app-id","user-id", Device.builder()
              .fcmToken("abc123")
              .id("cdf456")
              .notificationsDisabled(false)
              .build());
      System.out.println("Created a device! The device's Raven ID is " + device.getRavenId());
  }
}
