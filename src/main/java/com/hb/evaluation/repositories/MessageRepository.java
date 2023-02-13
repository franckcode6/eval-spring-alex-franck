package com.hb.evaluation.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hb.evaluation.models.Message;

@Repository
public class MessageRepository {

	public List<Message> getMessages() {
		List<Message> posts = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper();
		try {
			File resourceJson = new ClassPathResource("messages.json").getFile();
			posts = mapper.readValue(resourceJson, new TypeReference<List<Message>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return posts;
	}

	public void save(Message message) {
		List<Message> existingsMessages = getMessages();
		int newId = 0;
		for (Message existingMessage : existingsMessages) {
			if (existingMessage.getId() >= newId) {
				newId = existingMessage.getId() + 1;
			}
		}
		message.setId(newId);
		existingsMessages.add(message);

		ObjectMapper mapper = new ObjectMapper();
		try {
			File resourceJson = new File("src/main/resources/messages.json");
			String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(existingsMessages);

			BufferedWriter writer = new BufferedWriter(new FileWriter(resourceJson));
			writer.write(jsonString);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
