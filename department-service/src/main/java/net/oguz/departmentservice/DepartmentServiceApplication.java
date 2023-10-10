package net.oguz.departmentservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
