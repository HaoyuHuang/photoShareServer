/**
 * 
 */
package com.photoShare.request.service.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.photoShare.beans.FollowInfo;
import com.photoShare.beans.UserInfo;
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
			throw new NetworkError(NetworkError.ERROR_FOLLOW, "跟随失败", "跟随失败");
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
			throw new NetworkError(NetworkError.ERROR_FOLLOW, "跟随失败", "跟随失败");
		}
		follower.setTUserByFMyId(user);
		follower.setTUserByFFollowId(follow);
		try {
			this.save(follower);
			return follower;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_FOLLOW, "跟随失败", "跟随失败");
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
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

	public List<UserInfo> getFollowerList(Serializable id, int pageNow,
			int pageSize) {
		String proc = "{call GET_FOLLOWER_INFO(?,?,?)}";
		Object[] params = new Object[] { id, pageNow, pageSize };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };

		try {
			ResultSet rs = executeProcedure(proc, params, types);
			List<UserInfo> info = new ArrayList<UserInfo>();
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setUid(rs.getInt(1));
				user.setMail(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setName(rs.getString(4));
				user.setPseudoname(rs.getString(5));
				user.setHeadurl(rs.getString(7));
				user.setWebsite(rs.getString(8));
				user.setBio(rs.getString(9));
				user.setPhone(rs.getString(10));
				user.setGender(rs.getString(11));
				user.setBirthday(rs.getDate(12).toString());
				user.setPrivacy(rs.getBoolean(13));
				user.setTinyurl(rs.getString(14));
				user.setLargeurl(rs.getString(15));
				info.add(user);
			}
			return info;
		} catch (Exception e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}

		// String hql = "from TFollow where TUserByFFollowId.FId=? ";
		// Integer[] params = { Integer.valueOf(id.toString()) };
		// try {
		// @SuppressWarnings("unchecked")
		// List<TFollow> followers = (List<TFollow>) executeQueryByPage(hql,
		// params, pageNow, pageSize);
		// return followers;
		// } catch (Exception e) {
		// throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
		// "無法獲取數據");
		// }
	}

	public List<UserInfo> getFollowingList(Serializable id, int pageNow,
			int pageSize) {
		String proc = "{call GET_FOLLOWING_INFO(?,?,?)}";
		Object[] params = new Object[] { id, pageNow, pageSize };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER };

		try {
			ResultSet rs = executeProcedure(proc, params, types);
			List<UserInfo> info = new ArrayList<UserInfo>();
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setUid(rs.getInt(1));
				user.setMail(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setName(rs.getString(4));
				user.setPseudoname(rs.getString(5));
				user.setHeadurl(rs.getString(7));
				user.setWebsite(rs.getString(8));
				user.setBio(rs.getString(9));
				user.setPhone(rs.getString(10));
				user.setGender(rs.getString(11));
				user.setBirthday(rs.getDate(12).toString());
				user.setPrivacy(rs.getBoolean(13));
				user.setTinyurl(rs.getString(14));
				user.setLargeurl(rs.getString(15));
				info.add(user);
			}
			return info;
		} catch (Exception e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
		
		// String hql = "from TFollow where TUserByFMyId.FId=? ";
		// Integer[] params = { Integer.valueOf(id.toString()) };
		// try {
		// @SuppressWarnings("unchecked")
		// List<TFollow> followers = (List<TFollow>) executeQueryByPage(hql,
		// params, pageNow, pageSize);
		// return followers;
		// } catch (Exception e) {
		// throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
		// "無法獲取數據");
		// }
	}

}
