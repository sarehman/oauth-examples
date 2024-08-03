package com.tmcmum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.tmcmum.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.tmcmum"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class TmcApp {

	public static void main(String[] args) {
		SpringApplication.run(TmcApp.class, args);
	}
}
