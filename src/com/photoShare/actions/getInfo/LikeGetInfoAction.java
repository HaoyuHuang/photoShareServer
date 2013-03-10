package com.photoShare.actions.getInfo;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.LikeInfo;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.hiber.domain.like.TLike;
import com.photoShare.request.service.ILikeService;

public class LikeGetInfoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5676728420724935174L;
	private LikeInfo like;
	private ILikeService iLikeService;
	private List<LikeInfo> likes;

	@Override
	public String execute() throws Exception {

		try {
			int pageNow = like.getCurrentPage();
			int pageSize = like.getDemandPage();
			int pid = like.getPid();

			List<TLike> tlikes = iLikeService.getLikesInfo(pid, 0, 10);
			likes = new ArrayList<LikeInfo>();
			BeansFactory factory = new BeansFactory();
			for (TLike like : tlikes) {
				System.out.println(like.getFLikeTime());
				likes.add(factory.convertBean(like));
			}
		} catch (Exception e) {
			throw e;
		}

		return SUCCESS;
	}

	public void setLike(LikeInfo like) {
		this.like = like;
	}

	public void setiLikeService(ILikeService iLikeService) {
		this.iLikeService = iLikeService;
	}

	public List<LikeInfo> getLikes() {
		return likes;
	}

}
