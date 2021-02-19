package com.api.produto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket produtoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("produto-api-v1")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.api.produto.controller"))
            .paths(regex("/api/produto.*"))
            .build()
            .apiInfo(metaInfoProduto());
    }


    @Bean
    public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("config-api-v1")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.api.produto.controller"))
            .paths(regex("/api/config.*"))
            .build()
            .apiInfo(metaInfoConfig());
    }


    private ApiInfo metaInfoProduto() {

        ApiInfo apiInfo = new ApiInfo(
            "API Produtos",
            "API REST - cadastro de produtos.",
            "1.0.0",
            "Termos de Servico",
            new Contact("Wesley Hinsch", "https://www.linkedin.com/in/wesleyhinsch/",
                "wesleyhinsch@gmail.com"),
            "Built for Kubedev",
            "https://kubedev.io/", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }

    private ApiInfo metaInfoConfig() {

        ApiInfo apiInfo = new ApiInfo(
            "API Config",
            "API REST - api config.",
            "1.0.0",
            "Termos de Servico",
            new Contact("Wesley Hinsch", "https://www.linkedin.com/in/wesleyhinsch/",
                "wesleyhinsch@gmail.com"),
            "Built for Kubedev",
            "https://kubedev.io/", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }

}
