package com.hlz.crm.dao;

import com.hlz.crm.domain.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 联系人持久层接口
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
     * 查询总数
     *
     * @param criteria
     * @return
     */
    int findTotalRecords(DetachedCriteria criteria);

    /**
     * 根据条件查询联系人
     * @param criteria
     * @param firstResult 开始行数
     * @param maxResults 返回多少数量
     * @return
     */
    List<CstLinkman> findAll(DetachedCriteria criteria, int firstResult, int maxResults);

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
