package com.hlz.crm.dao;

import com.hlz.crm.domain.CstCustomer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 客户持久层接口
 *
 * @author Henryhlz
 */
public interface ICustomerDao {

    /**
     * 按条件查询记录数
     *
     * @param criteria
     * @return
     */
    int findTotalRecords(DetachedCriteria criteria);

    /**
     * 保存客户
     * @param customer
     */
    void saveCustomer(CstCustomer customer);

    /**
     * 查询所有客户
     * @param criteria
     */
    List<CstCustomer> findAllCustomer(DetachedCriteria criteria, int firstResult, int maxResults );

    /**
     * 删除客户
     * @param custId
     */
    void removeCustomer(long custId);

    /**
     * 编辑客户
     *
     * @param customer
     */
    void editCustomer(CstCustomer customer);

    /**
     * 查询单个客户
     *
     * @param custId
     */
    CstCustomer findById(long custId);

    /**
     * 投影查询客户列表
     *
     * @return
     */
    List<CstCustomer> findAll();
}
