package com.higordev.api_rest.controller;

import com.higordev.api_rest.dto.TransacaoRequest;
import com.higordev.api_rest.service.TransacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public void salvar(@RequestBody TransacaoRequest request){
        service.salvar(request);
    }
}
