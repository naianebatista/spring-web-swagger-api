package br.com.webApi.doc;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

import static org.springframework.web.servlet.mvc.method.RequestMappingInfo.paths;

@Configuration //config p spring e ele vai habilitar a document p swgger
@EnableSwagger2
@Component
public class SwaggerConfig {
       private Contact contact(){
           return new Contact("Meu nome","ww.ciandt.com","nbatista@cindt.com");
       }
        private ApiInfoBuilder informacoesApi(){
            ApiInfoBuilder apiInfoBuilder= new ApiInfoBuilder();

            apiInfoBuilder.title("Title - Rest API");
            apiInfoBuilder.description("API exemplo de us de springboot REST API");
            apiInfoBuilder.version("1.0");
            apiInfoBuilder.termsOfServiceUrl("Termo de usos: Open Source");
            apiInfoBuilder.license("Licença- Ci&T");
            apiInfoBuilder.licenseUrl("www.ciandt.com");
            apiInfoBuilder.contact(this.contact());
            return apiInfoBuilder;
        }
        @Bean
        public Docket detalheApi(){
           Docket docket=new Docket(DocumentationType.SWAGGER_2);

           docket
                   .select()
                   .apis(RequestHandlerSelectors.basePackage("br.com.webApi.controller"))//encontar controller e montar a pagina de doc
                   .paths(PathSelectors.any())
                    .build()
                    .apiInfo(this.informacoesApi().build())
                    .consumes(new HashSet<String>(Arrays.asList("application/json")))
                    .produces(new HashSet<String>(Arrays.asList("application/json")));
                   return docket;
        }


}
