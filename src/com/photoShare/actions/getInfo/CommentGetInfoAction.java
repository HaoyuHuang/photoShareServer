package com.photoShare.actions.getInfo;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.Comment;
import com.photoShare.beans.factory.BeansFactory;
import com.photoShare.hiber.domain.comments.TComment;
import com.photoShare.request.service.ICommentService;

public class CommentGetInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329821843694905451L;

	private Comment comment;
	private ICommentService iCommentService;
	private List<Comment> comments;

	@Override
	public String execute() throws Exception {
		try {
			int pageNow = comment.getCurrentPage();
			int pageSize = comment.getDemandPage();
			int pid = comment.getPid();

			comments = iCommentService
					.getComments(pid, 0, 10);
			// BeansFactory factory = new BeansFactory();
			// comments = new ArrayList<Comment>();
			// for (TComment rsp : rspComments) {
			// comments.add(factory.convertBean(rsp));
			// }
		} catch (Exception e) {
			throw e;
		}

		return SUCCESS;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public void setiCommentService(ICommentService iCommentService) {
		this.iCommentService = iCommentService;
	}

}
