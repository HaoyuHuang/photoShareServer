package com.photoShare.request.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.photoShare.exception.NetworkError;
import com.photoShare.exception.TransactionError;
import com.photoShare.hiber.domain.follow.TFollow;
import com.photoShare.hiber.domain.user.TUser;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.IUserService;
import com.photoShare.util.Format;

public class UserService extends BasicService implements IUserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.photoShare.request.service.IUserService#check(com.photoShare.hiber
	 * .domain.user.TUser)
	 * 
	 * 写一个算法用来给用户推荐用户名
	 */
	public boolean check(TUser user) {
		// TODO Auto-generated method stub
		String hql = "from com.photoShare.hiber.domain.user.TUser "
				+ "where FUserName=? and FPassword=? ";
		String[] params = { user.getFUserName(), user.getFPassword() };
		try {
			TUser legalUser = (TUser) uniqueQuery(hql, params);
			if (legalUser == null) {
				return false;
			}
		} catch (TransactionError e) {
			throw e;
		}
		return true;
	}

	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TUser ";
		int pageCount = this.queryPageCount(hql, null, pageSize);
		return pageCount;

	}

	public int getUserFollowersCount(Serializable id) {
		// TODO Auto-generated method stub
		String hql = "select count(*) "
				+ "from com.photoShare.hiber.domain.follow.TFollow "
				+ "where TUserByFMyId.FId = ?";
		Integer[] params = { Integer.valueOf(id.toString()) };
		try {
			Integer followerCount = (Integer) uniqueQuery(hql, params);
			return followerCount;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		} finally {

		}
	}

	public int getUserFollowingCount(Serializable id) {
		String hql = "select count(*)"
				+ "from com.photoShare.hiber.domain.follow.TFollow "
				+ "where TUserByFFollowId.FId = ? ";
		Integer[] params = { Integer.valueOf(id.toString()) };
		try {
			Integer followingCount = (Integer) uniqueQuery(hql, params);
			return followingCount;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

	public TUser getUserInfo(Serializable id) {
		String hql = "from com.photoShare.hiber.domain.user.TUser "
				+ "where FId = ?";
		Integer[] params = { Integer.valueOf(id.toString()) };
		try {
			TUser user = (TUser) uniqueQuery(hql, params);
			if (user == null) {
				throw new TransactionError(
						TransactionError.ERROR_CODE_ILLEGAL_PARAMETER);
			}
			return user;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

	public int getUserLikesCount(Serializable id) {
		// TODO Auto-generated method stub
		String hql = "select count(*)" + " from TLike " + "where TUser.FId = ?";
		Integer[] params = { Integer.valueOf(id.toString()) };
		try {
			Integer likesCount = (Integer) uniqueQuery(hql, params);
			return likesCount;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

	public void register(TUser user) {
		// TODO Auto-generated method stub
		try {
			this.save(user);
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_SIGN_UP, "注册失败", "注册失败");
		}
	}

	public void editUserInfo(TUser user) {
		System.out.println("editUser");
		String hql = "from TUser where FID=" + user.getFId();
		List<String> str = new ArrayList<String>();

		if (!Format.StringisNull(user.getFBio())) {
			hql += " and FBio=?";
			str.add(user.getFBio());
		}
		if (!Format.StringisNull(user.getFPhoneNumber())) {
			hql += " and FPhoneNumber=? ";
			str.add(user.getFPhoneNumber());
		}
		if (!Format.StringisNull(user.getFUserName())) {
			hql += " and FUserName=? ";
			str.add(user.getFUserName());
		}
		if (!Format.StringisNull(user.getFWebsite())) {
			hql += " and FWebsite=? ";
			str.add(user.getFWebsite());
		}
		if (!Format.StringisNull(user.getFBirthday().toString())) {
			hql += " and FBirthday=? ";
			str.add(user.getFBirthday().toString());
		}
		if (!Format.StringisNull(user.getFMail())) {
			hql += " and FMail=? ";
			str.add(user.getFMail());
		}
		hql += "and FPrivacy=? ";
		str.add(user.getFPrivacy() + "");
		try {
			executeUpdate(hql, str.toArray());
		} catch (Exception e) {
			throw new NetworkError(NetworkError.ERROR_EDIT_PROFILE, "修改失败",
					"发布失败");
		}
	}

	public boolean isFollowing(Serializable uid, Serializable fid) {
		TUserDAO dao = new TUserDAO();
		TUser user = dao.findById(uid);
		@SuppressWarnings("unchecked")
		Set<TFollow> follows = user.getTFollowsForFMyId();
		for (TFollow follow : follows) {
			if (follow.getFId() == fid)
				return true;
		}
		return false;
	}

	public TUser signin(TUser user) {
		String hql = "from com.photoShare.hiber.domain.user.TUser "
				+ "where FUserName=? and FPassword=? ";
		String[] params = { user.getFUserName(), user.getFPassword() };
		try {
			TUser legalUser = (TUser) uniqueQuery(hql, params);
			if (legalUser == null) {
				throw new TransactionError(
						TransactionError.ERROR_CODE_LOG_ERROR);
			}
			if (legalUser.getFPassword().equals(user.getFPassword())) {
				return legalUser;
			}
		} catch (RuntimeException e) {
			throw e;
		}
		throw new NetworkError(NetworkError.ERROR_SIGN_IN, "登陆失败", "登陆失败");
	}

	@Override
	public List<TUser> findUserByName(String name, int pageNow, int pageSize) {
		String hql = "from com.photoShare.hiber.domain.user.TUser "
				+ "where FUserName = ?";
		String[] params = { name };
		try {
			@SuppressWarnings("unchecked")
			List<TUser> users = (List<TUser>) executeQueryByPage(hql, params,
					pageNow, pageSize);
			if (users == null) {
				throw new TransactionError(
						TransactionError.ERROR_CODE_LOG_ERROR);
			}
			return users;
		} catch (RuntimeException e) {
			throw new NetworkError(NetworkError.ERROR_FIND_FRIENDS, "查找失败",
					"查找失败");
		}
	}
}
