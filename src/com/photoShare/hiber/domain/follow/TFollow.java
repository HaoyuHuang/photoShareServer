package com.photoShare.hiber.domain.follow;

import java.sql.Timestamp;

import com.photoShare.hiber.domain.user.TUser;

/**
 * TFollow entity. @author MyEclipse Persistence Tools
 */

public class TFollow implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TUser TUserByFMyId;
	private TUser TUserByFFollowId;
	private Integer isFollowing;
	private Timestamp FFollowTime;

	public static final String KEY_USER_ID = "userId";
	public static final String KEY_FOLLOW_ID = "followId";
	public static final String KEY_FOLLOWING = "isFollowing";
	public static final String KEY_FOLLOW_IDS = "followIds";

	// Constructors

	/** default constructor */
	public TFollow() {
	}

	/** minimal constructor */
	public TFollow(TUser TUserByFMyId, TUser TUserByFFollowId) {
		this.TUserByFMyId = TUserByFMyId;
		this.TUserByFFollowId = TUserByFFollowId;
	}

	/** full constructor */
	public TFollow(TUser TUserByFMyId, TUser TUserByFFollowId,
			Timestamp FFollowTime) {
		this.TUserByFMyId = TUserByFMyId;
		this.TUserByFFollowId = TUserByFFollowId;
		this.FFollowTime = FFollowTime;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TUser getTUserByFMyId() {
		return this.TUserByFMyId;
	}

	public void setTUserByFMyId(TUser TUserByFMyId) {
		this.TUserByFMyId = TUserByFMyId;
	}

	public TUser getTUserByFFollowId() {
		return this.TUserByFFollowId;
	}

	public void setTUserByFFollowId(TUser TUserByFFollowId) {
		this.TUserByFFollowId = TUserByFFollowId;
	}

	public Timestamp getFFollowTime() {
		return this.FFollowTime;
	}

	public void setFFollowTime(Timestamp FFollowTime) {
		this.FFollowTime = FFollowTime;
	}

	public Integer getIsFollowing() {
		return isFollowing;
	}

	public void setIsFollowing(Integer isFollowing) {
		this.isFollowing = isFollowing;
	}

}