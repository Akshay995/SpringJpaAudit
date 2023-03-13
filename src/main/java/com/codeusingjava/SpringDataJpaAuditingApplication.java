package com.codeusingjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

//lombok annotation
@Slf4j
//spring annotation
@SpringBootApplication
public class SpringDataJpaAuditingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaAuditingApplication.class, args);
		log.info("Spring boot and jpa auditing application");
	}
}
