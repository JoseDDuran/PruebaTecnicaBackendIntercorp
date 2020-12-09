package com.prueba.tecnica.service;

import com.prueba.tecnica.model.ClientRequest;
import com.prueba.tecnica.model.ClientKPI;
import com.prueba.tecnica.model.ClientResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

public interface ClientService {
    Completable saveClient(ClientRequest clientRequest);
    Observable<ClientKPI> getKpiClients();
    Single<List<ClientResponse>> getClients();
}

