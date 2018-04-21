package com.kafka.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.kafka.dto.Message;
import com.kafka.producer.Sender;
import com.kafka.util.CustomJsonSerializer;

@Configuration
public class SenderConfig {

	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomJsonSerializer.class);

	    return props;
	}

	@Bean
	public ProducerFactory<String,  List<Message>> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public KafkaTemplate<String, List<Message>> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public Sender sender() {
		return new Sender();
	}
}