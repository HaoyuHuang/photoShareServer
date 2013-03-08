package com.photoShare.hiber.domain.like;

import java.sql.Timestamp;

import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.hiber.domain.user.TUser;

/**
 * TLike entity. @author MyEclipse Persistence Tools
 */

public class TLike implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TPhoto TPhoto;
	private TUser TUser;
	private Integer FLike;
	private Timestamp FLikeTime;

	public static final String KEY_LIKES = "like";
	public static final String KEY_LID = "lid";
	public static final String KEY_PID = "pid";
	public static final String KEY_UID = "uid";
	public static final String KEY_UNAME = "uname";
	public static final String KEY_TINY_UHEAD = "tinyHead";
	public static final String KEY_CREATE_TIME = "createTime";

	// Constructors

	/** default constructor */
	public TLike() {
	}

	/** minimal constructor */
	public TLike(TPhoto TPhoto, TUser TUser) {
		this.TPhoto = TPhoto;
		this.TUser = TUser;
	}

	/** full constructor */
	public TLike(TPhoto TPhoto, TUser TUser, Integer FLike, Timestamp FLikeTime) {
		this.TPhoto = TPhoto;
		this.TUser = TUser;
		this.FLike = FLike;
		this.FLikeTime = FLikeTime;
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

	public Integer getFLike() {
		return this.FLike;
	}

	public void setFLike(Integer FLike) {
		this.FLike = FLike;
	}

	public Timestamp getFLikeTime() {
		return this.FLikeTime;
	}

	public void setFLikeTime(Timestamp FLikeTime) {
		this.FLikeTime = FLikeTime;
	}

}