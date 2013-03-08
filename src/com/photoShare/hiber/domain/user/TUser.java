package com.photoShare.hiber.domain.user;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.photoShare.server.Server;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer FId;
	private String FMail;
	private String FPassword;
	private String FUserName;
	private String FPseudoName;
	private Timestamp FCreateTime;
	private String FPhoto;
	private String FWebsite;
	private String FBio;
	private String FPhoneNumber;
	private String FGender;
	private Timestamp FBirthday;
	private Integer FPrivacy;
	private String FTinyPhoto;
	private String FLargePhoto;
	private Set TLikes = new HashSet(0);
	private Set TComments = new HashSet(0);
	private Set TFollowsForFFollowId = new HashSet(0);
	private Set TFollowsForFMyId = new HashSet(0);
	private Set TPhotos = new HashSet(0);

	public static final String KEY_UID = "uid";
	public static final String KEY_NAME = "name";
	public static final String KEY_PSEUDO_NAME = "pseudoname";
	public static final String KEY_MAIL = "mail";
	public static final String KEY_GENDER = "gender";
	public static final String KEY_BIRTHDAY = "birthday";
	public static final String KEY_WEBSITE = "website";
	public static final String KEY_BIO = "bio";
	public static final String KEY_PHONE_NUMBER = "phone";
	public static final String KEY_PRIVACY = "privacy";
	public static final String KEY_TINY_HEAD_URL = "tinyurl";
	public static final String KEY_MIDDLE_HEAD_URL = "headurl";
	public static final String KEY_LARGE_HEAD_URL = "largeurl";
	public static final String KEY_FOLLOWER_CNT = "follower";
	public static final String KEY_FOLLOWING_CNT = "following";
	public static final String KEY_IS_FOLLOWING = "isFollowing";
	public static final String KEY_PHOTOS_CNT = "photosCnt";
	public static final String KEY_LIKES_CNT = "likesCnt";

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String FMail, String FPassword, String FUserName) {
		this.FMail = FMail;
		this.FPassword = FPassword;
		this.FUserName = FUserName;
	}

	/** full constructor */
	public TUser(String FMail, String FPassword, String FUserName,
			Timestamp FCreateTime, String FPhoto, String FWebsite, String FBio,
			String FPhoneNumber, String FGender, Timestamp FBirthday,
			Integer FPrivacy, String FTinyPhoto, String FLargePhoto,
			Set TLikes, Set TComments, Set TFollowsForFFollowId,
			Set TFollowsForFMyId, Set TPhotos) {
		this.FMail = FMail;
		this.FPassword = FPassword;
		this.FUserName = FUserName;
		this.FCreateTime = FCreateTime;
		this.FPhoto = FPhoto;
		this.FWebsite = FWebsite;
		this.FBio = FBio;
		this.FPhoneNumber = FPhoneNumber;
		this.FGender = FGender;
		this.FBirthday = FBirthday;
		this.FPrivacy = FPrivacy;
		this.FTinyPhoto = FTinyPhoto;
		this.FLargePhoto = FLargePhoto;
		this.TLikes = TLikes;
		this.TComments = TComments;
		this.TFollowsForFFollowId = TFollowsForFFollowId;
		this.TFollowsForFMyId = TFollowsForFMyId;
		this.TPhotos = TPhotos;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public String getFMail() {
		return FMail;
	}

	public void setFMail(String fMail) {
		FMail = fMail;
	}

	public String getFPassword() {
		return this.FPassword;
	}

	public void setFPassword(String FPassword) {
		this.FPassword = FPassword;
	}

	public String getFUserName() {
		return this.FUserName;
	}

	public void setFUserName(String FUserName) {
		this.FUserName = FUserName;
	}

	public String getFPseudoName() {
		return FPseudoName;
	}

	public void setFPseudoName(String fPseudoName) {
		FPseudoName = fPseudoName;
	}

	public Timestamp getFCreateTime() {
		return this.FCreateTime;
	}

	public void setFCreateTime(Timestamp FCreateTime) {
		this.FCreateTime = FCreateTime;
	}

	public String getFPhoto() {
		return Server.SERVER_URL + this.FPhoto;
	}

	public void setFPhoto(String FPhoto) {
		this.FPhoto = FPhoto;
	}

	public String getFWebsite() {
		return this.FWebsite;
	}

	public void setFWebsite(String FWebsite) {
		this.FWebsite = FWebsite;
	}

	public String getFBio() {
		return this.FBio;
	}

	public void setFBio(String FBio) {
		this.FBio = FBio;
	}

	public String getFPhoneNumber() {
		return this.FPhoneNumber;
	}

	public void setFPhoneNumber(String FPhoneNumber) {
		this.FPhoneNumber = FPhoneNumber;
	}

	public String getFGender() {
		return this.FGender;
	}

	public void setFGender(String FGender) {
		this.FGender = FGender;
	}

	public Timestamp getFBirthday() {
		return this.FBirthday;
	}

	public void setFBirthday(Timestamp FBirthday) {
		this.FBirthday = FBirthday;
	}

	public Integer getFPrivacy() {
		return this.FPrivacy;
	}

	public void setFPrivacy(Integer FPrivacy) {
		this.FPrivacy = FPrivacy;
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

	public Set getTFollowsForFFollowId() {
		return this.TFollowsForFFollowId;
	}

	public void setTFollowsForFFollowId(Set TFollowsForFFollowId) {
		this.TFollowsForFFollowId = TFollowsForFFollowId;
	}

	public Set getTFollowsForFMyId() {
		return this.TFollowsForFMyId;
	}

	public void setTFollowsForFMyId(Set TFollowsForFMyId) {
		this.TFollowsForFMyId = TFollowsForFMyId;
	}

	public Set getTPhotos() {
		return this.TPhotos;
	}

	public void setTPhotos(Set TPhotos) {
		this.TPhotos = TPhotos;
	}

	public String getFTinyPhoto() {
		return Server.SERVER_URL + FTinyPhoto;
	}

	public void setFTinyPhoto(String fTinyPhoto) {
		FTinyPhoto = fTinyPhoto;
	}

	public String getFLargePhoto() {
		return Server.SERVER_URL + FLargePhoto;
	}

	public void setFLargePhoto(String fLargePhoto) {
		FLargePhoto = fLargePhoto;
	}

}