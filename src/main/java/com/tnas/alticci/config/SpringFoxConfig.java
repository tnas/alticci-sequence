package com.tnas.alticci.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	
	@Bean
	public Docket api(TypeResolver typeResolver) {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tnas.alticci.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Alticci Sequence API")
                .description("API Documentation for Alticci Sequence")
                .version("1.0.0")
                .build();
    }
}
