package org.hign.platform.wanderlog;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class WanderlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WanderlogApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        /*return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Wanderlog API")
                        .version("1.0")
                        .description("Wanderlog API"));*/

        var openApi = new OpenAPI();
        openApi.info(new Info()
                        .title("Wanderlog API")
                        .description("Wanderlog API")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("ACME Learning Platform wiki Documentation")
                        .url("https://acme-learning-platform.wiki.github.io/docs"));
        // Add security scheme

        final String securitySchemeName = "bearerAuth";

        openApi.addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));

        return openApi;
    }

}
