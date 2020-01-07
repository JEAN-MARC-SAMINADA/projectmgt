package com.bnpparibas.ism.projectmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProjectmgtApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProjectmgtApplication.class, args);
	}
	@Override
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/**")
				.allowedMethods("GET","PUT","POST","DELETE");
	}
}
