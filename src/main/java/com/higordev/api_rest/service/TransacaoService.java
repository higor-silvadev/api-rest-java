package com.higordev.api_rest.service;

import com.higordev.api_rest.domain.Transacao;
import com.higordev.api_rest.dto.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    public void salvar(TransacaoRequest request){

        transacoes.add(new Transacao(request.valor(), request.dataHora()));
    }
}
