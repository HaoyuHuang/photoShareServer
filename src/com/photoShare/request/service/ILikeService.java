/**
 * 
 */
package com.photoShare.request.service;

import java.util.List;

import com.photoShare.hiber.domain.like.TLike;

/**
 * @author Administrator
 * 
 */
public interface ILikeService {

	/**
	 * 添加喜欢
	 * 
	 * @param like
	 *            喜爱事件
	 * */
	public TLike Like(java.io.Serializable userId, java.io.Serializable photoId);

	/**
	 * 取消喜欢
	 * 
	 * @param like
	 *            喜爱事件
	 * */
	public TLike Dislike(java.io.Serializable userId,
			java.io.Serializable photoId);

	/**
	 * @param id
	 * @return
	 */
	public List<TLike> getLikesInfo(java.io.Serializable id, int pageNow,
			int pageSize);

	public boolean exist(java.io.Serializable uid, java.io.Serializable pid);

	public boolean isLike(java.io.Serializable uid, java.io.Serializable pid);

}
