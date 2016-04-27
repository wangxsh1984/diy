package org.service.demo.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.model.demo.DemoModel;
import org.service.demo.DemoService;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DemoServiceImpl<T> implements DemoService {
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public List<DemoModel> searchDemo() {
		List<DemoModel> demoList = hibernateTemplate.find("from DemoModel");
		for (DemoModel dm : demoList) {
			dm.setUsername(dm.getUsername() + "1");
		}
		return demoList;
	}

	public List<DemoModel> searchByQBC() {
		DetachedCriteria dc = DetachedCriteria.forClass(DemoModel.class);
		dc.add(Restrictions.eq("username", "222"));
		return hibernateTemplate.findByCriteria(dc);
	}
}
