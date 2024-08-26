package com.demo.apiusers.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(Arrays.asList(
                        new Server().url("http://localhost:8080").description("API Users Dev Server"),
                        new Server().url("https://api-users-dev.abexa.pe").description("API Users Deployed Server"),
                        new Server().url("https://api-users-dev.onrender.com").description("API Users Deployed Server Render")
                ));
    }
}
