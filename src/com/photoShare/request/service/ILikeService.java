/**
 * 
 */
package com.photoShare.request.service;

import java.util.List;

import com.photoShare.beans.LikeInfo;
import com.photoShare.hiber.domain.like.TLike;

/**
 * @author Administrator
 * 
 */
public interface ILikeService {

	/**
	 * ���ϲ��
	 * 
	 * @param like
	 *            ϲ���¼�
	 * */
	public LikeInfo Like(java.io.Serializable userId,
			java.io.Serializable photoId);

	/**
	 * ȡ��ϲ��
	 * 
	 * @param like
	 *            ϲ���¼�
	 * */
	public TLike Dislike(java.io.Serializable userId,
			java.io.Serializable photoId);

	/**
	 * @param id
	 * @return
	 */
	public List<LikeInfo> getLikesInfo(java.io.Serializable id, int pageNow,
			int pageSize);

	public List<LikeInfo> getLikesInfoByDatediff(java.io.Serializable photoId,
			int datediff);

	public boolean exist(java.io.Serializable uid, java.io.Serializable pid);

	public boolean isLike(java.io.Serializable uid, java.io.Serializable pid);

}
