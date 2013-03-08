package com.photoShare.message;

import java.util.HashMap;
import java.util.Map;

public class MessagePool {

	private static MessagePool messagePool = new MessagePool();

	public static MessagePool getInstance() {
		return messagePool;
	}

	private Map<String, Message> messages = new HashMap<String, Message>();

	public void putKey(String key, Message message) {
		messages.put(key, message);
	}

	public Message get(String key) {
		return messages.get(key);
	}

	public Map<String, Message> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, Message> messages) {
		this.messages = messages;
	}

}
