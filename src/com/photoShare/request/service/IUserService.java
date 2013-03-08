package com.photoShare.request.service;

/**
 * @author Aron 2012
 * */
import java.io.Serializable;
import java.util.List;

import com.photoShare.hiber.domain.user.TUser;

/**
 * 用户服务接口
 * */
public interface IUserService extends IBasicService {

	/**
	 * 检查用户是否合法
	 * 
	 * @param user
	 *            登陆用户
	 * */
	public boolean check(TUser user);

	public TUser signin(TUser user);

	public void register(TUser user);

	/**
	 * 
	 * 
	 * */
	public int getPageCount(int pageSize);

	/**
	 * 获取指定用户信息
	 * 
	 * @param id
	 *            用户ID
	 * */
	public TUser getUserInfo(java.io.Serializable id);

	public List<TUser> findUserByName(String name, int pageNow, int pageSize);

	public void editUserInfo(TUser user);

	/**
	 * 获取用户的跟随者数目
	 * 
	 * @param id
	 *            用户ID
	 * */
	public int getUserFollowersCount(java.io.Serializable id);

	/**
	 * 获取用户的喜欢的照片数目
	 * 
	 * @param id
	 *            用户ID
	 * */
	public int getUserLikesCount(java.io.Serializable id);

	/**
	 * 获取获取用户跟随的人的数目
	 * 
	 * @param id
	 *            用户ID
	 * */
	public int getUserFollowingCount(java.io.Serializable id);

	public boolean isFollowing(Serializable uid, Serializable fid);

}
