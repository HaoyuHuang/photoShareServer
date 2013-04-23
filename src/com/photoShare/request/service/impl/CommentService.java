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

import com.photoShare.beans.Comment;
import com.photoShare.exception.NetworkError;
import com.photoShare.hiber.domain.comments.TComment;
import com.photoShare.hiber.domain.photo.TPhotoDAO;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.ICommentService;
import com.photoShare.server.Server;

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
		Object[] params = new Object[] { userId, photoId, comment };
		String proc = "{call PUT_COMMENT(?,?,?)}";
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR };
		try {
			executeProcedure(proc, params, types);
		} catch (Exception e1) {
			throw new NetworkError(NetworkError.ERROR_COMMENT, "评论失败", "评论失败");
		}
		return null;
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

	public List<Comment> getComments(java.io.Serializable photoId, int pageNow,
			int pageSize) {
		// TODO Auto-generated method stub
		String proc = "{call GET_COMMENTS(?,?,?)}";
		Object[] params = new Object[] { photoId, pageNow, pageSize };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };
		try {
			ResultSet rs = executeProcedure(proc, params, types);
			List<Comment> comments = new ArrayList<Comment>();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setCid(rs.getInt(1));
				comment.setPid(rs.getInt(2));
				comment.setUname(rs.getString(3));
				if (rs.getDate(4) != null) {
					comment.setCreateTime(rs.getDate(4).toString());
				} else {
					comment.setCreateTime("没有评论时间哦");
				}
				comment.setTinyurl(Server.SERVER_URL + rs.getString(5));
				comment.setUid(rs.getInt(6));
				comment.setContent(rs.getString(7));
				comments.add(comment);
			}
			return comments;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}

		// String hql = "from com.photoShare.hiber.domain.comments.TComment "
		// + "where TPhoto.FId=? " + "order by FCreateTime";
		// Integer[] params = { Integer.valueOf(photoId.toString()) };
		// try {
		// @SuppressWarnings("unchecked")
		// List<TComment> comments = (List<TComment>) executeQueryByPage(hql,
		// params, pageNow, pageSize);
		// if (comments == null) {
		// throw new TransactionError(
		// TransactionError.ERROR_CODE_NO_COMMENTS);
		// }
		// return comments;
		// } catch (RuntimeException e) {
		// throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
		// "無法獲取數據");
		// }
	}
}
