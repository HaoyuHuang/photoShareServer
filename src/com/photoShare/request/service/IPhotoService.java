/**
 * 
 */
package com.photoShare.request.service;

import java.util.List;

import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.hiber.domain.photo.TPhoto;

/**
 * @author Aron ��Ƭ����ӿ�
 */
public interface IPhotoService {

	/**
	 * ������Ƭ
	 * 
	 * @param photo
	 *            �������Ƭ
	 * 
	 * @param id
	 *            �û�ID
	 * */
	public void publishPhoto(TPhoto photo, java.io.Serializable id);

	/**
	 * @param id
	 */
	public List<PhotoBean> getFeeds(java.io.Serializable id, int pageNow,
			int pageSize);

	public List<PhotoBean> getPopularPhotos();

	public PhotoBean getPhoto(java.io.Serializable uid, java.io.Serializable pid);

	public List<PhotoBean> getPhotos(java.io.Serializable uid, String pids);

	public List<PhotoBean> getUserPhotos(java.io.Serializable id, int pageNow,
			int pageSize);

	public List<PhotoBean> getUserLikedPhoto(java.io.Serializable id,
			int pageNow, int pageSize);

}
