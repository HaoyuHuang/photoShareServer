package com.photoShare.beans.factory;

import com.photoShare.beans.Comment;
import com.photoShare.beans.LikeInfo;
import com.photoShare.beans.UserInfo;
import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.beans.photos.PhotoBean.PhotoBeanBuidler;
import com.photoShare.hiber.domain.comments.TComment;
import com.photoShare.hiber.domain.follow.TFollow;
import com.photoShare.hiber.domain.like.TLike;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.hiber.domain.user.TUser;

public class BeansFactory {

	public Comment convertBean(TComment srcComment) {
		Comment destComment = new Comment();
		TUser user = srcComment.getTUser();
		destComment.setCid(srcComment.getFId());
		destComment.setPid(srcComment.getTPhoto().getFId());
		destComment.setUid(user.getFId());
		destComment.setUname(user.getFUserName());
		destComment.setContent(srcComment.getFContent());
		destComment.setCreateTime(srcComment.getFCreateTime().toString());
		destComment.setTinyurl(user.getFTinyPhoto());
		return destComment;
	}

	public UserInfo convertBean(TUser user, boolean isFollowing) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUid(user.getFId());
		userInfo.setName(user.getFUserName());
		userInfo.setPseudoname(user.getFPseudoName());
		userInfo.setMail(user.getFMail());
		userInfo.setGender(user.getFGender());
		if (user.getFBirthday() != null) {
			userInfo.setBirthday(user.getFBirthday().toString());
		}
		userInfo.setWebsite(user.getFWebsite());
		userInfo.setBio(user.getFBio());
		userInfo.setPhone(user.getFPhoneNumber());
		userInfo.setPrivacy(user.getFPrivacy() == 1 ? true : false);
		userInfo.setTinyurl(user.getFTinyPhoto());
		userInfo.setHeadurl(user.getFPhoto());
		userInfo.setLargeurl(user.getFLargePhoto());
		userInfo.setFollowerCnt(user.getTFollowsForFFollowId().size());
		userInfo.setFollowing(user.getTFollowsForFMyId().size());
		userInfo.setFollowing(isFollowing);
		userInfo.setPhotosCnt(user.getTPhotos().size());
		userInfo.setLikesCnt(user.getTLikes().size());
		return userInfo;
	}

	public UserInfo convertNewBean(TUser user) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUid(user.getFId());
		userInfo.setName(user.getFUserName());
		userInfo.setPseudoname(user.getFPseudoName());
		userInfo.setMail(user.getFMail());
		userInfo.setGender(user.getFGender());
		if (user.getFBirthday() != null) {
			userInfo.setBirthday(user.getFBirthday().toString());
		}
		userInfo.setWebsite(user.getFWebsite());
		userInfo.setBio(user.getFBio());
		userInfo.setPhone(user.getFPhoneNumber());
		userInfo.setPrivacy(user.getFPrivacy() == 1 ? true : false);
		userInfo.setTinyurl(user.getFTinyPhoto());
		userInfo.setHeadurl(user.getFPhoto());
		userInfo.setLargeurl(user.getFLargePhoto());
		userInfo.setFollowerCnt(0);
		userInfo.setFollowing(0);
		userInfo.setPhotosCnt(0);
		userInfo.setLikesCnt(0);
		return userInfo;
	}

	public LikeInfo convertBean(TLike like) {
		LikeInfo likeInfo = new LikeInfo();
		TUser user = like.getTUser();
		likeInfo.setLid(like.getFId());
		likeInfo.setPid(like.getTPhoto().getFId());
		likeInfo.setUid(user.getFId());
		likeInfo.setUname(user.getFUserName());
		likeInfo.setTinyHead(user.getFTinyPhoto());
		likeInfo.setCreateTime(like.getFLikeTime().toString());
		likeInfo.setLike(like.getFLike() == 1 ? true : false);
		return likeInfo;
	}

	public PhotoBean convertBean(TPhoto photo, boolean isLike) {
		PhotoBeanBuidler bean = new PhotoBeanBuidler();
		TUser user = photo.getTUser();
		bean.Pid(photo.getFId());
		bean.Uid(user.getFId());
		bean.UserName(user.getFUserName());
		bean.TinyHeadUrl(user.getFTinyPhoto());
		bean.Caption(photo.getFCaption());
		bean.CreateTime(photo.getFCreateTime().toString());
		bean.CommentCnt(photo.getTComments().size());
		bean.LikesCnt(photo.getTLikes().size());
		bean.isLike(isLike);
		bean.TinyUrl(photo.getFSmallSizeUrl());
		bean.MiddleUrl(photo.getFMiddleSizeUrl());
		bean.LargeUrl(photo.getFLargeSizeUrl());
		return bean.build();
	}

	public PhotoBean convertNewBean(TPhoto photo) {
		PhotoBeanBuidler bean = new PhotoBeanBuidler();
		// TUser user = photo.getTUser();
		// bean.Pid(photo.getFId());
		// bean.Uid(user.getFId());
		// bean.UserName(user.getFUserName());
		// bean.TinyHeadUrl(user.getFTinyPhoto());
		bean.Caption(photo.getFCaption());
		bean.CreateTime(photo.getFCreateTime().toString());
		bean.CommentCnt(0);
		bean.LikesCnt(0);
		bean.TinyUrl(photo.getFSmallSizeUrl());
		bean.MiddleUrl(photo.getFMiddleSizeUrl());
		bean.LargeUrl(photo.getFLargeSizeUrl());
		return bean.build();
	}

	public UserInfo convertBean(TFollow follow, boolean isFollower) {
		TUser user = null;
		if (isFollower) {
			user = follow.getTUserByFMyId();

		} else {
			user = follow.getTUserByFFollowId();
		}
		return convertBean(user, follow.getIsFollowing() == 1 ? true : false);
	}
}
