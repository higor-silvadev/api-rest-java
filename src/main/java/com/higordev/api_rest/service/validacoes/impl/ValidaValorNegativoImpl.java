package com.higordev.api_rest.service.validacoes.impl;

import com.higordev.api_rest.dto.TransacaoRequest;
import com.higordev.api_rest.exception.ValorNegativoException;
import com.higordev.api_rest.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValidaValorNegativoImpl implements Validacao {

    @Override
    public void validar(TransacaoRequest request){
        boolean isNumeroNegativo = request.valor() < 0;

        if(isNumeroNegativo){
            throw new ValorNegativoException("Não é permitido valor negativo");
        }
    }

}
