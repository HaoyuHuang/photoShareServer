package com.photoShare.actions.getInfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.UserInfo;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.hiber.domain.follow.TFollow;
import com.photoShare.request.service.IFollowService;

public class FollowGetInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4886845954970243091L;

	private UserInfo userInfo;
	private IFollowService iFollowService;
	private List<UserInfo> users;

	@JSON(serialize = false)
	public String getFollowerInfo() {

		try {
			int uid = userInfo.getUid();
			int pageNow = userInfo.getCurrentPage();
			int pageSize = userInfo.getDemandPage();

			List<TFollow> followers = iFollowService
					.getFollowerList(uid, 0, 10);
			BeansFactory factory = BeansFactory.Instance();
			users = new ArrayList<UserInfo>();
			for (TFollow follower : followers) {
				users.add(factory.convertBean(follower, true));
			}
		} catch (Exception e) {

		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getFollowingInfo() {
		try {
			int uid = userInfo.getUid();
			int pageNow = userInfo.getCurrentPage();
			int pageSize = userInfo.getDemandPage();
			System.out.println(uid);
			List<TFollow> followers = iFollowService.getFollowingList(uid, 0,
					10);
			BeansFactory factory = BeansFactory.Instance();
			users = new ArrayList<UserInfo>();
			for (TFollow follower : followers) {
				users.add(factory.convertBean(follower, false));
			}
		} catch (Exception e) {

		}
		return SUCCESS;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setiFollowService(IFollowService iFollowService) {
		this.iFollowService = iFollowService;
	}

	public List<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}

}