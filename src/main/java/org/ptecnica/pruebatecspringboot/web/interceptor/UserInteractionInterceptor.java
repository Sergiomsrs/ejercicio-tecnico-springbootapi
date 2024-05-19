package org.ptecnica.pruebatecspringboot.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ptecnica.pruebatecspringboot.exception.ApiErrorException;
import org.ptecnica.pruebatecspringboot.persistence.entity.UserInteractionLog;
import org.ptecnica.pruebatecspringboot.persistence.repository.UserInteractionRepository;
import org.ptecnica.pruebatecspringboot.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
public class UserInteractionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserInteractionRepository userLogRepository;

    @Autowired
    @Lazy
    private AuthenticationService authenticationService;

    /**
     * Intercepta las solicitudes antes de ser manejadas por el controlador.
     *
     * @param request  La solicitud HTTP entrante.
     * @param response La respuesta HTTP.
     * @param handler  El controlador o método del controlador que manejará la solicitud.
     * @return true si la solicitud debe continuar siendo procesada; de lo contrario, false.
     * @throws Exception Si ocurre un error durante el procesamiento de la solicitud.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Inteceptor: " + this.getClass().getName());

        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/characters")) {
            UserInteractionLog userLog = new UserInteractionLog();
            userLog.setHttpMethod(request.getMethod());
            userLog.setUrl(request.getRequestURL().toString());

            UserDetails user = authenticationService.getUserLoggedIn();
            userLog.setUsername(user.getUsername());
            userLog.setRemoteAddress(request.getRemoteAddr());
            userLog.setTimestamp(LocalDateTime.now());

            try {
                userLogRepository.save(userLog);
                return true;
            } catch (Exception exception) {
                throw new ApiErrorException("No se logró guardar el registro de interacción correctamente");
            }
        }

        return true;
    }
}