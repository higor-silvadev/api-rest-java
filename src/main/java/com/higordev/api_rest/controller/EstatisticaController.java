package com.higordev.api_rest.controller;

import com.higordev.api_rest.dto.EstatisticaResponse;
import com.higordev.api_rest.service.EstatisticaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/estatistica")
@RestController
public class EstatisticaController {

    private final EstatisticaService service;

    public EstatisticaController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EstatisticaResponse obterMetricas(){
        return service.obterMetricas();
    }
}
