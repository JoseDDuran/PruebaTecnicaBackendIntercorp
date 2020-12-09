package com.prueba.tecnica.model;

import lombok.Builder;

@Builder
public class ClientException extends Exception{
    private String error;
    private String detail;
}
