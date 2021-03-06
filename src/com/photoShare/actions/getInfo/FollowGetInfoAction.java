package com.photoShare.actions.getInfo;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.UserInfo;
import com.photoShare.request.service.IFollowService;

public class FollowGetInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4886845954970243091L;

	private UserInfo userInfo;
	private IFollowService iFollowService;
	private List<UserInfo> users;
	private int datediff;

	@JSON(serialize = false)
	public String getFollowerInfo() {

		try {
			int uid = userInfo.getUid();
			int pageNow = userInfo.getCurrentPage();
			int pageSize = userInfo.getDemandPage();

			users = iFollowService.getFollowerList(uid, 1, 10);
			// BeansFactory factory = new BeansFactory();
			// users = new ArrayList<UserInfo>();
			// for (TFollow follower : followers) {
			// users.add(factory.convertBean(follower, true));
			// }
		} catch (Exception e) {
			e.printStackTrace();
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
			users = iFollowService.getFollowingList(uid, 1, 10);
			// BeansFactory factory = new BeansFactory();
			// users = new ArrayList<UserInfo>();
			// for (TFollow follower : followers) {
			// users.add(factory.convertBean(follower, false));
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getFollowingInfoByDatediff() {
		System.out.println("getFollowingInfoByDatediff");
		try {
			int uid = userInfo.getUid();
			System.out.println(uid + " " + datediff);
			users = iFollowService.getFollowingListByDatediff(uid, datediff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getFollowerInfoByDatediff() {
		System.out.println("getFollowerInfoByDatediff");
		try {
			int uid = userInfo.getUid();
			System.out.println(uid + " " + datediff);
			users = iFollowService.getFollowerListByDatediff(uid, datediff);
		} catch (Exception e) {
			e.printStackTrace();
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

	@JSON(serialize = false)
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}

	@JSON(serialize = false)
	public int getDatediff() {
		return datediff;
	}

	public void setDatediff(int datediff) {
		this.datediff = datediff;
	}

}