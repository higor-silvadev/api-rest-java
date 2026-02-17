package com.higordev.api_rest.service.validacoes.impl;

import com.higordev.api_rest.dto.TransacaoRequest;
import com.higordev.api_rest.exception.DataHoraPosteriorException;
import com.higordev.api_rest.service.validacoes.Validacao;
import jdk.jfr.Frequency;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ValidaDataHoraPosteriorImpl implements Validacao {

    @Override
    public void validar(TransacaoRequest request) {
        boolean isPosterior = request.dataHora().isAfter(OffsetDateTime.now());

        if(isPosterior){
            throw new DataHoraPosteriorException("O valor do campo data e hora está no futuro!");
        }
    }
}
