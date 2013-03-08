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

	public TPhoto getPhoto(java.io.Serializable id);

	public List<TPhoto> getUserPhotos(java.io.Serializable id, int pageNow,
			int pageSize);

	public List<TPhoto> getUserLikedPhoto(java.io.Serializable id, int pageNow,
			int pageSize);

}
