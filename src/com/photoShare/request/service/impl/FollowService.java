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

import com.photoShare.beans.FollowInfo;
import com.photoShare.exception.NetworkError;
import com.photoShare.exception.TransactionError;
import com.photoShare.hiber.domain.follow.TFollow;
import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.IFollowService;

/**
 * @author Administrator
 * 
 */
public class FollowService extends BasicService implements IFollowService {

	private TUserDAO userDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.service.interfaces.FollowServiceInterface#startFollowing(com.hiber
	 * .domain.follow.TFollow)
	 */
	public FollowInfo startFollowing(Serializable userId, Serializable followId) {
		Object[] params = new Object[] { userId, followId };
		String proc = "{call START_FOLLOW(?,?)}";
		int[] types = new int[] { Types.INTEGER, Types.INTEGER };
		try {
			executeProcedure(proc, params, types);
		} catch (Exception e1) {
			throw new NetworkError(NetworkError.ERROR_FOLLOW, "¸úËæÊ§°Ü", "¸úËæÊ§°Ü");
		}
		return null;
	}

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public TFollow cacelFollowing(Serializable userId, Serializable followId) {
		TFollow follower = new TFollow();
		TUser user = userDAO.findById(userId);
		TUser follow = userDAO.findById(followId);
		if (user == null || follow == null) {
			throw new NetworkError(NetworkError.ERROR_FOLLOW, "¸úËæÊ§°Ü", "¸úËæÊ§°Ü");
		}
		follower.setTUserByFMyId(user);
		follower.setTUserByFFollowId(follow);
		try {
			this.save(follower);
			return follower;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_FOLLOW, "¸úËæÊ§°Ü", "¸úËæÊ§°Ü");
		} finally {
			follower = null;
		}
	}

	public List<TUser> getFollowList(long[] ids, int pageNow, int pageSize) {
		TUserDAO dao = new TUserDAO();
		List<TUser> users = new ArrayList<TUser>();
		try {
			for (Serializable id : ids) {
				TUser user = dao.findById(id);
				if (user == null) {
					throw new TransactionError(
							TransactionError.ERROR_CODE_START_FOLLOWING_SOMEONE);
				}
				users.add(user);
			}

			return users;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "Ÿo·¨«@È¡”µ“þ",
					"Ÿo·¨«@È¡”µ“þ");
		}
	}

	public List<TFollow> getFollowerList(Serializable id, int pageNow,
			int pageSize) {
		String hql = "from TFollow where TUserByFFollowId.FId=? ";
		Integer[] params = { Integer.valueOf(id.toString()) };
		try {
			@SuppressWarnings("unchecked")
			List<TFollow> followers = (List<TFollow>) executeQueryByPage(hql,
					params, pageNow, pageSize);
			return followers;
		} catch (Exception e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "Ÿo·¨«@È¡”µ“þ",
					"Ÿo·¨«@È¡”µ“þ");
		}
	}

	public List<TFollow> getFollowingList(Serializable id, int pageNow,
			int pageSize) {
		String hql = "from TFollow where TUserByFMyId.FId=? ";
		Integer[] params = { Integer.valueOf(id.toString()) };
		try {
			@SuppressWarnings("unchecked")
			List<TFollow> followers = (List<TFollow>) executeQueryByPage(hql,
					params, pageNow, pageSize);
			return followers;
		} catch (Exception e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "Ÿo·¨«@È¡”µ“þ",
					"Ÿo·¨«@È¡”µ“þ");
		}
	}

}
