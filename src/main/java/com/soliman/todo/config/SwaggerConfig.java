package com.soliman.todo.config;

import com.soliman.todo.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// we add the swagger2 dependencies(2 dependencies) in the pom.xml
@Configuration  // to make the class configuration
@EnableSwagger2  // to use the swagger
public class SwaggerConfig {
    // we create a bean in order to use it in our app
    @Bean
    public Docket api() {
        // we need to retun a Docket (dosar ,جدول) that will have all the details we need like below
        return new Docket(DocumentationType.SWAGGER_2)
                // the api information
                .apiInfo(
                        new ApiInfoBuilder().description("")  // you can add any description
                                .version("1.0")
                                .description("Api Documentation")
                                .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("src/main/java")) // swagger will scan every thing under this package
                .paths(PathSelectors.ant(Constants.APP_ROOT + "/**"))
                .build();
    }
}
