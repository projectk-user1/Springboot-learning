package com.maheshb.springbootkafkaintro.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maheshb.springbootkafkaintro.TagService;
import com.maheshb.springbootkafkaintro.dto.TagDTO;
import com.maheshb.springbootkafkaintro.entities.TagEntity;

@Component
public class MessageListener {
	
	@Autowired
	TagService tagservice;
	
	@Autowired
	ObjectMapper objectMapper;

	@KafkaListener(topics = "${message.topic.name}", groupId = "foo", containerFactory = "fooKafkaListenerContainerFactory")
	public void listenGroupFoo(String message) {
//		System.out.println("Received Message in group 'foo': " + message);
//		System.out.println(message);
		try {
			TagDTO tagDTO = objectMapper.readValue(message, TagDTO.class);
			TagEntity tagEntity= new TagEntity(tagDTO.getTimestamp(),tagDTO.getValue(),tagDTO.getTagName());
			tagservice.save(tagEntity);
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}
//		System.out.println(tagEntity);
	}

	/*@KafkaListener(topics = "${message.topic.name}", groupId = "bar", containerFactory = "barKafkaListenerContainerFactory")
	public void listenGroupBar(String message) {
		System.out.println("Received Message in group 'bar': " + message);
	}

	@KafkaListener(topics = "${message.topic.name}", groupId = "bar1", containerFactory = "bar1KafkaListenerContainerFactory")
	public void listenGroupBar1(String message) {
		System.out.println("Received Message in group 'bar1': " + message);
	}*/
}