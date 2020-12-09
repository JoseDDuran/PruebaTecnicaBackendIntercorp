package com.prueba.tecnica.repository.impl;

import com.prueba.tecnica.config.DatabaseClass;
import com.prueba.tecnica.model.ClientRequest;
import com.prueba.tecnica.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Override
    public ClientRequest saveClient(ClientRequest clientRequest) {
        DatabaseClass.getClients().add(clientRequest);
        return clientRequest;
    }

    @Override
    public List<ClientRequest> getClients() {
        return DatabaseClass.getClients();
    }
}
