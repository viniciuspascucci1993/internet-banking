package com.vinicius.internetbanking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${vinicius.internetbanking.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("vinicius.pascucci1@gmail.com");
        contact.setName("Vinicius Pascucci");
        contact.setUrl("https://github.com/viniciuspascucci1993");

        License mitLicense = new License().name("License").url("");

        Info info = new Info()
                .title("Internet Banking API")
                .version("1.0")
                .contact(contact)
                .description("Essa API tem como objetivo mostrar ao usuario operações de internet banking.").termsOfService("")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
