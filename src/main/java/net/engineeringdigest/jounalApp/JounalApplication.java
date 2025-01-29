package net.engineeringdigest.jounalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class JounalApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JounalApplication.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		System.out.println(env.getActiveProfiles()[0]);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
