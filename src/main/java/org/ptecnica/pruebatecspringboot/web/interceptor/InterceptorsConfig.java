package org.ptecnica.pruebatecspringboot.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class InterceptorsConfig implements WebMvcConfigurer {

        @Autowired
        private UserInteractionInterceptor userInteractionInterceptor;

        /**
         * Agrega el interceptor de interacción de usuario a la lista de interceptores.
         *
         * @param registry El registro de interceptores.
         */
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(userInteractionInterceptor);
        }
    }

