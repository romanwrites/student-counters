package org.example.counters.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountersServerTest {

    private final CountersServer countersServer = new CountersServer();

    @Test
    public void helloWorldTest() throws Exception {
        countersServer.startServer();
        URL url = new URL("http://localhost:8080/api/hello");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Connection", "keep-alive");

        int expectedCode = 200;
        int responseCode = connection.getResponseCode();
        String expectedMessage = "Hello, world!";
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseMessage = br.readLine();

        assertEquals(expectedCode, responseCode);
        assertEquals(expectedMessage, responseMessage);
    }
}
