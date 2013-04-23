/**
 * 
 */
package com.photoShare.request.service.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.photoShare.beans.LikeInfo;
import com.photoShare.exception.NetworkError;
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
	public LikeInfo Like(Serializable userId, Serializable photoId) {
		Object[] params = new Object[] { userId, photoId };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER };
		String proc = "{call PUT_LIKE(?,?)}";
		try {
			ResultSet rs = executeProcedure(proc, params, types);
			LikeInfo info = new LikeInfo();
			while (rs.next()) {
				info.setLike(rs.getBoolean(1));
			}
			return info;
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new NetworkError(NetworkError.ERRPR_LIKE, "赞失败", "赞失败");
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

	public List<LikeInfo> getLikesInfo(Serializable id, int pageNow,
			int pageSize) {
		String proc = "{call GET_LIKE_INFO(?,?,?)}";
		Object[] params = new Object[] { id, pageNow, pageSize };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };
		try {
			ResultSet rs = executeProcedure(proc, params, types);
			List<LikeInfo> likes = new ArrayList<LikeInfo>();
			while (rs.next()) {
				LikeInfo info = new LikeInfo();
				info.setLid(rs.getInt(1));
				info.setUid(rs.getInt(2));
				info.setPid(rs.getInt(3));
				info.setUname(rs.getString(4));
				info.setTinyHead(rs.getString(5));
				info.setLike(rs.getBoolean(6));
				if (rs.getDate(7) != null) {
					info.setCreateTime(rs.getDate(7).toString());
				}
				likes.add(info);
			}
			return likes;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
		// String hql = "from TLike " + "where TPhoto.FId = ?";
		// Integer[] params = { Integer.valueOf(id.toString()) };
		// try {
		// @SuppressWarnings("unchecked")
		// List<TLike> likes = (List<TLike>) executeQueryByPage(hql, params,
		// pageNow, pageSize);
		// if (likes == null) {
		// throw new TransactionError(
		// TransactionError.ERROR_CODE_NO_LIKE_ITEMS);
		// }
		// return likes;
		// } catch (RuntimeException e) {
		// throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
		// "無法獲取數據");
		// }
	}

	public TLike Dislike(Serializable userId, Serializable photoId) {
		TLike like = new TLike();
		try {
			if (!exist(userId, photoId)) {
				TUser user = userDAO.findById(userId);
				TPhoto photo = photoDAO.findById(photoId);
				if (user == null || photo == null) {
					System.out.println("Error");
					throw new NetworkError(NetworkError.ERRPR_LIKE, "赞失败",
							"赞失败");
				}
				System.out.println(user.getFUserName());
				like.setTPhoto(photo);
				like.setTUser(user);
				save(like);
			} else {
				throw new NetworkError(NetworkError.ERRPR_LIKE, "赞失败", "赞失败");
			}
			return like;
		} catch (RuntimeException e) {
			System.out.println("Error");
			throw new NetworkError(NetworkError.ERRPR_LIKE, "赞失败", "赞失败");
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
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
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
				// throw new TransactionError(
				// TransactionError.ERROR_CODE_NO_LIKE_ITEMS);
			}
			return like != null ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

}
