package com.photoShare.actions.getInfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.UserInfo;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.beans.photos.PopularPhotoHolder;
import com.photoShare.hiber.domain.photo.TPhoto;
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

	@JSON(serialize = false)
	public String getUserLikedPhotos() {

		try {
			System.out.println("getUserLikedPhotos");
			int uid = userInfo.getUid();
			int pageNow = userInfo.getCurrentPage();
			int pageSize = userInfo.getDemandPage();
			String fields = userInfo.getFields();
			List<TPhoto> feeds = iPhotoService.getUserLikedPhoto(uid, 0, 10);
			photos = new ArrayList<PhotoBean>();
			BeansFactory factory = BeansFactory.Instance();
			for (TPhoto feed : feeds) {
				photos.add(factory.convertBean(feed, true));
			}
		} catch (Exception e) {

		}

		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getUserPhotos() {

		try {
			int uid = userInfo.getUid();
			int pageNow = userInfo.getCurrentPage();
			int pageSize = userInfo.getDemandPage();
			String fields = userInfo.getFields();
			List<TPhoto> feeds = iPhotoService.getUserPhotos(uid, 0, 10);
			photos = new ArrayList<PhotoBean>();
			BeansFactory factory = BeansFactory.Instance();
			for (TPhoto feed : feeds) {
				photos.add(factory.convertBean(feed, true));
			}
			System.out.println(uid);
		} catch (Exception e) {

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
			String fields = userInfo.getFields();
			photos = iPhotoService.getFeeds(uid, 1, 10);
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

	public List<PhotoBean> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoBean> photos) {
		this.photos = photos;
	}

	public void setiLikeService(ILikeService iLikeService) {
		this.iLikeService = iLikeService;
	}

}
