package com.kafka.util;

import java.util.List;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kafka.dto.Message;

public class CustomJsonSerializer implements Serializer<List<Message>> {

	private boolean isKey;

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		this.isKey = isKey;

	}

	@Override
	public byte[] serialize(String topic, List<Message> message) {

		if (message == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			String arrayToJson = mapper.writeValueAsString(message);
			return arrayToJson.getBytes();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
