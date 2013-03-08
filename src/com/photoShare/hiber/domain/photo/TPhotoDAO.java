package com.photoShare.hiber.domain.photo;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.photoShare.hiber.dao.BaseHibernateDAO;
import com.photoShare.server.Server;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPhoto entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.photoShare.hiber.domain.photo.TPhoto
 * @author MyEclipse Persistence Tools
 */

public class TPhotoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TPhotoDAO.class);
	// property constants
	public static final String _FLARGE_SIZE_URL = "FLargeSizeUrl";
	public static final String _FMIDDLE_SIZE_URL = "FMiddleSizeUrl";
	public static final String _FSMALL_SIZE_URL = "FSmallSizeUrl";
	public static final String _FLARGE_SIZE_WIDTH = "FLargeSizeWidth";
	public static final String _FLARGE_SIZE_HEIGHT = "FLargeSizeHeight";
	public static final String _FCAPTION = "FCaption";

	public void save(TPhoto transientInstance) {
		log.debug("saving TPhoto instance");
		try {
			transientInstance.setFLargeSizeUrl(transientInstance
					.getFLargeSizeUrl().substring(Server.SERVER_URL.length()));
			transientInstance.setFMiddleSizeUrl(transientInstance
					.getFMiddleSizeUrl().substring(Server.SERVER_URL.length()));
			transientInstance.setFSmallSizeUrl(transientInstance
					.getFSmallSizeUrl().substring(Server.SERVER_URL.length()));
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TPhoto persistentInstance) {
		log.debug("deleting TPhoto instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TPhoto findById(java.io.Serializable id) {
		log.debug("getting TPhoto instance with id: " + id);
		try {
			TPhoto instance = (TPhoto) getSession().get(
					"com.photoShare.hiber.domain.photo.TPhoto", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPhoto instance) {
		log.debug("finding TPhoto instance by example");
		try {
			List results = getSession()
					.createCriteria("com.photoShare.hiber.domain.photo.TPhoto")
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
		log.debug("finding TPhoto instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TPhoto as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFLargeSizeUrl(Object FLargeSizeUrl) {
		return findByProperty(_FLARGE_SIZE_URL, FLargeSizeUrl);
	}

	public List findByFMiddleSizeUrl(Object FMiddleSizeUrl) {
		return findByProperty(_FMIDDLE_SIZE_URL, FMiddleSizeUrl);
	}

	public List findByFSmallSizeUrl(Object FSmallSizeUrl) {
		return findByProperty(_FSMALL_SIZE_URL, FSmallSizeUrl);
	}

	public List findByFLargeSizeWidth(Object FLargeSizeWidth) {
		return findByProperty(_FLARGE_SIZE_WIDTH, FLargeSizeWidth);
	}

	public List findByFLargeSizeHeight(Object FLargeSizeHeight) {
		return findByProperty(_FLARGE_SIZE_HEIGHT, FLargeSizeHeight);
	}

	public List findByFCaption(Object FCaption) {
		return findByProperty(_FCAPTION, FCaption);
	}

	public List findAll() {
		log.debug("finding all TPhoto instances");
		try {
			String queryString = "from TPhoto";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPhoto merge(TPhoto detachedInstance) {
		log.debug("merging TPhoto instance");
		try {
			TPhoto result = (TPhoto) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPhoto instance) {
		log.debug("attaching dirty TPhoto instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPhoto instance) {
		log.debug("attaching clean TPhoto instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}