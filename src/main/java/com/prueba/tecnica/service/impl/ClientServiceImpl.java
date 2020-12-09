package com.prueba.tecnica.service.impl;

import com.prueba.tecnica.model.ClientException;
import com.prueba.tecnica.model.ClientRequest;
import com.prueba.tecnica.model.ClientKPI;
import com.prueba.tecnica.model.ClientResponse;
import com.prueba.tecnica.service.ClientService;
import com.prueba.tecnica.util.ClientUtils;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.prueba.tecnica.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Completable saveClient(ClientRequest clientRequest) {
        return Completable
                .fromCallable(() -> clientRepository.saveClient(clientRequest));
    }

    @Override
    public Observable<ClientKPI> getKpiClients() {
        List<ClientRequest> clientRequests = clientRepository.getClients();

        return Observable.just(ClientKPI.builder()
                .averageAge(ClientUtils.getAverageAge(clientRequests))
                .standardDeviation(ClientUtils.getStandardDeviation(clientRequests))
                .build());
    }

    @Override
    public Single<List<ClientResponse>> getClients() {
        return Single.just(clientRepository.getClients()
                        .stream()
                        .map(ClientUtils::clientFromDatabaseToResponse)
                .collect(Collectors.toList()));
    }
}
