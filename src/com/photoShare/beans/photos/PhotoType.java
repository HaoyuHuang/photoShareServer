package com.photoShare.beans.photos;

public enum PhotoType {

	TINY(120, 120), MIDDLE(240, 240), LARGE(720, 720);

	PhotoType(int width, int height) {
		this.width = width;
		this.height = height;
	}

	private int width;

	private int height;

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
