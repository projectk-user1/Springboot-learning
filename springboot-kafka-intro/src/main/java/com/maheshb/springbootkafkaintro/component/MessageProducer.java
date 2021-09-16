package com.maheshb.springbootkafkaintro.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class MessageProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value(value = "${message.topic.name}")
	private String topicName;

	public void sendMessage(String message) {

		kafkaTemplate.send(topicName, message);
		
//		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
//
//		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//
//			@Override
//			public void onSuccess(SendResult<String, String> result) {
//				System.out.println(
//						"Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
//			}
//
//			@Override
//			public void onFailure(Throwable ex) {
//				System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
//			}
//		});
	}

}