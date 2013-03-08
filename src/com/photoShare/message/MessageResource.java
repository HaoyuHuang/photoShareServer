package com.photoShare.message;

import com.photoShare.hiber.domain.comments.TComment;
import com.photoShare.hiber.domain.follow.TFollow;
import com.photoShare.hiber.domain.like.TLike;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.hiber.domain.user.TUser;

public class MessageResource {
	public static final String[] DEFAULT_COMMENT_KEYS = { TComment.KEY_CONTENT,
			TComment.KEY_CREATE_TIME, TComment.KEY_PID,
			TComment.KEY_TINY_UHEAD, TComment.KEY_UID, TComment.KEY_UNAME };

	public static final String[] ALL_COMMENT_KEYS = { TComment.KEY_CID,
			TComment.KEY_CONTENT, TComment.KEY_CREATE_TIME, TComment.KEY_PID,
			TComment.KEY_TINY_UHEAD, TComment.KEY_UID, TComment.KEY_UNAME };

	public static final String[] ALL_LIKES_PHOTO = { TLike.KEY_LID,
			TLike.KEY_PID, TLike.KEY_UID, TLike.KEY_UNAME,
			TLike.KEY_TINY_UHEAD, TLike.KEY_LIKES, TLike.KEY_CREATE_TIME };

	public static final String[] DEFAULT_LIKES_PHOTO = { TLike.KEY_PID,
			TLike.KEY_UID, TLike.KEY_UNAME, TLike.KEY_TINY_UHEAD,
			TLike.KEY_LIKES, TLike.KEY_CREATE_TIME };

	public static final String[] DEFAULT_FOLLOWS_INFO = { TFollow.KEY_USER_ID,
			TFollow.KEY_FOLLOW_ID, TFollow.KEY_FOLLOWING };

	public static final String[] DEFAULT_FOLLOWS_KEYS = { TFollow.KEY_FOLLOWING };

	public static final String[] DEFAULT_USER_INFO_KEYS = { TUser.KEY_UID,
			TUser.KEY_NAME, TUser.KEY_PSEUDO_NAME, TUser.KEY_TINY_HEAD_URL,
			TUser.KEY_MIDDLE_HEAD_URL, TUser.KEY_LARGE_HEAD_URL };
	/**
	 * 所有字段
	 */
	public static final String[] ALL_USER_INFO_KEYS = { TUser.KEY_UID,
			TUser.KEY_NAME, TUser.KEY_GENDER, TUser.KEY_WEBSITE, TUser.KEY_BIO,
			TUser.KEY_BIRTHDAY, TUser.KEY_PHONE_NUMBER, TUser.KEY_PRIVACY,
			TUser.KEY_TINY_HEAD_URL, TUser.KEY_MIDDLE_HEAD_URL,
			TUser.KEY_LARGE_HEAD_URL, TUser.KEY_PHOTOS_CNT,
			TUser.KEY_LIKES_CNT, TUser.KEY_FOLLOWER_CNT,
			TUser.KEY_FOLLOWING_CNT };

	/**
	 * 所有字段
	 */
	public static final String[] ALL_OTHER_USER_INFO_KEYS = { TUser.KEY_UID,
			TUser.KEY_NAME, TUser.KEY_GENDER, TUser.KEY_WEBSITE, TUser.KEY_BIO,
			TUser.KEY_BIRTHDAY, TUser.KEY_PHONE_NUMBER, TUser.KEY_PRIVACY,
			TUser.KEY_TINY_HEAD_URL, TUser.KEY_MIDDLE_HEAD_URL,
			TUser.KEY_LARGE_HEAD_URL, TUser.KEY_PHOTOS_CNT,
			TUser.KEY_LIKES_CNT, TUser.KEY_FOLLOWER_CNT,
			TUser.KEY_FOLLOWING_CNT, TUser.KEY_IS_FOLLOWING };

	/**
	 * 所有字段
	 */
	public static final String[] ALL_PHOTO_INFO_KEY = { TPhoto.KEY_PID,
			TPhoto.KEY_UID, TPhoto.KEY_UNAME, TPhoto.KEY_CAPTION,
			TPhoto.KEY_CREATE_TIME, TPhoto.KEY_COMMENT_COUNT,
			TPhoto.KEY_LIKES_COUNT, TPhoto.KEY_TINY_URL, TPhoto.KEY_MIDDLE_URL,
			TPhoto.KEY_LARGE_URL };

	/**
	 * 默认字段<br>
	 * 不添加fields参数也按此字段返回
	 */
	public static final String[] DEFAULT_PHOTO_INFO_KEY = { TPhoto.KEY_PID,
			TPhoto.KEY_UID, TPhoto.KEY_UNAME, TPhoto.KEY_TINY_URL,
			TPhoto.KEY_MIDDLE_URL, TPhoto.KEY_LARGE_URL };

}
