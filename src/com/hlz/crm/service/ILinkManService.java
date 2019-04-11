package com.hlz.crm.service;

import com.hlz.crm.domain.CstLinkman;
import com.hlz.framework.commons.Page;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 联系人业务层接口
 *
 * @author Henryhlz
 */
public interface ILinkManService {
    /**
     * 添加联系人
     *
     * @param linkman
     */
    void addLinkMan(CstLinkman linkman);

    /**
     * 编辑联系人
     *
     * @param linkman
     */
    void editLinkMan(CstLinkman linkman);

    /**
     * 根据条件查询联系人
     *
     * @param criteria
     * @return List<CstLinkman>
     * @return num
     */
    Page findAllLinkMan(DetachedCriteria criteria, int num);

    /**
     * 删除联系人
     *
     * @param lkmId
     */
    void deleteLinkMan(long lkmId);

    /**
     * 查询单个联系人
     *
     * @param lkmId
     */
    CstLinkman findById(long lkmId);
}
