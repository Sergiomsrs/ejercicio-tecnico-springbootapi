package org.ptecnica.pruebatecspringboot.exception;

public record ApiErrorDto(
        String message,
        String backendMessage,
        String method,
        String url) {
}
