package com.prueba.tecnica.repository;

import com.prueba.tecnica.model.ClientRequest;

import java.util.List;

public interface ClientRepository {
    ClientRequest saveClient(ClientRequest clientRequest);
    List<ClientRequest> getClients();
}
