package one.digitalinnovation.personapi.config;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // CONFIGURAÇÂO NOVA DO SWAGGER
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "one.digitalinnovation.personapi";
	public static final String VERSION = "1.0.0";
 
	ApiInfo apiInfo() {
		return new ApiInfoBuilder()
            .title("API Rest - PEOPLE")
            .description("API Rest para cadastro de pessoas")
			.license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
			.termsOfServiceUrl("")
            .version(VERSION)
            .contact(new Contact("LivSun Devs",
                                "https://github.com/DenilsonMarcio",
                                "denilson.santos7@fatec.sp.gov.br"))
            .build();
	}
 
	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE)).build()
				.enable(true)
				.directModelSubstitute(LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(Date.class, java.util.Date.class).apiInfo(apiInfo());
	}
    
}
