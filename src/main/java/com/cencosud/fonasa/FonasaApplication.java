package com.cencosud.fonasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "com.cencosud" }, exclude = { HibernateJpaAutoConfiguration.class })
public class FonasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FonasaApplication.class, args);
	}

}
