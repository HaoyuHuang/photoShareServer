package com.photoShare.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.LikeInfo;
import com.photoShare.request.service.ILikeService;

public class LikeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6674294149229158418L;
	private LikeInfo like;
	private ILikeService iLikeService;

	@Override
	public String execute() throws Exception {

		try {
			int uid = like.getUid();
			int pid = like.getPid();
			boolean isLike = like.isLike();
			System.out.println(isLike);
			System.out.println("Like Action: uid:" + uid + "pid:" + pid
					+ "isLike:" + isLike);
			LikeInfo retVal = iLikeService.Like(uid, pid);
			like.setLike(retVal.isLike());
		} catch (Exception e) {
			throw e;
		}
		return SUCCESS;
	}

	public LikeInfo getLike() {
		return like;
	}

	public void setLike(LikeInfo like) {
		this.like = like;
	}

	public void setiLikeService(ILikeService iLikeService) {
		this.iLikeService = iLikeService;
	}

}
