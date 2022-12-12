package com.registro.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RegistroUsuariosSpringSecurityApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
	}

}
