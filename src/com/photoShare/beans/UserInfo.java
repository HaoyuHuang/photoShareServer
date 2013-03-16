package com.photoShare.beans;

import com.photoShare.server.RequestParam;

public class UserInfo extends RequestParam {
	private int uid;

	private String name;

	private String pwd;

	private String mail;

	private String phone;

	private String pseudoname;

	private String createTime;

	private String website;

	private String bio;

	private String birthday;

	private String gender;

	private boolean privacy;

	private boolean isFollowing;

	private String tinyurl;

	private String headurl;

	private String largeurl;

	private int follower;

	private int following;

	private int photosCnt;

	private int likesCnt;

	private int fid;

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public boolean isFollowing() {
		return isFollowing;
	}

	public void setFollowing(boolean isFollowing) {
		this.isFollowing = isFollowing;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPseudoname() {
		return pseudoname;
	}

	public void setPseudoname(String pseudoname) {
		this.pseudoname = pseudoname;
	}

	public int getUid() {
		return uid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTinyurl() {
		return tinyurl;
	}

	public void setTinyurl(String tinyurl) {
		this.tinyurl = tinyurl;
	}

	public String getHeadurl() {
		return headurl;
	}

	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}

	public String getLargeurl() {
		return largeurl;
	}

	public void setLargeurl(String largeurl) {
		this.largeurl = largeurl;
	}

	public int getFollower() {
		return follower;
	}

	public void setFollower(int follower) {
		this.follower = follower;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getPhotosCnt() {
		return photosCnt;
	}

	public void setPhotosCnt(int photosCnt) {
		this.photosCnt = photosCnt;
	}

	public int getLikesCnt() {
		return likesCnt;
	}

	public void setLikesCnt(int likesCnt) {
		this.likesCnt = likesCnt;
	}

}
