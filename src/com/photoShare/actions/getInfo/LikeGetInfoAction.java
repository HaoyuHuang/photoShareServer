package com.photoShare.actions.getInfo;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.LikeInfo;
import com.photoShare.request.service.ILikeService;

public class LikeGetInfoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5676728420724935174L;
	private LikeInfo like;
	private ILikeService iLikeService;
	private List<LikeInfo> likes;
	private int datediff;

	@JSON(serialize = false)
	public String getLikeInfo() {
		System.out.println("getLikeInfo");
		try {
			int pageNow = like.getCurrentPage();
			int pageSize = like.getDemandPage();
			int pid = like.getPid();
			likes = iLikeService.getLikesInfo(pid, 1, 10);
			// likes = new ArrayList<LikeInfo>();
			// BeansFactory factory = new BeansFactory();
			// for (TLike like : tlikes) {
			// System.out.println(like.getFLikeTime());
			// likes.add(factory.convertBean(like));
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getLikeInfoByDatediff() {
		System.out.println("getLikeInfoByDatediff");
		try {
			int pid = like.getPid();
			System.out.println(pid + " " + datediff);
			likes = iLikeService.getLikesInfoByDatediff(pid, datediff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@JSON(serialize = false)
	public int getDatediff() {
		return datediff;
	}

	public void setDatediff(int datediff) {
		this.datediff = datediff;
	}

}
