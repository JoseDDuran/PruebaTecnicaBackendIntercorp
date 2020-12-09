package com.prueba.tecnica.util;

import com.prueba.tecnica.model.ClientRequest;
import com.prueba.tecnica.model.ClientResponse;

import java.time.LocalDate;
import java.util.List;

public class ClientUtils {
    public static double getStandardDeviation(List<ClientRequest> clientRequests) {
        double averageAge = getAverageAge(clientRequests);

        double standardDeviation = (clientRequests.stream()
                .map(ClientRequest::getAge)
                .mapToDouble(age -> Math.pow(age - averageAge, 2))
                .sum()) / clientRequests.size();

        return Math.pow(standardDeviation, 0.5);
    }

    public static double getAverageAge(List<ClientRequest> clientRequests) {
        return (clientRequests.stream()
                .mapToDouble(ClientRequest::getAge).sum()) / clientRequests.size();
    }

    private static LocalDate getProbablyDayOfDeath(LocalDate dateBorn) {
        return dateBorn.plusYears((long) (Math.random() * 100) + 1);
    }

    public static ClientResponse clientFromDatabaseToResponse(ClientRequest clientRequest) {
        return ClientResponse.builder()
                .name(clientRequest.getName())
                .lastName(clientRequest.getLastName())
                .age(clientRequest.getAge())
                .dateBorn(clientRequest.getDateBorn())
                .possibleDateOfDeath(getProbablyDayOfDeath(clientRequest.getDateBorn()))
                .build();
    }
}
