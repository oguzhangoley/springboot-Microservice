package net.oguz.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@OpenAPIDefinition(
        info = @Info(
                title = "Department Service REST APIs",
                description = "Department Service REST APIs Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Oguzhan",
                        email = "oguzhanngoley@gmail.com",
                        url = "https://github.com/oguzhangoley"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "someUrl"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Department-Service Doc",
                url="someUrl"
        )
)
@SpringBootApplication
public class DepartmentServiceApplication {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    //java -jar target/department-service-0.0.1-SNAPSHOT.jar --server.port=8092
}
