package com.example.oauth_2._no.springsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean ()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new Jwtfilter());
		//przejęcie requestów z poniższego url
		filterRegistrationBean.setUrlPatterns(Collections.singleton("/homepage"));
		return filterRegistrationBean;
	}
}
