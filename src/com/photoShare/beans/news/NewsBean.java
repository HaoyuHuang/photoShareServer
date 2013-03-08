/**
 * 
 */
package com.photoShare.beans.news;

import java.util.ArrayList;

import com.photoShare.beans.photos.PhotoBean;

/**
 * @author czj_yy
 * 
 */
public class NewsBean {

	public static final String KEY_NEWS = "news";
	public static final String KEY_EVENT_TIME = "time";
	public static final String KEY_EVENT_TYPE = "type";
	public static final String KEY_EVENT_DESC = "desc";
	private int userId;
	private String userName;
	private ArrayList<PhotoBean> photos = new ArrayList<PhotoBean>();
	private String eventDesc;
	private String eventTime;
	private EventType eventType;

	public NewsBean(NewsBeanBuilder newsBeanBuilder) {
		this.userId = newsBeanBuilder.userId;
		this.userName = newsBeanBuilder.userName;
		this.photos = newsBeanBuilder.photos;
		this.eventTime = newsBeanBuilder.eventTime;
		this.eventDesc = newsBeanBuilder.eventDesc;
		this.eventType = newsBeanBuilder.eventType;
		this.photos = newsBeanBuilder.photos;
	}

	public static class NewsBeanBuilder {
		private int userId;
		private String userName;
		private ArrayList<PhotoBean> photos = new ArrayList<PhotoBean>();
		private String eventDesc;
		private String eventTime;
		private EventType eventType;

		public NewsBeanBuilder UserId(int uid) {
			this.userId = uid;
			return this;
		}

		public NewsBeanBuilder UserName(String userName) {
			this.userName = userName;
			return this;
		}

		public NewsBeanBuilder Photos(ArrayList<PhotoBean> photos) {
			this.photos = photos;
			return this;
		}

		public NewsBeanBuilder EventTime(String time) {
			this.eventTime = time;
			return this;
		}

		public NewsBeanBuilder EventDesc(String eventDesc) {
			this.eventDesc = eventDesc;
			return this;
		}

		public NewsBeanBuilder EventType(EventType type) {
			this.eventType = type;
			return this;
		}

		public NewsBean build() {
			return new NewsBean(this);
		}

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public ArrayList<PhotoBean> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<PhotoBean> photos) {
		this.photos = photos;
	}

}
