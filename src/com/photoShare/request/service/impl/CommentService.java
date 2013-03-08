/**
 * 
 */
package com.photoShare.request.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.photoShare.exception.NetworkError;
import com.photoShare.exception.TransactionError;
import com.photoShare.hiber.domain.comments.TComment;
import com.photoShare.hiber.domain.photo.TPhoto;
import com.photoShare.hiber.domain.photo.TPhotoDAO;
import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.ICommentService;

/**
 * @author Administrator
 * 
 */
public class CommentService extends BasicService implements ICommentService {

	private TUserDAO userDAO;
	private TPhotoDAO photoDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.service.interfaces.CommentServiceInterface#putComments(com.hiber.
	 * domain.comments.TComment)
	 */
	public TComment putComments(String comment, Serializable userId,
			Serializable photoId) {
		TComment com = new TComment();
		TUser user = userDAO.findById(userId);
		TPhoto photo = photoDAO.findById(photoId);
		if (user == null || photo == null) {
//			throw new TransactionError(
//					TransactionError.ERROR_CODE_ILLEGAL_PARAMETER);
		}

		try {
			com.setTUser(user);
			com.setTPhoto(photo);
			com.setFContent(comment);
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			try {
				com.setFCreateTime(ts);
			} catch (Exception e) {
				e.printStackTrace();
			}

			this.save(com);
			return com;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_COMMENT, "评论失败", "评论失败");
		} finally {
			com = null;
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

	public List<TComment> getComments(java.io.Serializable photoId,
			int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from com.photoShare.hiber.domain.comments.TComment "
				+ "where TPhoto.FId=? " + "order by FCreateTime";
		Integer[] params = { Integer.valueOf(photoId.toString()) };
		try {
			@SuppressWarnings("unchecked")
			List<TComment> comments = (List<TComment>) executeQueryByPage(hql,
					params, pageNow, pageSize);
			if (comments == null) {
				throw new TransactionError(
						TransactionError.ERROR_CODE_NO_COMMENTS);
			}
			return comments;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

}
