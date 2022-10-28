package sample;

import com.raven.api.RavenApiClient;
import com.raven.api.client.Authorization;
import com.raven.api.client.device.endpoints.Add;
import com.raven.api.client.device.exceptions.AddException;
import com.raven.api.client.device.types.Device;
import com.raven.api.client.ids.types.AppId;
import com.raven.api.client.ids.types.UserId;

public final class App {
  public static void main(String[] args) {
      String appId = System.getenv("RAVEN_APP_ID");
      String authKey = System.getenv("RAVEN_TOKEN");
      Authorization auth = Authorization.of(authKey);

      RavenApiClient ravenApiClient =
                new RavenApiClient("api.ravenapp.dev", auth);

      try {
          Device device = ravenApiClient.device().add(Add.Request.builder()
                  .appId(AppId.of(appId))
                  .userId(UserId.of("myUser"))
                  .body(Device.builder()
                          .fcmToken("abc123")
                          .id("cdf456")
                          .notificationsDisabled(false)
                          .build())
                  .build());
          System.out.println("Created a device! The device's Raven ID is " + device.getRavenId());
      } catch (AddException e) {
          System.out.println("Failed to create a device" + e.getMessage());
      }
  }
}
