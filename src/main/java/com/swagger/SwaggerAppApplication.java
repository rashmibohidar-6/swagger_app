package com.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(  //Used for header in swagger app
		info = @Info(
				title = "Student Open API",  //Title of my testing on swagger app
				description = "Student Open API Documentation" //Description of that
		),
		servers = @Server(
			url = "http://localhost:8080",   //give details that which port no it will run
			description = "Student API Url"  // description of that url
		)
)
public class SwaggerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerAppApplication.class, args);
	}

}
