package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.ILinkManDao;
import com.hlz.crm.domain.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
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
     * 根据条件查询联系人
     *
     * @param criteria
     * @return List<CstLinkman>
     */
    @Override
    public List<CstLinkman> findAll(DetachedCriteria criteria) {
        return (List<CstLinkman>) hibernateTemplate.findByCriteria(criteria);
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
