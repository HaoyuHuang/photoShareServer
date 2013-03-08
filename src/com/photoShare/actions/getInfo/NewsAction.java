package com.photoShare.actions.getInfo;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.photoShare.beans.UserInfo;
import com.photoShare.beans.news.NewsBean;
import com.photoShare.request.service.INewsService;

public class NewsAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2794238143191426049L;
	private UserInfo userInfo;
	private INewsService mNewsService;
	private List<NewsBean> news;

	@JSON(serialize = false)
	public String getFollowingNews() {

		try {
			int uid = userInfo.getUid();
			System.out.println(uid);
			news = mNewsService.getFollowerNews(uid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getUserNews() {

		try {
			int uid = userInfo.getUid();
			System.out.println(uid);
			news = mNewsService.getMyNews(uid);
			System.out.println(news.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setmNewsService(INewsService mNewsService) {
		this.mNewsService = mNewsService;
	}

	public List<NewsBean> getNews() {
		return news;
	}

	public void setNews(List<NewsBean> news) {
		this.news = news;
	}

}
