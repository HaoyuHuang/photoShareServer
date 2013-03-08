package com.photoShare.beans;

import com.photoShare.server.RequestParam;

public class LikeInfo extends RequestParam {
	private int uid;

	private int pid;

	private int lid;

	private String uname;

	private String tinyHead;

	private String createTime;

	private boolean isLike;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTinyHead() {
		return tinyHead;
	}

	public void setTinyHead(String tinyHead) {
		this.tinyHead = tinyHead;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
