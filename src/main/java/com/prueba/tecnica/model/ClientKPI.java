package com.prueba.tecnica.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientKPI {
    private double averageAge;
    private double standardDeviation;
}
