package com.prueba.tecnica.config;

import com.prueba.tecnica.model.ClientRequest;

import java.util.ArrayList;
import java.util.List;


public class DatabaseClass {
    private static List<ClientRequest> clientRequests = new ArrayList<>();

    public static List<ClientRequest> getClients() {
        return clientRequests;
    }
}
