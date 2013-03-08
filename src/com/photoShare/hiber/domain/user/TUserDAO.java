package com.photoShare.hiber.domain.user;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.photoShare.hiber.dao.BaseHibernateDAO;
import com.photoShare.server.Server;

/**
 * A data access object (DAO) providing persistence and search support for TUser
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.photoShare.hiber.domain.user.TUser
 * @author MyEclipse Persistence Tools
 */

public class TUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TUserDAO.class);
	// property constants
	public static final String _FLOG_ACCOUNT = "FLogAccount";
	public static final String _FPASSWORD = "FPassword";
	public static final String _FUSER_NAME = "FUserName";
	public static final String _FPHOTO = "FPhoto";
	public static final String _FWEBSITE = "FWebsite";
	public static final String _FBIO = "FBio";
	public static final String _FPHONE_NUMBER = "FPhoneNumber";
	public static final String _FGENDER = "FGender";
	public static final String _FPRIVACY = "FPrivacy";

	public void save(TUser transientInstance) {
		log.debug("saving TUser instance");
		try {
			transientInstance.setFLargePhoto(transientInstance.getFLargePhoto()
					.substring(Server.SERVER_URL.length()));
			transientInstance.setFPhoto(transientInstance.getFPhoto()
					.substring(Server.SERVER_URL.length()));
			transientInstance.setFTinyPhoto(transientInstance.getFTinyPhoto()
					.substring(Server.SERVER_URL.length()));
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUser persistentInstance) {
		log.debug("deleting TUser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUser findById(java.io.Serializable id) {
		log.debug("getting TUser instance with id: " + id);
		try {
			TUser instance = (TUser) getSession().get(
					"com.photoShare.hiber.domain.user.TUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TUser instance) {
		log.debug("finding TUser instance by example");
		try {
			List results = getSession()
					.createCriteria("com.photoShare.hiber.domain.user.TUser")
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
		log.debug("finding TUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFLogAccount(Object FLogAccount) {
		return findByProperty(_FLOG_ACCOUNT, FLogAccount);
	}

	public List findByFPassword(Object FPassword) {
		return findByProperty(_FPASSWORD, FPassword);
	}

	public List findByFUserName(Object FUserName) {
		return findByProperty(_FUSER_NAME, FUserName);
	}

	public List findByFPhoto(Object FPhoto) {
		return findByProperty(_FPHOTO, FPhoto);
	}

	public List findByFWebsite(Object FWebsite) {
		return findByProperty(_FWEBSITE, FWebsite);
	}

	public List findByFBio(Object FBio) {
		return findByProperty(_FBIO, FBio);
	}

	public List findByFPhoneNumber(Object FPhoneNumber) {
		return findByProperty(_FPHONE_NUMBER, FPhoneNumber);
	}

	public List findByFGender(Object FGender) {
		return findByProperty(_FGENDER, FGender);
	}

	public List findByFPrivacy(Object FPrivacy) {
		return findByProperty(_FPRIVACY, FPrivacy);
	}

	public List findAll() {
		log.debug("finding all TUser instances");
		try {
			String queryString = "from TUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUser merge(TUser detachedInstance) {
		log.debug("merging TUser instance");
		try {
			TUser result = (TUser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUser instance) {
		log.debug("attaching dirty TUser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUser instance) {
		log.debug("attaching clean TUser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}