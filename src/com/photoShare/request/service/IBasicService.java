package com.photoShare.request.service;

import java.util.List;

public interface IBasicService {

	public List<?> executeQuery(String hql, Object[] params);

	public List<?> executeProcedure(String hql, Object[] params);

	public List<?> executeQueryByPage(String hql, Object[] params, int pageNow,
			int pageSize);

	public void save(Object obj);

	public void executeUpdate(String hql, Object[] params);

	public Object uniqueQuery(String hql, Object[] params);

	public int queryPageCount(String hql, Object[] params, int pageSize);

	public void delete(Object obj);

}
