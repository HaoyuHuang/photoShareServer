package com.photoShare.actions.getInfo;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.UserInfo;
import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.beans.photos.PopularPhotoHolder;
import com.photoShare.request.service.ILikeService;
import com.photoShare.request.service.IPhotoService;

public class PhotosGetInfoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8985919873363507710L;
	private UserInfo userInfo;
	private IPhotoService iPhotoService;
	private ILikeService iLikeService;
	private List<PhotoBean> photos;
	private String pids;

	@JSON(serialize = false)
	public String getUserLikedPhotos() {

		try {
			System.out.println("getUserLikedPhotos");
			int uid = userInfo.getUid();
			int pageNow = userInfo.getCurrentPage();
			int pageSize = userInfo.getDemandPage();
			// String fields = userInfo.getFields();
			photos = iPhotoService.getUserLikedPhoto(uid, pageNow, pageSize);
			// photos = new ArrayList<PhotoBean>();
			// BeansFactory factory = new BeansFactory();
			// for (TPhoto feed : feeds) {
			// photos.add(factory.convertBean(feed, true));
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getNewsPhotos() {
		try {
			System.out.println("getNewsPhotos");
			int uid = userInfo.getUid();
			photos = iPhotoService.getPhotos(uid, pids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getUserPhotos() {

		try {
			int uid = userInfo.getUid();
			int pageNow = userInfo.getCurrentPage();
			int pageSize = userInfo.getDemandPage();
			// String fields = userInfo.getFields();
			photos = iPhotoService.getUserPhotos(uid, pageNow, pageSize);
			// photos = new ArrayList<PhotoBean>();
			// BeansFactory factory = new BeansFactory();
			// for (TPhoto feed : feeds) {
			// photos.add(factory.convertBean(feed, true));
			// }
			// System.out.println(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getPopularPhotos() {
		PopularPhotoHolder holder = PopularPhotoHolder.Instance();
		try {
			System.out.println("getPopularPhotos");
			// int pageSize = userInfo.getDemandPage();
			// String fields = userInfo.getFields();
			photos = holder.getPopularPhotos();
			if (photos == null || photos.isEmpty()) {
				photos = iPhotoService.getPopularPhotos();
				holder.hold(photos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getPhotosFeeds() {
		System.out.println("gePhotosFeeds");
		try {
			int uid = userInfo.getUid();
			int pageNow = userInfo.getCurrentPage();
			int pageSize = userInfo.getDemandPage();
			// String fields = userInfo.getFields();
			System.out.println(uid + "-----" + pageNow + "----" + pageSize);
			photos = iPhotoService.getFeeds(uid, pageNow, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setiPhotoService(IPhotoService iPhotoService) {
		this.iPhotoService = iPhotoService;
	}

	@JSON(serialize = false)
	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}

	public List<PhotoBean> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoBean> photos) {
		this.photos = photos;
	}

	@JSON(serialize = false)
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setiLikeService(ILikeService iLikeService) {
		this.iLikeService = iLikeService;
	}

}
