package com.photoShare.actions.getInfo;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.news.News;
import com.photoShare.request.service.IBaseNewsService;

public class BaseNewsAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2794238143191426049L;
	private int uid;
	private int datediff;
	private IBaseNewsService mNewsService;
	private List<News> news;

	@JSON(serialize = false)
	public String getFollowingNews() {

		try {
			System.out.println(uid);
			news = mNewsService.getMyFollowingNews(uid, datediff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getUserNews() {

		try {
			System.out.println(uid);
			news = mNewsService.getMyNews(uid, datediff);
			System.out.println(news.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public void setmNewsService(IBaseNewsService mNewsService) {
		this.mNewsService = mNewsService;
	}

	@JSON(serialize = false)
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	@JSON(serialize = false)
	public int getDatediff() {
		return datediff;
	}

	public void setDatediff(int datediff) {
		this.datediff = datediff;
	}

}
