package com.photoShare.actions.getInfo;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.UserInfo;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.exception.NetworkError;
import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.IUserService;
import com.photoShare.util.Format;

public class UserHome extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4217290966876417046L;
	private UserInfo userInfo;
	private IUserService iUserService;
	private TUserDAO userDao;

	@JSON(serialize = false)
	public String editUserInfo() {

		try {
			TUser user = userDao.findById(userInfo.getUid());
			user.setFUserName(userInfo.getName());
			user.setFMail(userInfo.getMail());
			user.setFPhoneNumber(userInfo.getPhone());
			user.setFBirthday(Format.TimeConverte(userInfo.getBirthday()));
			user.setFBio(userInfo.getBio());
			BeansFactory factory = BeansFactory.Instance();
			userInfo = factory.convertBean(user, false);
			iUserService.editUserInfo(user);
		} catch (Exception e) {
			throw new NetworkError(NetworkError.ERROR_EDIT_PROFILE, "–ﬁ∏ƒ ß∞‹",
					"–ﬁ∏ƒ ß∞‹");
		}

		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getUserProfile() {

		try {
			int uid = userInfo.getUid();
			TUser user = iUserService.getUserInfo(uid);
			BeansFactory factory = BeansFactory.Instance();
			userInfo = factory.convertBean(user, false);
		} catch (Exception e) {
			throw e;
		}

		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getOtherProfile() {

		try {
			int uid = userInfo.getUid();
			int fid = userInfo.getFid();
			String fields = userInfo.getFields();
			TUser user = iUserService.getUserInfo(uid);
			boolean isFollowing = iUserService.isFollowing(uid, fid);
			BeansFactory factory = BeansFactory.Instance();
			userInfo = factory.convertBean(user, isFollowing);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String setPrivacy() {

		try {
			int uid = userInfo.getUid();
			boolean privacy = userInfo.isPrivacy();
			TUser user = userDao.findById(uid);
			int mPrivacy = privacy ? 1 : 0;
			user.setFPrivacy(mPrivacy);
			iUserService.editUserInfo(user);
			BeansFactory factory = BeansFactory.Instance();
			userInfo = factory.convertBean(user, false);
		} catch (Exception e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "…Ë÷√ ß∞‹",
					"…Ë÷√ ß∞‹");
		}

		return SUCCESS;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public void setUserDao(TUserDAO userDao) {
		this.userDao = userDao;
	}

}
