package com.photoShare.request.service;

import java.io.Serializable;
import java.util.List;

import com.photoShare.beans.news.News;

public interface IBaseNewsService {
	public List<News> getMyNews(Serializable uid, Serializable datediff);

	public List<News> getMyFollowingNews(Serializable uid, Serializable datediff);
}
