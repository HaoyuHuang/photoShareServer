package com.photoShare.beans;

import com.photoShare.server.RequestParam;

public class PhotoInfo extends RequestParam {
	private int pid;

	private int uid;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
