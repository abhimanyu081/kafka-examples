package com.kafka.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kafka.dto.Message;

public class CustomJsonDeserailizer implements Deserializer<List<Message>>{

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Message> deserialize(String arg0, byte[] byteArr) {

		if (byteArr == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			List<Message> msgObject = mapper.readValue(byteArr, new TypeReference<List<Message>>() { });
			return msgObject;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
