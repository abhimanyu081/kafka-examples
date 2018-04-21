package com.kafka.producer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.dto.Message;

@Service
public class Sender {

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private KafkaTemplate<String, List<Message>> kafkaTemplate;

	public void send(String topic, List<Message> payload) {
		LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
		kafkaTemplate.send(topic, payload);
	}
}