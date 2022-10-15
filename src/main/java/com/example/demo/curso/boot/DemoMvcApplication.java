package com.example.demo.curso.boot;

import java.util.Locale;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.i18n.FixedLocaleContextResolver;
import org.springframework.web.server.i18n.LocaleContextResolver;

@SpringBootApplication
public class DemoMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMvcApplication.class, args);
	}
	@Bean
	public LocaleContextResolver loacaleResorver() {
		return  new FixedLocaleContextResolver(new Locale("pt", "BR"));
	}

}
