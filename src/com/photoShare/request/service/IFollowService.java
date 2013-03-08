/**
 * 
 */
package com.photoShare.request.service;

import java.io.Serializable;
import java.util.List;

import com.photoShare.hiber.domain.follow.TFollow;
import com.photoShare.hiber.domain.user.TUser;

/**
 * @author Administrator
 * 
 */
public interface IFollowService {

	public List<TUser> getFollowList(long[] id, int pageNow, int pageSize);

	public List<TFollow> getFollowerList(Serializable id, int pageNow,
			int pageSize);

	public List<TFollow> getFollowingList(Serializable id, int pageNow,
			int pageSize);

	/**
	 * 跟随
	 * 
	 * @param follower
	 *            跟随事件
	 * */
	public TFollow startFollowing(java.io.Serializable userId,
			java.io.Serializable followId);

	/**
	 * 取消跟随
	 * 
	 * @param 跟随事件
	 * */
	public TFollow cacelFollowing(java.io.Serializable userId,
			java.io.Serializable followId);
}
