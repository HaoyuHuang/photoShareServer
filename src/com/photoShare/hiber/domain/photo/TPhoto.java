package com.photoShare.hiber.domain.photo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.server.Server;

/**
 * TPhoto entity. @author MyEclipse Persistence Tools
 */

public class TPhoto implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TUser TUser;
	private String FLargeSizeUrl;
	private String FMiddleSizeUrl;
	private String FSmallSizeUrl;
	private Timestamp FCreateTime;
	private Integer FLargeSizeWidth;
	private Integer FLargeSizeHeight;
	private String FCaption;
	private Set TLikes = new HashSet(0);
	private Set TComments = new HashSet(0);

	public static final String KEY_PID = "pid";
	public static final String KEY_FILE_NAME = "fileName";
	public static final String KEY_UID = "uid";
	public static final String KEY_UNAME = "uname";
	public static final String KEY_CAPTION = "caption";
	public static final String KEY_CREATE_TIME = "createTime";
	public static final String KEY_LIKES_COUNT = "likesCount";
	public static final String KEY_COMMENT_COUNT = "commentCount";
	public static final String KEY_TINY_URL = "tinyurl";
	public static final String KEY_MIDDLE_URL = "url";
	public static final String KEY_LARGE_URL = "largeurl";
	public static final String KEY_CONTENT = "content";
	public static final String KEY_PHOTO = "photo";
	public static final String KEY_PHOTOS = "photos";

	// Constructors

	/** default constructor */
	public TPhoto() {
	}

	/** minimal constructor */
	public TPhoto(TUser TUser, String FLargeSizeUrl, String FMiddleSizeUrl,
			String FSmallSizeUrl, Timestamp FCreateTime,
			Integer FLargeSizeWidth, Integer FLargeSizeHeight) {
		this.TUser = TUser;
		this.FLargeSizeUrl = FLargeSizeUrl;
		this.FMiddleSizeUrl = FMiddleSizeUrl;
		this.FSmallSizeUrl = FSmallSizeUrl;
		this.FCreateTime = FCreateTime;
		this.FLargeSizeWidth = FLargeSizeWidth;
		this.FLargeSizeHeight = FLargeSizeHeight;
	}

	/** full constructor */
	public TPhoto(TUser TUser, String FLargeSizeUrl, String FMiddleSizeUrl,
			String FSmallSizeUrl, Timestamp FCreateTime,
			Integer FLargeSizeWidth, Integer FLargeSizeHeight, String FCaption,
			Set TLikes, Set TComments) {
		this.TUser = TUser;
		this.FLargeSizeUrl = FLargeSizeUrl;
		this.FMiddleSizeUrl = FMiddleSizeUrl;
		this.FSmallSizeUrl = FSmallSizeUrl;
		this.FCreateTime = FCreateTime;
		this.FLargeSizeWidth = FLargeSizeWidth;
		this.FLargeSizeHeight = FLargeSizeHeight;
		this.FCaption = FCaption;
		this.TLikes = TLikes;
		this.TComments = TComments;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public String getFLargeSizeUrl() {
		return Server.SERVER_URL + this.FLargeSizeUrl;
	}

	public void setFLargeSizeUrl(String FLargeSizeUrl) {
		this.FLargeSizeUrl = FLargeSizeUrl;
	}

	public String getFMiddleSizeUrl() {
		return Server.SERVER_URL + this.FMiddleSizeUrl;
	}

	public void setFMiddleSizeUrl(String FMiddleSizeUrl) {
		this.FMiddleSizeUrl = FMiddleSizeUrl;
	}

	public String getFSmallSizeUrl() {
		return Server.SERVER_URL + this.FSmallSizeUrl;
	}

	public void setFSmallSizeUrl(String FSmallSizeUrl) {
		this.FSmallSizeUrl = FSmallSizeUrl;
	}

	public Timestamp getFCreateTime() {
		return this.FCreateTime;
	}

	public void setFCreateTime(Timestamp FCreateTime) {
		this.FCreateTime = FCreateTime;
	}

	public Integer getFLargeSizeWidth() {
		return this.FLargeSizeWidth;
	}

	public void setFLargeSizeWidth(Integer FLargeSizeWidth) {
		this.FLargeSizeWidth = FLargeSizeWidth;
	}

	public Integer getFLargeSizeHeight() {
		return this.FLargeSizeHeight;
	}

	public void setFLargeSizeHeight(Integer FLargeSizeHeight) {
		this.FLargeSizeHeight = FLargeSizeHeight;
	}

	public String getFCaption() {
		return this.FCaption;
	}

	public void setFCaption(String FCaption) {
		this.FCaption = FCaption;
	}

	public Set getTLikes() {
		return this.TLikes;
	}

	public void setTLikes(Set TLikes) {
		this.TLikes = TLikes;
	}

	public Set getTComments() {
		return this.TComments;
	}

	public void setTComments(Set TComments) {
		this.TComments = TComments;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = KEY_CAPTION + " :" + this.FCaption + KEY_UNAME + " :"
				+ this.TUser.getFUserName();
		return str;
	}

}