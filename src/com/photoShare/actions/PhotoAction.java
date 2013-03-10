package com.photoShare.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.PhotoInfo;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.exception.NetworkError;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.request.service.ILikeService;
import com.photoShare.request.service.IPhotoService;

public class PhotoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3587928684818065165L;
	private PhotoBean photo;
	private IPhotoService iPhotoService;
	private ILikeService iLikeService;
	private PhotoInfo photoBean;

	@Override
	public String execute() throws Exception {

		try {
			int pid = photoBean.getPid();
			int uid = photoBean.getUid();
			TPhoto tphoto = iPhotoService.getPhoto(pid);
			BeansFactory factory = new BeansFactory();
			photo = factory.convertBean(tphoto, iLikeService.isLike(uid, pid));
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "获取失败",
					"获取失败");
		}

		return SUCCESS;
	}

	public void setiPhotoService(IPhotoService iPhotoService) {
		this.iPhotoService = iPhotoService;
	}

	public PhotoBean getPhoto() {
		return photo;
	}

	public void setPhotoBean(PhotoInfo photoBean) {
		this.photoBean = photoBean;
	}

	public void setiLikeService(ILikeService iLikeService) {
		this.iLikeService = iLikeService;
	}

}
