package com.hlz.crm.service.impl;

import com.hlz.crm.dao.ILinkManDao;
import com.hlz.crm.domain.CstLinkman;
import com.hlz.crm.service.ILinkManService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henryhlz
 */
@Service
public class LinkManServiceImpl implements ILinkManService {
    @Autowired
    private ILinkManDao linkManDao;

    /**
     * 添加联系人
     *
     * @param linkman
     */
    @Override
    public void addLinkMan(CstLinkman linkman) {
        linkManDao.saveLinkMan(linkman);
    }

    /**
     * 编辑联系人
     *
     * @param linkman
     */
    @Override
    public void editLinkMan(CstLinkman linkman) {
        linkManDao.updateLinkMan(linkman);
    }

    /**
     * 根据条件查询联系人
     *
     * @param criteria
     * @return List<CstLinkman>
     */
    @Override
    public List<CstLinkman> findAllLinkMan(DetachedCriteria criteria) {
        return linkManDao.findAll(criteria);
    }

    /**
     * 删除联系人
     *
     * @param lkmId
     */
    @Override
    public void deleteLinkMan(long lkmId) {
        linkManDao.delLinkMan(lkmId);
    }

    /**
     * 查询单个联系人
     *
     * @param lkmId
     */
    @Override
    public CstLinkman findById(long lkmId) {
        return linkManDao.findById(lkmId);
    }
}
