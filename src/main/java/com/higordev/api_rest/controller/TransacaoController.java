package com.higordev.api_rest.controller;

import com.higordev.api_rest.dto.TransacaoRequest;
import com.higordev.api_rest.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody TransacaoRequest request){
        service.salvar(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletar(){
        service.deletar();
    }
}
