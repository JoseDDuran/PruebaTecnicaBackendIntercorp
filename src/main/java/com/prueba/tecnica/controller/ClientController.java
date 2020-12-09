package com.prueba.tecnica.controller;

import com.prueba.tecnica.model.ClientRequest;
import com.prueba.tecnica.model.ClientKPI;
import com.prueba.tecnica.model.ClientResponse;
import com.prueba.tecnica.service.ClientService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/technical-test/v1")
@RestController
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @ApiOperation(value = "Registra un cliente",
            produces = MediaType.APPLICATION_STREAM_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Se obtuvo la lista de las cuentas correctamente."),
            @ApiResponse(
                    code = 400,
                    message = "El cliente envi&oacute; datos incorrectos."),
            @ApiResponse(
                    code = 401,
                    message = "No est&aacute; autorizado para consumir el API"),
            @ApiResponse(
                    code = 403,
                    message = "No se tiene permisos para consumir el API."),
            @ApiResponse(
                    code = 500,
                    message = "Error al obtener la lista de las cuentas.")})
    @PostMapping(value = "/creacliente",
            produces = {
                    MediaType.APPLICATION_STREAM_JSON_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            })
    public Completable saveClient(@RequestBody ClientRequest clientRequest) {
        return clientService.saveClient(clientRequest);
    }

    @ApiOperation(value = "Lista clientes",
            produces = MediaType.APPLICATION_STREAM_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Se obtuvo la lista de las clientes correctamente."),
            @ApiResponse(
                    code = 400,
                    message = "El usuario envi&oacute; datos incorrectos."),
            @ApiResponse(
                    code = 401,
                    message = "No est&aacute; autorizado para consumir el API"),
            @ApiResponse(
                    code = 403,
                    message = "No se tiene permisos para consumir el API."),
            @ApiResponse(
                    code = 500,
                    message = "Error al obtener la lista de las cuentas.")})
    @GetMapping(value = "/listclientes",
            produces = {
                    MediaType.APPLICATION_STREAM_JSON_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            })
    public Single<List<ClientResponse>> getClientList() {
        return clientService.getClients();
    }


    @ApiOperation(value = "Lista KPI de clientes",
            produces = MediaType.APPLICATION_STREAM_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Se obtuvo la lista KPI de las clientes correctamente."),
            @ApiResponse(
                    code = 400,
                    message = "El usuario envi&oacute; datos incorrectos."),
            @ApiResponse(
                    code = 401,
                    message = "No est&aacute; autorizado para consumir el API"),
            @ApiResponse(
                    code = 403,
                    message = "No se tiene permisos para consumir el API."),
            @ApiResponse(
                    code = 500,
                    message = "Error al obtener la lista de las cuentas.")})
    @GetMapping(value = "/kpideclientes",
            produces = {
                    MediaType.APPLICATION_STREAM_JSON_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            })
    public Observable<ClientKPI> getClientKPI() {
        return clientService.getKpiClients();
    }
}
