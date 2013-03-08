package com.photoShare.request.service;

import java.io.Serializable;
import java.util.List;

import com.photoShare.beans.news.NewsBean;

public interface INewsService {
	public List<NewsBean> getMyNews(Serializable id);

	public List<NewsBean> getFollowerNews(Serializable id);
}
