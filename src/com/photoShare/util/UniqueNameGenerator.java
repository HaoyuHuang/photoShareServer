package com.photoShare.util;

import java.util.UUID;

public class UniqueNameGenerator {

	public static String retrieveUniqueName() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println(retrieveUniqueName());
	}
}
