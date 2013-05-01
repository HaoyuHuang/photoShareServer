package com.photoShare.beans.news;

public class News {

	private int eventKeyId;
	private int uid;
	private NewsType newsType;
	private int eventUserId;
	private int eventId;
	private String eventDescription;
	private String userName;
	private String eventUserName;
	private String tinyHeadUrl;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getNewsType() {
		return newsType.getType();
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getEventUserId() {
		return eventUserId;
	}

	public void setEventUserId(int eventUserId) {
		this.eventUserId = eventUserId;
	}

	public String getEventUserName() {
		return eventUserName;
	}

	public void setEventUserName(String eventUserName) {
		this.eventUserName = eventUserName;
	}

	public String getTinyHeadUrl() {
		return tinyHeadUrl;
	}

	public void setTinyHeadUrl(String tinyHeadUrl) {
		this.tinyHeadUrl = tinyHeadUrl;
	}

	public int getEventKeyId() {
		return eventKeyId;
	}

	public void setEventKeyId(int eventKeyId) {
		this.eventKeyId = eventKeyId;
	}

}
