package com.iftm.api.prontuarioplus.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Documentação da API sobre o Sistem EASY-SALES")
                        .version("Version 1 (v1)")
                        .description("Esta documentação apresenta os endpoints!")
                        .termsOfService("http://mytersm.com")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://mylicences.com"))
                );
    }
}

