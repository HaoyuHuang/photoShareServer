package com.photoShare.beans.photos;

import java.io.File;

public class PhotoBean {

	public PhotoBean(PhotoBeanBuidler photoBeanBuidler) {
		this.largeurl = photoBeanBuidler.largeurl;
		this.url = photoBeanBuidler.url;
		this.pid = photoBeanBuidler.pid;
		this.tinyurl = photoBeanBuidler.tinyurl;
		this.uid = photoBeanBuidler.uid;
		this.uname = photoBeanBuidler.userName;
		this.caption = photoBeanBuidler.caption;
		this.createTime = photoBeanBuidler.createTime;
		this.commentCount = photoBeanBuidler.commentCount;
		this.likesCount = photoBeanBuidler.likesCnt;
		this.file = photoBeanBuidler.file;
		this.tinyUrl = photoBeanBuidler.tinyUrl;
		this.isLike = photoBeanBuidler.isLike;
	}

	private int uid;

	private String uname;

	private String caption;

	private File file;

	private String createTime;

	private int commentCount;

	private int likesCount;

	private int pid;

	private String tinyUrl;

	private boolean isLike;

	private String tinyurl;

	private String url;

	private String largeurl;

	public static class PhotoBeanBuidler {
		private int uid;

		private String userName;

		private String caption;

		private File file;

		private String createTime;

		private int commentCount;

		private int likesCnt;

		private int pid;

		private String tinyUrl;

		private String tinyurl;

		private String url;

		private boolean isLike;

		private String largeurl;

		public PhotoBeanBuidler Uid(int uid) {
			this.uid = uid;
			return this;
		}

		public PhotoBeanBuidler File(File file) {
			this.file = file;
			return this;
		}

		public PhotoBeanBuidler isLike(boolean isLike) {
			this.isLike = isLike;
			return this;
		}

		public PhotoBeanBuidler UserName(String userName) {
			this.userName = userName;
			return this;
		}

		public PhotoBeanBuidler TinyHeadUrl(String tinyUrl) {
			this.tinyUrl = tinyUrl;
			return this;
		}

		public PhotoBeanBuidler Pid(int pid) {
			this.pid = pid;
			return this;
		}

		public PhotoBeanBuidler TinyUrl(String tinyUrl) {
			this.tinyurl = tinyUrl;
			return this;
		}

		public PhotoBeanBuidler MiddleUrl(String middleUrl) {
			this.url = middleUrl;
			return this;
		}

		public PhotoBeanBuidler LargeUrl(String largeUrl) {
			this.largeurl = largeUrl;
			return this;
		}

		public PhotoBeanBuidler Caption(String caption) {
			this.caption = caption;
			return this;
		}

		public PhotoBeanBuidler CommentCnt(int commentCnt) {
			this.commentCount = commentCnt;
			return this;
		}

		public PhotoBeanBuidler LikesCnt(int likesCnt) {
			this.likesCnt = likesCnt;
			return this;
		}

		public PhotoBeanBuidler CreateTime(String createTime) {
			this.createTime = createTime;
			return this;
		}

		public PhotoBean build() {
			return new PhotoBean(this);
		}

	}

	public int getUid() {
		return uid;
	}

	public String getUname() {
		return uname;
	}

	public String getCaption() {
		return caption;
	}

	public File getFile() {
		return file;
	}

	public String getCreateTime() {
		return createTime;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public int getPid() {
		return pid;
	}

	public String getTinyUrl() {
		return tinyUrl;
	}

	public boolean isLike() {
		return isLike;
	}

	public String getTinyurl() {
		return tinyurl;
	}

	public String getUrl() {
		return url;
	}

	public String getLargeurl() {
		return largeurl;
	}

}
