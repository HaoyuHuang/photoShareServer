package com.photoShare.beans.news;

public enum NewsType {

	NULL(0), COMMENT(1), PHOTO(2), FOLLOW(3), LIKE(4);

	private int type;

	private NewsType(int type) {
		this.type = type;
	}

	public static NewsType SWITCH(int type) {
		switch (type) {
		case 1:
			return COMMENT;
		case 2:
			return PHOTO;
		case 3:
			return FOLLOW;
		case 4:
			return LIKE;
		default:
			return NULL;
		}
	}

	public int getType() {
		return type;
	}

}
