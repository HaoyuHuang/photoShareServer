package com.photoShare.request.service.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.photoShare.beans.news.EventType;
import com.photoShare.beans.news.NewsBean;
import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.request.service.INewsService;

public class NewsService extends BasicService implements INewsService {

	public List<NewsBean> getMyNews(Serializable id) {
		Object[] params = new Object[] { id };
		int[] types = new int[] { Types.INTEGER };
		String proc = "{call GET_MY_NEWS(?)}";
		List<NewsBean> news = new ArrayList<NewsBean>();
		try {
			ResultSet result = executeProcedure(proc, params, types);

			ArrayList<PhotoBean> popular = new ArrayList<PhotoBean>();
			String popularName = "";
			while (result.next()) {

				int newsId = result.getInt(1);
				int pid = result.getInt(2);
				String uname = result.getString(3);
				String time = result.getDate(4).toString();
				String uTinyHead = result.getString(5);
				String uHead = result.getString(6);
				String uLargeHead = result.getString(7);
				String pTinyUrl = result.getString(8);
				String pUrl = result.getString(9);
				String pLargeUrl = result.getString(10);
				String eContent = result.getString(12);

				switch (result.getInt(11)) {
				// like:
				case 1:

					PhotoBean uPhoto = new PhotoBean.PhotoBeanBuidler()
							.Uid(newsId).UserName(uname).TinyUrl(uTinyHead)
							.MiddleUrl(uHead).LargeUrl(uLargeHead).build();

					PhotoBean photo = new PhotoBean.PhotoBeanBuidler().Pid(pid)
							.TinyUrl(pTinyUrl).MiddleUrl(pUrl)
							.LargeUrl(pLargeUrl).build();
					ArrayList<PhotoBean> photos = new ArrayList<PhotoBean>();
					photos.add(uPhoto);
					photos.add(photo);

					NewsBean like = new NewsBean.NewsBeanBuilder()
							.UserId(newsId).UserName(uname).EventTime(time)
							.EventType(EventType.Switch(2)).Photos(photos)
							.build();
					news.add(like);
					break;
				case 2:
					// follower

					PhotoBean fPhoto = new PhotoBean.PhotoBeanBuidler()
							.TinyUrl(uTinyHead).MiddleUrl(uHead)
							.LargeUrl(uLargeHead).build();
					ArrayList<PhotoBean> fPhotos = new ArrayList<PhotoBean>();
					fPhotos.add(fPhoto);

					NewsBean follower = new NewsBean.NewsBeanBuilder()
							.UserId(newsId).UserName(uname).EventTime(time)
							.EventType(EventType.Switch(1)).Photos(fPhotos)
							.build();
					news.add(follower);
					break;
				case 3:
					// popular
					popularName = uname;
					PhotoBean pPhoto = new PhotoBean.PhotoBeanBuidler()
							.Pid(pid).TinyUrl(uTinyHead).MiddleUrl(uHead)
							.LargeUrl(uLargeHead).build();
					popular.add(pPhoto);
					break;
				case 4:
					// comment
					PhotoBean uCphoto = new PhotoBean.PhotoBeanBuidler()
							.Uid(newsId).UserName(uname).TinyUrl(uTinyHead)
							.MiddleUrl(uHead).LargeUrl(uLargeHead).build();

					ArrayList<PhotoBean> pComments = new ArrayList<PhotoBean>();
					pComments.add(uCphoto);

					NewsBean comment = new NewsBean.NewsBeanBuilder()
							.UserId(newsId).UserName(uname).EventTime(time)
							.EventDesc(eContent).EventType(EventType.Switch(2))
							.Photos(pComments).build();
					news.add(comment);
				}

				NewsBean pNews = new NewsBean.NewsBeanBuilder()
						.EventType(EventType.Switch(3)).Photos(popular)
						.UserId(Integer.valueOf(id.toString()))
						.UserName(popularName).build();
				news.add(pNews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return news;
	}

	public List<NewsBean> getFollowerNews(Serializable id) {

		Object[] params = new Object[] { id };
		int[] types = new int[] { Types.INTEGER };
		String proc = "{call GET_MY_NEWS(?)}";
		System.out.println("getFollowerNews");
		List<NewsBean> news = new ArrayList<NewsBean>();
		try {
			ResultSet result = executeProcedure(proc, params, types);
			ArrayList<PhotoBean> popular = new ArrayList<PhotoBean>();
			String popularName = "";
			while (result.next()) {

				int newsId = result.getInt(1);
				int pid = result.getInt(2);
				String uname = result.getString(3);
				String time = result.getDate(4).toString();
				String uTinyHead = result.getString(5);
				String uHead = result.getString(6);
				String uLargeHead = result.getString(7);
				String pTinyUrl = result.getString(8);
				String pUrl = result.getString(9);
				String pLargeUrl = result.getString(10);

				switch (result.getInt(11)) {
				// like:
				case 1:

					PhotoBean uPhoto = new PhotoBean.PhotoBeanBuidler()
							.Uid(newsId).UserName(uname).TinyUrl(uTinyHead)
							.MiddleUrl(uHead).LargeUrl(uLargeHead).build();

					PhotoBean photo = new PhotoBean.PhotoBeanBuidler().Pid(pid)
							.TinyUrl(pTinyUrl).MiddleUrl(pUrl)
							.LargeUrl(pLargeUrl).build();
					ArrayList<PhotoBean> photos = new ArrayList<PhotoBean>();
					photos.add(uPhoto);
					photos.add(photo);

					NewsBean like = new NewsBean.NewsBeanBuilder()
							.UserId(newsId).UserName(uname).EventTime(time)
							.EventType(EventType.Switch(2)).Photos(photos)
							.build();
					news.add(like);
					break;
				case 2:

					break;
				case 3:
					// popular
					popularName = uname;
					PhotoBean pPhoto = new PhotoBean.PhotoBeanBuidler()
							.Pid(pid).TinyUrl(uTinyHead).MiddleUrl(uHead)
							.LargeUrl(uLargeHead).build();
					popular.add(pPhoto);
					break;
				case 4:

				}

				NewsBean pNews = new NewsBean.NewsBeanBuilder()
						.EventType(EventType.Switch(3)).Photos(popular)
						.UserId(Integer.valueOf(id.toString()))
						.UserName(popularName).build();
				news.add(pNews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
