package com.bnpparibas.ism.projectmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
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
