package org.ptecnica.pruebatecspringboot.web.controller;

import jakarta.validation.Valid;
import org.ptecnica.pruebatecspringboot.dto.security.LoginRequest;
import org.ptecnica.pruebatecspringboot.dto.security.LoginResponse;
import org.ptecnica.pruebatecspringboot.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authentication")

public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PreAuthorize("permitAll")
    @PostMapping("authenticate")
    public ResponseEntity<LoginResponse> authenticate(
        @RequestBody @Valid LoginRequest loginRequest
    ){
        return ResponseEntity.ok(authenticationService.authenticate(loginRequest));
    }

    @PreAuthorize("permitAll")
    @PostMapping("/logout")
    public void logout() throws Exception {
        authenticationService.logout();
    }
}
