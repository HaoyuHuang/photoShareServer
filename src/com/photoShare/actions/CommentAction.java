package com.photoShare.actions;

import java.net.URLDecoder;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.Comment;
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
		System.out.println("Put Comment");
		try {
			if (comment != null) {
				String content = comment.getContent();
				content = URLDecoder.decode(content, "utf-8");
				System.out.println(content);
				int uid = comment.getUid();
				int pid = comment.getPid();
				comment = iCommentService.putComments(content, uid, pid);
			}
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
