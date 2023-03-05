package org.example.counters;

import org.example.counters.server.CountersServer;

public class CountersApp {

    public static void main(String[] args) {
        CountersServer countersServer = new CountersServer();
        countersServer.startServer();
    }
}
