package org.service.organization.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.model.organization.OrgModel;
import org.service.organization.OrgService;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OrgServiceImpl implements OrgService {
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public List<OrgModel> orgList(String parentId) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrgModel.class);
		dc.add(Restrictions.eq("parentId", parentId));
		return hibernateTemplate.findByCriteria(dc);
	}

	public String addOrg(OrgModel org) {
		String orgId = UUID.randomUUID().toString();
		org.setId(orgId);
		hibernateTemplate.saveOrUpdate(org);
		return orgId;
	}
}
