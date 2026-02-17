package com.higordev.api_rest.exception;

public class ValorNegativoException extends RuntimeException {
    public ValorNegativoException(String message) {
        super(message);
    }
}
