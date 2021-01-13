package com.demo.roomclr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootApplication
public class RoomClrApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoomClrApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			LOGGER.info("Starting CLR application");

			// Call API established in room web app
			String url = "http://localhost:8080/api/rooms";
			ResponseEntity<List<Room>> rooms = restTemplate.exchange(
					url,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<Room>>() {}
			);
			rooms.getBody().forEach(room -> {
				LOGGER.info(room.toString());
			});
			LOGGER.info("Finishing CLR application");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(RoomClrApplication.class, args);
	}

}
