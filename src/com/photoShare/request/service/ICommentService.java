/**
 * 
 */
package com.photoShare.request.service;

import java.util.List;

import com.photoShare.hiber.domain.comments.TComment;

/**
 * @author Administrator
 * 
 */
public interface ICommentService {

	/**
	 * Ìí¼ÓÆÀÂÛ
	 * 
	 * @param ÆÀÂÛ
	 * */
	public TComment putComments(String comment, java.io.Serializable userId,
			java.io.Serializable photoId);

	public List<TComment> getComments(java.io.Serializable photoId,
			int pageNow, int pageSize);

}
