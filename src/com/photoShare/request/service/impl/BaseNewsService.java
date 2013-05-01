package com.photoShare.request.service.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.photoShare.beans.news.News;
import com.photoShare.beans.news.NewsType;
import com.photoShare.exception.NetworkError;
import com.photoShare.request.service.IBaseNewsService;
import com.photoShare.server.Server;

public class BaseNewsService extends BasicService implements IBaseNewsService {

	@Override
	public List<News> getMyNews(Serializable uid, Serializable datediff) {
		String proc = "{call GET_USER_NEWS(?,?)}";
		Object[] params = new Object[] { uid, datediff };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER };

		try {
			ResultSet rs = executeProcedure(proc, params, types);
			List<News> news = new ArrayList<News>();
			while (rs.next()) {
				News n = new News();
				n.setUid(rs.getInt(1));
				n.setNewsType(NewsType.SWITCH(rs.getInt(2)));
				n.setEventUserId(rs.getInt(3));
				n.setEventId(rs.getInt(4));
				n.setEventDescription(rs.getString(5));
				n.setUserName(rs.getString(6));
				n.setEventUserName(rs.getString(7));
				n.setTinyHeadUrl(Server.SERVER_URL + rs.getString(8));
				n.setEventKeyId(rs.getInt(9));
				news.add(n);
			}
			return news;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

	@Override
	public List<News> getMyFollowingNews(Serializable uid, Serializable datediff) {
		String proc = "{call GET_USER_FOLLOWER_NEWS(?,?)}";
		Object[] params = new Object[] { uid, datediff };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER };

		try {
			ResultSet rs = executeProcedure(proc, params, types);
			List<News> news = new ArrayList<News>();
			while (rs.next()) {
				News n = new News();
				n.setUid(rs.getInt(1));
				n.setNewsType(NewsType.SWITCH(rs.getInt(2)));
				n.setEventUserId(rs.getInt(3));
				n.setEventId(rs.getInt(4));
				n.setEventDescription(rs.getString(5));
				n.setUserName(rs.getString(6));
				n.setEventUserName(rs.getString(7));
				n.setTinyHeadUrl(Server.SERVER_URL + rs.getString(8));
				n.setEventKeyId(rs.getInt(9));
				news.add(n);
			}
			return news;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkError(NetworkError.ERROR_REFRESH_DATA, "無法獲取數據",
					"無法獲取數據");
		}
	}

}
