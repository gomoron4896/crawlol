package com.oxy.soup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:conf/ex.properties")
public class MysoupApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysoupApplication.class, args);
	}
}
