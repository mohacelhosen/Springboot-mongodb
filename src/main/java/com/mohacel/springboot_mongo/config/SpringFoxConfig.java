package com.mohacel.springboot_mongo.config;
//https://springdoc.org/migrating-from-springfox.html

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringFoxConfig {

//    @Bean
//    public Docket api(){
//        return  new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo(){
//        return  new ApiInfo("USER REST API","API Documentation for USER","1.0","currently no terms of service url",
//                new Contact("My Coding Universe","currently no url","mohacel.hosen22@gmail.com"),
//                "currently no licence ",
//                "no licence url",
//                Collections.EMPTY_LIST);
//    }

    @Bean
    public OpenAPI springUserDoc(){
        return new OpenAPI()
                .info(new Info().title("USER REST API Documentation")
                        .description("Spring user sample application")
                        .version("1.0")
                        .contact(new Contact().name("My Coding Universe").email("mohacel.hosen22@gmail.com").url("currently no url"))
                        .license(new License().name("mcu2.0").url("mcu.com"))
                ).externalDocs(new ExternalDocumentation()
                        .description("SpringUser external google Documentation")
                        .url("https://docs.google.com/mcu/docs"));
    }

}
