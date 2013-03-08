package com.photoShare.beans;

import com.photoShare.server.RequestParam;

public class Friend extends RequestParam {
	private String friendName;

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

}
