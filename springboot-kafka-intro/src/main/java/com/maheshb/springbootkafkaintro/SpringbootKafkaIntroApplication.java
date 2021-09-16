package com.maheshb.springbootkafkaintro;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maheshb.springbootkafkaintro.component.MessageListener;
import com.maheshb.springbootkafkaintro.component.MessageProducer;
import com.maheshb.springbootkafkaintro.dto.TagDTO;

@EnableJpaAuditing
@SpringBootApplication
public class SpringbootKafkaIntroApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootKafkaIntroApplication.class, args);

		MessageProducer producer = context.getBean(MessageProducer.class);
		MessageListener listener = context.getBean(MessageListener.class);
		ObjectMapper objectMapper = new ObjectMapper();

		/*
		 * for (int i = 0; i < 5; i++) { producer.sendMessage("Hello, World! " + i);
		 * 
		 * }
		 */
		for (int i = 0; i < 100000; i++) {
			producer.sendMessage(objectMapper.writeValueAsString(
					new TagDTO(new Date().getTime(), Double.valueOf(i), "Tag 1")));
		}
		
	}

}
