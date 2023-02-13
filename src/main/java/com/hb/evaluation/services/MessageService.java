package com.hb.evaluation.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hb.evaluation.dtos.MessageDTO;
import com.hb.evaluation.dtos.UserDTO;
import com.hb.evaluation.models.Message;
import com.hb.evaluation.repositories.MessageRepository;

@Service
public class MessageService {

	private MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public List<MessageDTO> getMessages() {
		List<Message> messages = messageRepository.getMessages();
		List<MessageDTO> messagesDTOS = new ArrayList<>();

		messages.forEach((message) -> {
			messagesDTOS.add(new MessageDTO(message.getId(), message.getContent(), message.getCategory()));
		});

		return messagesDTOS;
	}

	public void addMessage(MessageDTO messageDTO) {
		Message message = new Message();
		message.setContent(messageDTO.content());
		message.setCategory(messageDTO.category());

		messageRepository.save(message);
	}

	public List<MessageDTO> getMessagesByUserCategories(UserDTO userDTO) {
		List<MessageDTO> allmessages = this.getMessages();
		List<MessageDTO> selectedmessages = new ArrayList<>();

		for (String category : userDTO.categories()) {
			for (MessageDTO filteredMessage : allmessages) {
				if (filteredMessage.category().equals(category)) {
					selectedmessages.add(filteredMessage);
				}
			}
			return selectedmessages;
		}
		return null;
	}

}
