package com.photoShare.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.UserInfo;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.request.service.IUserService;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7258097739526058721L;
	private UserInfo userInfo;
	private IUserService mUserService;

	public String signIn() {

		String name = userInfo.getName();
		String pwd = userInfo.getPwd();
		TUser user = new TUser();
		user.setFUserName(name);
		user.setFPassword(pwd);
		try {
			user = mUserService.signin(user);
			BeansFactory factory = BeansFactory.Instance();
			userInfo = factory.convertBean(user, false);
		} catch (Exception e) {

		}
		return SUCCESS;
	}

	public String signOff() {
		return SUCCESS;
	}

	public String signUp() {

		TUser user = new TUser();
		user.setFMail(userInfo.getMail());
		user.setFPassword(userInfo.getPwd());
		user.setFUserName(userInfo.getName());
		user.setFPhoneNumber(userInfo.getPhone());
		user.setFPseudoName(userInfo.getPseudoname());
		try {
			if (mUserService.check(user)) {
				mUserService.register(user);
				BeansFactory factory = BeansFactory.Instance();
				userInfo = factory.convertBean(user, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return SUCCESS;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setmUserService(IUserService mUserService) {
		this.mUserService = mUserService;
	}

}
