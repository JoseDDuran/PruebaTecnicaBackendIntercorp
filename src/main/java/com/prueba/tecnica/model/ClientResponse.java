package com.prueba.tecnica.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ClientResponse {
    private String name;
    private String lastName;
    private Integer age;
    private LocalDate dateBorn;
    private LocalDate possibleDateOfDeath;
}
