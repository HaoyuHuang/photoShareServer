package com.photoShare.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.Comment;
import com.photoShare.hiber.domain.comments.TComment;
import com.photoShare.hiber.domain.photo.TPhotoDAO;
import com.photoShare.hiber.domain.user.TUserDAO;
import com.photoShare.request.service.ICommentService;
import com.photoShare.request.service.impl.CommentService;

public class CommentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4635277343200281523L;

	private Comment comment;
	private ICommentService iCommentService;

	@Override
	public String execute() throws Exception {
		try {
			// String content = comment.getContent();
			// int uid = comment.getUid();
			// int pid = comment.getPid();
			CommentService iCommentService = new CommentService();
			iCommentService.setPhotoDAO(new TPhotoDAO());
			iCommentService.setUserDAO(new TUserDAO());
			iCommentService.putComments("qwe", 3, 16);

			// BeansFactory factory = BeansFactory.Instance();
			// comment = factory.convertBean(rspComment);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public void setiCommentService(ICommentService iCommentService) {
		this.iCommentService = iCommentService;
	}

}
