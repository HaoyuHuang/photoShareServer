package com.photoShare.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.FollowInfo;
import com.photoShare.exception.NetworkError;
import com.photoShare.request.service.IFollowService;

public class FollowAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4286059947190508924L;
	private FollowInfo follow;
	private IFollowService iFollowService;

	@Override
	public String execute() throws Exception {
		try {
			int uid = follow.getUid();
			int fid = follow.getFid();
			follow = iFollowService.startFollowing(uid, fid);
		} catch (Exception e) {
			throw new NetworkError(NetworkError.ERROR_FOLLOW, "¸úËæÊ§°Ü", "¸úËæÊ§°Ü");
		}
		return SUCCESS;
	}

	public FollowInfo getFollow() {
		return follow;
	}

	public void setFollow(FollowInfo follow) {
		this.follow = follow;
	}

	public void setiFollowService(IFollowService iFollowService) {
		this.iFollowService = iFollowService;
	}

}
