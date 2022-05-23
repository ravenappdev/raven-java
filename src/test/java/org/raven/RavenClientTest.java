package org.raven;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.raven.client.RavenClient;
import org.raven.models.SendEventBulkRequest;
import org.raven.models.SendEventRequest;
import org.raven.models.SendEventResponse;
import org.raven.exceptions.RavenException;
import org.raven.utils.JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class RavenClientTest {
    private static File jsonFile = new File("src/test/resources/testData.json");
    private static JsonObject testData;

    static {
        try {
            testData = new JsonParser().parse(new FileReader(jsonFile)).getAsJsonObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String apiKey = testData.get("apiKey").getAsString();
    private static JsonArray sendBulkTestCases = testData.getAsJsonObject("EventApi").getAsJsonArray("sendBulkEvent");
    private static JsonArray sendTestCases = testData.getAsJsonObject("EventApi").getAsJsonArray("sendEvent");
    private RavenClient client;

    @BeforeEach
    private void init(){
        client = new RavenClient(apiKey);
    }
    @ParameterizedTest(name = "{0}")
    @MethodSource("sendBulkTestCasesProvider")
    public void sendBulkTest(String testName, String appId, SendEventBulkRequest event,String idempotencyKey, Output out) {
        try {
            SendEventResponse response = client.sendBulk(appId, event, idempotencyKey);
            Assertions.assertEquals(out.data.getSuccess(),response.getSuccess());
            Assertions.assertEquals(out.data.getError(),response.getError());
            Assertions.assertEquals(out.data.getErrors(),response.getErrors());

        }catch (RavenException e){
            Assertions.assertEquals(out.message,e.getMessage());
            Assertions.assertEquals(out.code,e.getCode());
            if(e.getData()!=null){
                Assertions.assertEquals(out.data.getSuccess(), e.getData().getSuccess());
                Assertions.assertEquals(out.data.getError(), e.getData().getError());
                Assertions.assertEquals(out.data.getErrors(), e.getData().getErrors());
            }
            else{
                Assertions.assertEquals(out.data,e.getData());
            }

        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("sendTestCasesProvider")
    public void sendTest(String testName, String appId, SendEventRequest event, String idempotencyKey, Output out) {
        try {
            SendEventResponse response = client.send(appId, event, idempotencyKey);
            Assertions.assertEquals(out.data.getSuccess(),response.getSuccess());
            Assertions.assertEquals(out.data.getError(),response.getError());
            Assertions.assertEquals(out.data.getErrors(),response.getErrors());
        }catch (RavenException e){
            Assertions.assertEquals(out.message,e.getMessage());
            Assertions.assertEquals(out.code,e.getCode());
            if(e.getData()!=null){
                Assertions.assertEquals(out.data.getSuccess(), e.getData().getSuccess());
                Assertions.assertEquals(out.data.getError(), e.getData().getError());
                Assertions.assertEquals(out.data.getErrors(), e.getData().getErrors());
            }
            else{
                Assertions.assertEquals(out.data,e.getData());
            }
        }
    }

    private static Stream<Arguments> sendBulkTestCasesProvider(){
        List<Arguments> arguments = new ArrayList<Arguments>();
        for (JsonElement t : sendBulkTestCases) {
            JsonObject test = t.getAsJsonObject();

            String testName = test.get("name").getAsString();

            JsonObject input = test.getAsJsonObject("input");
            JsonObject output = test.getAsJsonObject("output");

            JsonElement appIdElement = input.get("appId");
            String appId = appIdElement!=null?appIdElement.getAsString():null;

            JSON jsonUtil = new JSON();
            SendEventBulkRequest event = jsonUtil.deserialize(input.get("event").toString(),SendEventBulkRequest.class);
            Output out = jsonUtil.deserialize(output.toString(),Output.class);

            String idempotencyKey = UUID.randomUUID().toString();

            arguments.add(Arguments.of(testName,appId,event,idempotencyKey,out));
        }
        return arguments.stream();
    }

    private static Stream<Arguments> sendTestCasesProvider(){
        List<Arguments> arguments = new ArrayList<Arguments>();
        for (JsonElement t : sendTestCases) {
            JsonObject test = t.getAsJsonObject();

            String testName = test.get("name").getAsString();

            JsonObject input = test.getAsJsonObject("input");
            JsonObject output = test.getAsJsonObject("output");

            JsonElement appIdElement = input.get("appId");
            String appId = appIdElement!=null?appIdElement.getAsString():null;

            JSON jsonUtil = new JSON();

            SendEventRequest event = jsonUtil.deserialize(input.getAsJsonObject("event").toString(),SendEventRequest.class);
            Output out = jsonUtil.deserialize(output.toString(),Output.class);

            String idempotencyKey = UUID.randomUUID().toString();

            arguments.add(Arguments.of(testName,appId,event,idempotencyKey,out));
        }

        return arguments.stream();
    }

    private static class Output{
        int code = 0;
        String message = null;
        SendEventResponse data = null;
    }

}
