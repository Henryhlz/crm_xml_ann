package com.hlz.crm.dao;

import com.hlz.crm.domain.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author Henryhlz
 */
public interface ILinkManDao {
    /**
     * 添加联系人
     *
     * @param linkman
     */
    void saveLinkMan(CstLinkman linkman);

    /**
     * 编辑联系人
     *
     * @param linkman
     */
    void updateLinkMan(CstLinkman linkman);

    /**
     * 根据条件查询联系人
     *
     * @param criteria
     * @return List<CstLinkman>
     */
    List<CstLinkman> findAll(DetachedCriteria criteria);

    /**
     * 删除联系人
     *
     * @param lkmId
     */
    void delLinkMan(long lkmId);

    /**
     * 查询单个联系人
     *
     * @param lkmId
     */
    CstLinkman findById(long lkmId);
}
