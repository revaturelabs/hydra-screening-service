package com.revature.hydra.test.util;

import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.cloud.netflix.eureka.CloudEurekaInstanceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.EurekaClient;

@Configuration
public class TestContext {
 
	/*@Bean
	public QuestionCompositionService questionCompositionService() {
		return Mockito.mock(QuestionCompositionService.class);
	}*/
	
	/*@Bean
	public SimpleQuestionRepository simpleQuestionRepository() {
		return Mockito.mock(SimpleQuestionRepository.class);
	}*/
	
	@Bean
	public AmqpTemplate amqpTemplate() {
		return Mockito.mock(AmqpTemplate.class);
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
		return Mockito.mock(ConnectionFactory.class);
	}
	
	@Bean 
	public CloudEurekaInstanceConfig CloudEurekaInstanceConfig() {
		return Mockito.mock(CloudEurekaInstanceConfig.class);
	}
	
	@Bean
	public ApplicationInfoManager applicationInfoManager() {
		return Mockito.mock(ApplicationInfoManager.class);
	}
	
	@Bean
	public EurekaClient eurekaClient() {
		return Mockito.mock(EurekaClient.class);
	}
    
}
