package org.service.goods.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.model.goods.GoodsModel;
import org.service.goods.GoodsService;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class GoodsServiceImpl implements GoodsService {
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public List<GoodsModel> findGoods(Map<String, Object> condition) {
		DetachedCriteria dc = DetachedCriteria.forClass(GoodsModel.class);
		Set<String> keySet = condition.keySet();
		for (String key : keySet) {
			dc.add(Restrictions.eq(key, condition.get(key)));
		}
		return hibernateTemplate.findByCriteria(dc);
	}

	public void addOrUpdateGoods(Map goods) {
		GoodsModel goodsModel = new GoodsModel();
		goodsModel.setGoodsName((String) goods.get("goodsName"));
		goodsModel.setGoodsType((String) goods.get("goodsType"));
		goodsModel.setGoodsAmount((String) goods.get("goodsAmount"));
		goodsModel.setGoodsUnit((String) goods.get("goodsUnit"));
		goodsModel.setGoodsRemark((String) goods.get("goodsRemark"));
		hibernateTemplate.saveOrUpdate(goodsModel);
	}
}
