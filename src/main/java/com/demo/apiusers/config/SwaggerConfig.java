package com.demo.apiusers.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(Arrays.asList(
                        new Server().url("http://localhost:8080").description("API Users Dev Server"),
                        new Server().url("https://api-users-dev.abexa.pe").description("API Users Deployed Server Abx"),
                        new Server().url("https://api-users-dev.onrender.com").description("API Users Deployed Server Render"),
                        new Server().url("https://ygp43pphan.us-east-2.awsapprunner.com").description("API Users Deployed Server AWS")
                ));
    }
}
