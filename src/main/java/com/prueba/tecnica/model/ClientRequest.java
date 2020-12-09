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
public class ClientRequest {
    @NonNull
    private String name;

    @NonNull
    private String lastName;

    @NonNull
    private Integer age;

    @NonNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateBorn;
}
