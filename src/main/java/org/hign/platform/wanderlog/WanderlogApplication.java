package org.hign.platform.wanderlog;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WanderlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WanderlogApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Wanderlog API")
                        .version("1.0")
                        .description("Wanderlog API"));
    }

}
