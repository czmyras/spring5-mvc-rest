package guru.springfamework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Paths;
import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());

    }


    private ApiInfo metaData() {

        Contact contact = new Contact("Tomasz Czmyr", "https://www.czmyras.pl", "czmyras@gmail.com");

        return new ApiInfo(
                "Sample Api Info",
                "Sample description",
                "1.0",
                "Terms of services: bla bla",
                contact,
                "Apache license 2.0",
                "https://apache.org/licenses/license-2.0",
                new ArrayList<>()
        );



    }
}
