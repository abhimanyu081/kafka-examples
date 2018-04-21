package com.kafka.cron;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kafka.constants.KafkaTopics;
import com.kafka.dto.Message;
import com.kafka.producer.Sender;
import com.kafka.service.MessageService;

@Component
@EnableScheduling
public class MessageProducerCron {
	
	private Logger LOG = LoggerFactory.getLogger("MessageProducerCron");
	
	@Autowired
	MessageService messageService;

	
	@Autowired
	Sender sender;
	
	@Scheduled(cron="*/10 * * * * *")
	public void producerCron() {
		List<Message> msgsList = messageService.createAndReturnMessage();
		
		LOG.info("send Msgs with list = {}",msgsList.size());
		
		sender.send(KafkaTopics.TOPIC_NAME_MESSAGE, msgsList);
	}
	
}
