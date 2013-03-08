package com.photoShare.request.service;

/**
 * @author Aron 2012
 * */
import java.io.Serializable;
import java.util.List;

import com.photoShare.hiber.domain.user.TUser;

/**
 * �û�����ӿ�
 * */
public interface IUserService extends IBasicService {

	/**
	 * ����û��Ƿ�Ϸ�
	 * 
	 * @param user
	 *            ��½�û�
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
	 * ��ȡָ���û���Ϣ
	 * 
	 * @param id
	 *            �û�ID
	 * */
	public TUser getUserInfo(java.io.Serializable id);

	public List<TUser> findUserByName(String name, int pageNow, int pageSize);

	public void editUserInfo(TUser user);

	/**
	 * ��ȡ�û��ĸ�������Ŀ
	 * 
	 * @param id
	 *            �û�ID
	 * */
	public int getUserFollowersCount(java.io.Serializable id);

	/**
	 * ��ȡ�û���ϲ������Ƭ��Ŀ
	 * 
	 * @param id
	 *            �û�ID
	 * */
	public int getUserLikesCount(java.io.Serializable id);

	/**
	 * ��ȡ��ȡ�û�������˵���Ŀ
	 * 
	 * @param id
	 *            �û�ID
	 * */
	public int getUserFollowingCount(java.io.Serializable id);

	public boolean isFollowing(Serializable uid, Serializable fid);

}
