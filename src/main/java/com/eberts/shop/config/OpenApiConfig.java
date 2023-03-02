package com.eberts.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("API")
				.version("V1")
				.description("Descrição")
				.termsOfService("Termos de uso")
				.license(new License()
						.name("Apache 2.0")
						.url("https://www.apache.org/licenses/LICENSE-2.0"))
				);
	}
}

