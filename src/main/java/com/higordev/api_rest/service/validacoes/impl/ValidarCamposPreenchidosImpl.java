package com.higordev.api_rest.service.validacoes.impl;

import com.higordev.api_rest.dto.TransacaoRequest;
import com.higordev.api_rest.exception.FormularioInvalidadoException;
import com.higordev.api_rest.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValidarCamposPreenchidosImpl implements Validacao {

    @Override
    public void validar(TransacaoRequest request){
        if(request.valor() == null || request.dataHora() == null) {
            throw new FormularioInvalidadoException("Campo valor ou dataHora não foram preenchidos!");
        }
    }
}
