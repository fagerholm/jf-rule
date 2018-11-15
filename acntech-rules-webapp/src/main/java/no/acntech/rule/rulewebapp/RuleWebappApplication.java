package no.acntech.rule.rulewebapp;

import java.io.IOException;
import java.io.InputStream;

import no.acntech.rule.core.dto.configuration.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class RuleWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuleWebappApplication.class, args);
	}


	@Bean
	public Configuration configuration(@Value("classpath:regeldokumentasjon.json") Resource resource) {
		if (resource.exists()) {
			try (InputStream inputStream = resource.getInputStream()) {
				ObjectMapper objectMapper = new ObjectMapper();
				return objectMapper.readValue(inputStream, Configuration.class);
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		} else {
			return null;
		}
	}
}
