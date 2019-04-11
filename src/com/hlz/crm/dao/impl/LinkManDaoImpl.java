package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.ILinkManDao;
import com.hlz.crm.domain.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 联系人持久层实现类
 * @author Henryhlz
 */
@Repository
public class LinkManDaoImpl implements ILinkManDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 添加联系人
     *
     * @param linkman
     */
    @Override
    public void saveLinkMan(CstLinkman linkman) {
        hibernateTemplate.save(linkman);
    }

    /**
     * 编辑联系人
     *
     * @param linkman
     */
    @Override
    public void updateLinkMan(CstLinkman linkman) {
        hibernateTemplate.update(linkman);
    }

    /**
     * 查询总数
     *
     * @param criteria
     * @return
     */
    @Override
    public int findTotalRecords(DetachedCriteria criteria) {
        criteria.setProjection(Projections.count("lkmId"));
        List<Long> longs = (List<Long>) hibernateTemplate.findByCriteria(criteria);
        return longs.isEmpty() ? 0 : longs.get(0).intValue();
    }

    /**
     * 根据条件查询联系人
     *
     * @param criteria
     * @param firstResult 开始行数
     * @param maxResults  返回多少数量
     * @return
     */
    @Override
    public List<CstLinkman> findAll(DetachedCriteria criteria, int firstResult, int maxResults) {
        criteria.setProjection(null);
        return (List<CstLinkman>) hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
    }


    /**
     * 删除联系人
     *
     * @param lkmId
     */
    @Override
    public void delLinkMan(long lkmId) {
        hibernateTemplate.delete(findById(lkmId));
    }

    /**
     * 查询单个联系人
     *
     * @param lkmId
     */
    @Override
    public CstLinkman findById(long lkmId) {
        return hibernateTemplate.load(CstLinkman.class, lkmId);
    }
}
