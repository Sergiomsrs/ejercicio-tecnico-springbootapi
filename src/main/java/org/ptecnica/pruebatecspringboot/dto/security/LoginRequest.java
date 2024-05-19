package org.ptecnica.pruebatecspringboot.dto.security;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank String username,

        @NotBlank String password

) {
}
