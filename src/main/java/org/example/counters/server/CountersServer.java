package org.example.counters.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import org.example.counters.controller.HelloHandler;

public class CountersServer {

    private static final int DEFAULT_PORT = 8080;
    private static final int DEFAULT_BACKLOG = 0;

    public void startServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(DEFAULT_PORT), DEFAULT_BACKLOG);
            server.createContext("/api/hello", new HelloHandler());
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server started");
    }
}
