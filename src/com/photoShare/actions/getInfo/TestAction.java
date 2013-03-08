package com.photoShare.actions.getInfo;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.hiber.domain.comments.TComment;
import com.photoShare.request.service.ICommentService;

public class TestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4339810790447919001L;

	private ICommentService iCommentService;

	@Override
	public String execute() throws Exception {

		try {
			String content = "testc";
			int uid = 2;
			int pid = 16;
			TComment rspComment = iCommentService
					.putComments(content, uid, pid);
		} catch (Exception e) {
			throw e;
		}

		return SUCCESS;
	}

	public ICommentService getiCommentService() {
		return iCommentService;
	}

	public void setiCommentService(ICommentService iCommentService) {
		this.iCommentService = iCommentService;
	}

}
