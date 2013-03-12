/**
 * 
 */
package com.photoShare.request.service;

import java.io.Serializable;
import java.util.List;

import com.photoShare.beans.FollowInfo;
import com.photoShare.beans.UserInfo;
import com.photoShare.hiber.domain.follow.TFollow;
import com.photoShare.hiber.domain.user.TUser;

/**
 * @author Administrator
 * 
 */
public interface IFollowService {

	public List<TUser> getFollowList(long[] id, int pageNow, int pageSize);

	public List<UserInfo> getFollowerList(Serializable id, int pageNow,
			int pageSize);

	public List<UserInfo> getFollowingList(Serializable id, int pageNow,
			int pageSize);

	/**
	 * ����
	 * 
	 * @param follower
	 *            �����¼�
	 * */
	public FollowInfo startFollowing(java.io.Serializable userId,
			java.io.Serializable followId);

	/**
	 * ȡ������
	 * 
	 * @param �����¼�
	 * */
	@Deprecated
	public TFollow cacelFollowing(java.io.Serializable userId,
			java.io.Serializable followId);
}
