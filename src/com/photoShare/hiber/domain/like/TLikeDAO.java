package com.photoShare.hiber.domain.like;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.photoShare.hiber.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for TLike
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.photoShare.hiber.domain.like.TLike
 * @author MyEclipse Persistence Tools
 */

public class TLikeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TLikeDAO.class);
	// property constants
	public static final String _FLIKE = "FLike";

	public void save(TLike transientInstance) {
		log.debug("saving TLike instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TLike persistentInstance) {
		log.debug("deleting TLike instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TLike findById(java.io.Serializable id) {
		log.debug("getting TLike instance with id: " + id);
		try {
			TLike instance = (TLike) getSession().get(
					"com.photoShare.hiber.domain.like.TLike", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TLike instance) {
		log.debug("finding TLike instance by example");
		try {
			List results = getSession()
					.createCriteria("com.photoShare.hiber.domain.like.TLike")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TLike instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TLike as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFLike(Object FLike) {
		return findByProperty(_FLIKE, FLike);
	}

	public List findAll() {
		log.debug("finding all TLike instances");
		try {
			String queryString = "from TLike";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TLike merge(TLike detachedInstance) {
		log.debug("merging TLike instance");
		try {
			TLike result = (TLike) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TLike instance) {
		log.debug("attaching dirty TLike instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TLike instance) {
		log.debug("attaching clean TLike instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}