package com.higordev.api_rest.service;

import com.higordev.api_rest.domain.Transacao;
import com.higordev.api_rest.dto.TransacaoRequest;
import com.higordev.api_rest.service.validacoes.Validacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    private final List<Validacao> validacoes;

    public TransacaoService(List<Validacao> validacoes) {
        this.validacoes = validacoes;
    }

    public void salvar(TransacaoRequest request) {
        validacoes.forEach(v -> v.validar(request));
        transacoes.add(new Transacao(request.valor(), request.dataHora()));
    }
}
