package com.higordev.api_rest.service.validacoes;

import com.higordev.api_rest.dto.TransacaoRequest;

public interface Validacao {

    void validar(TransacaoRequest request);
}
