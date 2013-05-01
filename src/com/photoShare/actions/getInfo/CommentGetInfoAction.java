package com.photoShare.actions.getInfo;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.Comment;
import com.photoShare.request.service.ICommentService;

public class CommentGetInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329821843694905451L;

	private Comment comment;
	private ICommentService iCommentService;
	private List<Comment> comments;
	private int datediff;

	@JSON(serialize = false)
	public String getCommentInfo() {
		try {
			System.out.println("getCommentInfo");
			int pageNow = comment.getCurrentPage();
			int pageSize = comment.getDemandPage();
			int pid = comment.getPid();
			System.out.println(pid);
			comments = iCommentService.getComments(pid, 1, 10);
			// BeansFactory factory = new BeansFactory();
			// comments = new ArrayList<Comment>();
			// for (TComment rsp : rspComments) {
			// comments.add(factory.convertBean(rsp));
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getCommentInfoByDatediff() {
		System.out.println("getCommentInfoByDatediff");
		try {
			int pid = comment.getPid();
			System.out.println(pid + " " + datediff);
			comments = iCommentService.getCommentsByDatediff(pid, datediff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@JSON(serialize = false)
	public int getDatediff() {
		return datediff;
	}

	public void setDatediff(int datediff) {
		this.datediff = datediff;
	}

}
