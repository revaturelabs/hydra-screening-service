package com.revature.hydra.screening.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.hydra.screening.service.ScreeningCompositionService;

/**
 * Configuration class for required beans
 */
@Configuration
public class RepositoryProducerConfiguration {

	/**
	 * For injecting AmqpTemplate
	 * 
	 * @param factory Connection Factory
	 * @return AmqpTemplate
	 */
	@Bean
	public AmqpTemplate rabbitTemplate(ConnectionFactory factory) {
		return new RabbitTemplate(factory);
	}

	/**
	 * For injecting ScreeningCompositionService
	 * 
	 * @return ScreeningCompositionService
	 */
	@Bean
	public ScreeningCompositionService screeningCompositionService() {
		return new ScreeningCompositionService();
	}

}
