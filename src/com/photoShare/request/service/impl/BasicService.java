package com.photoShare.request.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.photoShare.beans.photos.PhotoBean;
import com.photoShare.hiber.dao.BaseHibernateDAO;
import com.photoShare.request.service.IBasicService;
import com.photoShare.server.Server;

@Transactional
public class BasicService implements IBasicService {

	private SessionFactory sessionFactory;
	private final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	public Object uniqueQuery(String hql, Object[] params) {
		// TODO Auto-generated method stub
		Session session = null;
		List<?> list = null;
		Object obj = null;
		try {
			session = getSession();
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			list = query.list();
			if (list != null && !list.isEmpty()) {
				obj = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				closeSession();
			}
		}
		return obj;
	}

	public List<?> executeQuery(String hql, Object[] params) {
		// TODO Auto-generated method stub
		Session session = null;
		List<?> list = null;
		try {
			session = getSession();
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					System.out.println(params[i]);
					query.setParameter(i, Integer.valueOf(params[i].toString()));
				}
			}
			list = query.list();

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				closeSession();
			}
		}
		return list;
	}

	public List<?> executeQueryByPage(String hql, Object[] params, int pageNow,
			int pageSize) {
		// TODO Auto-generated method stub
		Session session = null;
		List list = new ArrayList();
		try {
			session = getSession();
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			query.setFirstResult((pageNow) * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				closeSession();
			}
		}
		return list;
	}

	public void executeUpdate(String hql, Object[] params) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction t = null;
		try {
			session = getSession();
			t = session.getTransaction();
			t.begin();
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			query.executeUpdate();
			t.commit();

		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				closeSession();
			}
		}
	}

	public int queryPageCount(String hql, Object[] params, int pageSize) {
		// TODO Auto-generated method stub
		Long rowCount = (Long) this.uniqueQuery(hql, params);
		return (rowCount.intValue() - 1) / pageSize + 1;
	}

	public void save(Object obj) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction t = null;
		try {
			session = getSession();
			t = session.getTransaction();
			t.begin();
			session.save(obj);
			t.commit();
			// session.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
			if (t != null)
				t.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				closeSession();
			}
		}
	}

	public void delete(Object obj) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction t = null;
		try {
			session = getSession();
			t = getSession().getTransaction();
			t.begin();
			session.delete(obj);
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				closeSession();
			}
		}
	}

	// public JSONObject parseTransactionError(TransactionError e) {
	// JSONObject error = new JSONObject();
	// error.put(TransactionError.ERROR_CODE, e.getErrorCode());
	// error.put(TransactionError.ERROR_MESSAGE, e.getOrgRuntimeError());
	// return error;
	// }

	// public JSONObject parseJSON(Object pojo) {
	// return JSONObject.fromObject(pojo);
	// }

	/**
	 * Returns the ThreadLocal Session instance. Lazy initialize the
	 * <code>SessionFactory</code> if needed.
	 * 
	 * @return Session
	 * @throws HibernateException
	 */
	public Session getSession() throws HibernateException {
		return BaseHibernateDAO.getSessionFactory().openSession();
	}

	/**
	 * Close the single hibernate session instance.
	 * 
	 * @throws HibernateException
	 */
	public void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);

		if (session != null) {
			session.close();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ResultSet executeProcedure(String proc, Object[] params, int[] types) {
		Session session = null;
		try {
			session = getSession();
			Connection conn = session.connection();
			CallableStatement call = conn.prepareCall(proc);
			for (int i = 0; i < params.length; i++) {
				call.setObject(i + 1, params[i], types[i]);
			}
			return call.executeQuery();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				closeSession();
			}
		}
	}

	public List<?> executeProcedure(String name, Object[] params) {
		Session session = null;
		List<PhotoBean> list = null;
		try {
			session = getSession();
			Connection conn = session.connection();
			try {
				CallableStatement call = conn
						.prepareCall("{call GET_POPULAR_PHOTO(?)}");
				call.setInt(1, 10);
				ResultSet rs = call.executeQuery();
				list = new ArrayList<PhotoBean>();
				while (rs.next()) {
					PhotoBean photo = new PhotoBean.PhotoBeanBuidler()
							.Uid(rs.getInt(1)).UserName(rs.getString(2))
							.Pid(rs.getInt(3))
							.TinyUrl(Server.SERVER_URL + rs.getString(4))
							.MiddleUrl(Server.SERVER_URL + rs.getString(5))
							.LargeUrl(Server.SERVER_URL + rs.getString(6))
							.build();
					list.add(photo);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				closeSession();
			}
		}
		return list;
	}

	public String getServerUrl() {
		return "http://121.229.103.20:8080";
	}
}
