package br.com.atividades.hubCollege.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()

                .info(
                        new Info()
                                .title("REST Api`s RESTful with Java and Spring Boot")
                                .version("v1")
                                .description("REST Api`s RESTful with Java and Spring Boot")

                );
    }

}
