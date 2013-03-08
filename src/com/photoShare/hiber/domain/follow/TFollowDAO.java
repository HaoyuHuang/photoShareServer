package com.photoShare.hiber.domain.follow;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.photoShare.hiber.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * TFollow entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.photoShare.hiber.domain.follow.TFollow
 * @author MyEclipse Persistence Tools
 */

public class TFollowDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TFollowDAO.class);

	// property constants

	public void save(TFollow transientInstance) {
		log.debug("saving TFollow instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TFollow persistentInstance) {
		log.debug("deleting TFollow instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TFollow findById(java.io.Serializable id) {
		log.debug("getting TFollow instance with id: " + id);
		try {
			TFollow instance = (TFollow) getSession().get(
					"com.photoShare.hiber.domain.follow.TFollow", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TFollow instance) {
		log.debug("finding TFollow instance by example");
		try {
			List results = getSession().createCriteria(
					"com.photoShare.hiber.domain.follow.TFollow").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TFollow instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TFollow as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TFollow instances");
		try {
			String queryString = "from TFollow";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TFollow merge(TFollow detachedInstance) {
		log.debug("merging TFollow instance");
		try {
			TFollow result = (TFollow) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TFollow instance) {
		log.debug("attaching dirty TFollow instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TFollow instance) {
		log.debug("attaching clean TFollow instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}