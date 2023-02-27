package com.wooz.compare.item.adapter.in.web;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("API")
                .version("1.0.0")
                .description("일단은 API 한 개로 퉁");

        return new OpenAPI()
                .info(info);
    }
}