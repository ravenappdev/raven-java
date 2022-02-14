import raven.RavenException;
import raven.Configuration;
import raven.api.EventApi;
import raven.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration.setApiKey("YXNkaGl3YW1zY2lhdXNuamxxamR3b3ducWlsamRrd3FlcWU=");

        EventApi api = new EventApi();

        String appId = "ead40fc4-34a2-4e7c-abaf-337c00eef79a";

        String event = "TestEventCopy2";

        User user1 = new User();
        user1.setUserId("user1");
        Data data1 = new Data();
        data1.put("key1","value1");


        User user2 = new User();
        user2.setUserId("user2");
        Data data2 = new Data();
        data2.put("key2","value2");

        SendEvent obj = new SendEvent.Builder()
                .event(event)
                .user(user1)
                .data(data1)
                .build();

        Response resp;

        try {
            resp = api.sendEvent(appId, obj);
        } catch (RavenException e) {
            System.out.println(e.getCode() + " " + e.getMessage());
            System.out.println(e.getResponseBody());
            return;
        }

        System.out.println(resp.isSucess());
        System.out.println(resp.getId());

        SendEventBulk.BatchItem item1 = new SendEventBulk.BatchItem.ItemBuilder(user1).data(data1).build();
        SendEventBulk.BatchItem item2 = new SendEventBulk.BatchItem.ItemBuilder(user2).data(data2).build();

        List<SendEventBulk.BatchItem> batchItems = new ArrayList<>();
        batchItems.add(item1);
        batchItems.add(item2);

        SendEventBulk obj2 = new SendEventBulk.Builder()
                .event(event)
                .batch(batchItems)
                .build();

        try {
            resp = api.sendBulkEvent(appId, obj2);
        } catch (RavenException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
            return;
        }

        System.out.println(resp.isSucess());
        System.out.println(resp.getId());
    }
}
