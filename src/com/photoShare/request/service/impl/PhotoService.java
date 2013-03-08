/**
 * 
 */
package com.photoShare.request.service.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.beans.photos.PhotoBean.PhotoBeanBuidler;
import com.photoShare.exception.NetworkError;
import com.photoShare.exception.TransactionError;
import com.photoShare.hiber.domain.like.TLike;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.hiber.domain.photo.TPhotoDAO;
import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.IPhotoService;
import com.photoShare.server.Server;

/**
 * @author Administrator
 * 
 */
public class PhotoService extends BasicService implements IPhotoService {

	private TUserDAO userDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.service.interfaces.PhotoServiceInterface#savePhoto(com.hiber.domain
	 * .photo.TPhoto)
	 */
	public void publishPhoto(TPhoto photo, Serializable id) {
		// TODO Auto-generated method stub
		TUser user = userDAO.findById(id);
		if (user == null) {
			throw new TransactionError(
					TransactionError.ERROR_CODE_ILLEGAL_PARAMETER);
		}
		try {
			photo.setTUser(user);
			this.save(photo);
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_PHOTO, "发布失败", "发布失败");
		}
	}

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<PhotoBean> getFeeds(Serializable id, int pageNow, int pageSize) {

		try {
			Object[] params = new Object[] { id, pageNow, pageSize };
			String proc = "{call GET_FEEDS(?,?,?)}";
			int[] types = new int[] { Types.INTEGER, Types.INTEGER,
					Types.INTEGER };
			ResultSet rs = executeProcedure(proc, params, types);
			List<PhotoBean> list = new ArrayList<PhotoBean>();
			PhotoBeanBuidler builder = new PhotoBeanBuidler();
			while (rs.next()) {
				PhotoBean bean = builder.Uid(rs.getInt(1))
						.UserName(rs.getString(2)).Pid(rs.getInt(3))
						.TinyHeadUrl(Server.SERVER_URL + rs.getString(4))
						.TinyUrl(Server.SERVER_URL + rs.getString(5))
						.MiddleUrl(Server.SERVER_URL + rs.getString(6))
						.LargeUrl(Server.SERVER_URL + rs.getString(7))
						.Caption(rs.getString(8))
						.CreateTime(rs.getDate(9).toString())
						.CommentCnt(rs.getInt(10)).LikesCnt(rs.getInt(11))
						.isLike(rs.getInt(12) == 1 ? true : false).build();
				list.add(bean);
			}
			return list;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

	public TPhoto getPhoto(Serializable id) {
		// TODO Auto-generated method stub
		TPhotoDAO dao = new TPhotoDAO();
		TPhoto photo = dao.findById(id);
		return photo;
	}

	public List<TPhoto> getUserPhotos(Serializable id, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from com.photoShare.hiber.domain.photo.TPhoto where TUser.FId=? ";
		Integer[] params = { Integer.valueOf(String.valueOf(id)) };
		try {
			@SuppressWarnings("unchecked")
			List<TPhoto> photos = (List<TPhoto>) executeQueryByPage(hql,
					params, pageNow, pageSize);
			if (photos == null) {
				throw new TransactionError(
						TransactionError.ERROR_CODE_START_SHARING_PHOTOS);
			}
			return photos;

		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

	public List<TPhoto> getUserLikedPhoto(Serializable id, int pageNow,
			int pageSize) {
		// TODO Auto-generated method stub

		String hql = "from com.photoShare.hiber.domain.like.TLike "
				+ "where TUser.FId=?";
		Integer[] params = { Integer.valueOf(String.valueOf(id)) };
		try {
			@SuppressWarnings("unchecked")
			List<TLike> likes = (List<TLike>) executeQueryByPage(hql, params,
					pageNow, pageSize);
			if (likes == null) {
				throw new TransactionError(
						TransactionError.ERROR_CODE_START_SHARING_PHOTOS);
			}
			List<TPhoto> photos = new ArrayList<TPhoto>();
			for (TLike like : likes) {
				photos.add(like.getTPhoto());
			}
			return photos;

		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}

	}

	public List<PhotoBean> getPopularPhotos() {
		String hql = "getPopularPhoto";
		@SuppressWarnings("unchecked")
		List<PhotoBean> photo = (List<PhotoBean>) executeProcedure(hql, null);
		return photo;
	}

}
