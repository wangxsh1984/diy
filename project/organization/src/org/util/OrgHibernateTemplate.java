package org.util;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OrgHibernateTemplate<T> {

	private HibernateTemplate hibernateTemplate;

	public OrgHibernateTemplate(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public List<T> find(String hql) {
		return hibernateTemplate.find(hql);
	}

	public List<T> findByCriteria(DetachedCriteria criteria) {
		return hibernateTemplate.findByCriteria(criteria);
	}

}
