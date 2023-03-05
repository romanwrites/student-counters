package org.example.counters.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HelloHandler  implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "Hello, world!";
        exchange.sendResponseHeaders(200, message.getBytes(StandardCharsets.UTF_8).length);
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(message.getBytes(StandardCharsets.UTF_8));
        responseBody.close();
    }
}
