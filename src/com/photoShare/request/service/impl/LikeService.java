/**
 * 
 */
package com.photoShare.request.service.impl;

import java.io.Serializable;
import java.util.List;

import com.photoShare.exception.NetworkError;
import com.photoShare.exception.TransactionError;
import com.photoShare.hiber.domain.like.TLike;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.hiber.domain.photo.TPhotoDAO;
import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.ILikeService;

/**
 * @author Administrator
 * 
 */
public class LikeService extends BasicService implements ILikeService {

	private TUserDAO userDAO;
	private TPhotoDAO photoDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.service.interfaces.LikeServiceInterface#around(com.hiber.domain.like
	 * .TLike)
	 */
	public TLike Like(Serializable userId, Serializable photoId) {
		TLike like = new TLike();
		try {
			if (!exist(userId, photoId)) {
				TUser user = userDAO.findById(userId);
				TPhoto photo = photoDAO.findById(photoId);
				System.out.println(userId);
				System.out.println(photoId);
				if (user == null || photo == null) {
					throw new NetworkError(NetworkError.ERRPR_LIKE, "ÔÞÊ§°Ü",
							"ÔÞÊ§°Ü");
				}
				like.setTPhoto(photo);
				like.setTUser(user);
				save(like);
			} else {
				throw new NetworkError(NetworkError.ERRPR_LIKE, "ÔÞÊ§°Ü", "ÔÞÊ§°Ü");
			}
			return like;
		} catch (RuntimeException e) {
//			throw new NetworkError(NetworkError.ERRPR_LIKE, "ÔÞÊ§°Ü", "ÔÞÊ§°Ü");
			return null;
		} finally {
			like = null;
		}
	}

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public TPhotoDAO getPhotoDAO() {
		return photoDAO;
	}

	public void setPhotoDAO(TPhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
	}

	public List<TLike> getLikesInfo(Serializable id, int pageNow, int pageSize) {
		String hql = "from TLike " + "where TPhoto.FId = ?";
		Integer[] params = { Integer.valueOf(id.toString()) };
		try {
			@SuppressWarnings("unchecked")
			List<TLike> likes = (List<TLike>) executeQueryByPage(hql, params,
					pageNow, pageSize);
			if (likes == null) {
				throw new TransactionError(
						TransactionError.ERROR_CODE_NO_LIKE_ITEMS);
			}
			return likes;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "Ÿo·¨«@È¡”µ“þ",
					"Ÿo·¨«@È¡”µ“þ");
		}
	}

	public TLike Dislike(Serializable userId, Serializable photoId) {
		TLike like = new TLike();
		try {
			if (!exist(userId, photoId)) {
				TUser user = userDAO.findById(userId);
				TPhoto photo = photoDAO.findById(photoId);
				if (user == null || photo == null) {
					System.out.println("Error");
					throw new NetworkError(NetworkError.ERRPR_LIKE, "ÔÞÊ§°Ü",
							"ÔÞÊ§°Ü");
				}
				System.out.println(user.getFUserName());
				like.setTPhoto(photo);
				like.setTUser(user);
				save(like);
			} else {
				throw new NetworkError(NetworkError.ERRPR_LIKE, "ÔÞÊ§°Ü", "ÔÞÊ§°Ü");
			}
			return like;
		} catch (RuntimeException e) {
			System.out.println("Error");
			throw new NetworkError(NetworkError.ERRPR_LIKE, "ÔÞÊ§°Ü", "ÔÞÊ§°Ü");
		} finally {
			like = null;
		}
	}

	@Override
	public boolean isLike(Serializable uid, Serializable pid) {
		String hql = "from com.photoShare.hiber.domain.like.TLike "
				+ "where TUser.FId=? and TPhoto.FId=?";
		Integer[] params = { Integer.valueOf(uid.toString()),
				Integer.valueOf(pid.toString()) };
		try {
			TLike like = (TLike) uniqueQuery(hql, params);
			if (like == null) {
				return false;
			}
			return like.getFLike() == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "Ÿo·¨«@È¡”µ“þ",
					"Ÿo·¨«@È¡”µ“þ");
		}
	}

	@Override
	public boolean exist(Serializable uid, Serializable pid) {
		String hql = "from com.photoShare.hiber.domain.like.TLike "
				+ "where TUser.FId=? and TPhoto.FId=?";
		Integer[] params = { Integer.valueOf(uid.toString()),
				Integer.valueOf(pid.toString()) };
		try {
			TLike like = (TLike) uniqueQuery(hql, params);
			if (like == null) {
//				throw new TransactionError(
//						TransactionError.ERROR_CODE_NO_LIKE_ITEMS);
			}
			return like != null ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "Ÿo·¨«@È¡”µ“þ",
					"Ÿo·¨«@È¡”µ“þ");
		}
	}

}
