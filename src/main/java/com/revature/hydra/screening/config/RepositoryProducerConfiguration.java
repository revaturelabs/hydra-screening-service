package com.revature.hydra.screening.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.hydra.screening.service.ScreeningCompositionService;

@Configuration
public class RepositoryProducerConfiguration {

	@Bean
	public AmqpTemplate rabbitTemplate(ConnectionFactory factory) {
		return new RabbitTemplate(factory);
	}

	@Bean
	public ScreeningCompositionService screeningCompositionService() {
		return new ScreeningCompositionService();
	}

}
