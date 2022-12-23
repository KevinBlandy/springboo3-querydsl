package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "example.repository" })
@EntityScan(basePackages = { "example.entity" })
public class ExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class);
	}
}
