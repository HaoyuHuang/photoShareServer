/**
 * 
 */
package com.photoShare.request.service;

import java.util.List;

import com.photoShare.beans.Comment;
import com.photoShare.hiber.domain.comments.TComment;

/**
 * @author Administrator
 * 
 */
public interface ICommentService {

	/**
	 * ��������
	 * 
	 * @param ����
	 * */
	public Comment putComments(String comment, java.io.Serializable userId,
			java.io.Serializable photoId);

	public List<Comment> getComments(java.io.Serializable photoId, int pageNow,
			int pageSize);

	public List<Comment> getCommentsByDatediff(java.io.Serializable photoId, int datediff);

}
