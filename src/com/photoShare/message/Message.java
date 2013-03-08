package com.photoShare.message;

import java.util.HashMap;
import java.util.Map;

public class Message {

	private Map<String, String> message = new HashMap<String, String>();

	private String key;

	private String value;

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	public void putMessage(String key, String value) {
		message.put(key, value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
