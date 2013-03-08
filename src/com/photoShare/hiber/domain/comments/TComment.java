package com.photoShare.hiber.domain.comments;

import java.sql.Timestamp;

import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.hiber.domain.user.TUser;

/**
 * TComment entity. @author MyEclipse Persistence Tools
 */

public class TComment implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TPhoto TPhoto;
	private TUser TUser;
	private String FContent;
	private Timestamp FCreateTime;

	public static final String KEY_COMMENTS = "comments";
	public static final String KEY_CID = "cid";
	public static final String KEY_PID = "pid";
	public static final String KEY_UID = "uid";
	public static final String KEY_UNAME = "uname";
	public static final String KEY_TINY_UHEAD = "tinyurl";
	public static final String KEY_CONTENT = "content";
	public static final String KEY_CREATE_TIME = "createTime";

	// Constructors

	/** default constructor */
	public TComment() {
	}

	/** full constructor */
	public TComment(TPhoto TPhoto, TUser TUser, String FContent,
			Timestamp FCreateTime) {
		this.TPhoto = TPhoto;
		this.TUser = TUser;
		this.FContent = FContent;
		this.FCreateTime = FCreateTime;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TPhoto getTPhoto() {
		return this.TPhoto;
	}

	public void setTPhoto(TPhoto TPhoto) {
		this.TPhoto = TPhoto;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public String getFContent() {
		return this.FContent;
	}

	public void setFContent(String FContent) {
		this.FContent = FContent;
	}

	public Timestamp getFCreateTime() {
		return this.FCreateTime;
	}

	public void setFCreateTime(Timestamp FCreateTime) {
		this.FCreateTime = FCreateTime;
	}

}