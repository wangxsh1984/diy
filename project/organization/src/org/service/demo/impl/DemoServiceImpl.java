package org.service.demo.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.model.demo.DemoModel;
import org.service.demo.DemoService;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DemoServiceImpl implements DemoService {
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public List<DemoModel> searchDemo() {
		return hibernateTemplate.find("from DemoModel");
	}
}
