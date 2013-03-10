package com.photoShare.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.Friend;
import com.photoShare.beans.UserInfo;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.exception.NetworkError;
import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.request.service.IUserService;

public class FriendsAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1221820757408764957L;
	private Friend friend;
	private IUserService iUserService;
	private List<UserInfo> friends;
	
	@JSON(serialize = false)
	public String getUserInfo() {

		try {
			String name = friend.getFriendName();
			int pageNow = friend.getCurrentPage();
			int pageSize = friend.getDemandPage();
			// name = "%" + name + "%";
			List<TUser> users = iUserService.findUserByName(name, pageNow,
					pageSize);
			System.out.println(users.size());
			BeansFactory factory = new BeansFactory();
			friends = new ArrayList<UserInfo>();
			for (TUser user : users) {
				friends.add(factory.convertBean(user, false));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_FIND_FRIENDS, "≤È’“ ß∞‹",
					"≤È’“ ß∞‹");
		}

		return SUCCESS;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public List<UserInfo> getFriends() {
		return friends;
	}

	public void setFriends(List<UserInfo> friends) {
		this.friends = friends;
	}

}
