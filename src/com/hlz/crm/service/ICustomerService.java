package com.hlz.crm.service;

import com.hlz.crm.domain.BaseDict;
import com.hlz.crm.domain.CstCustomer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 客户业务层接口
 *
 * @author Henryhlz
 */
public interface ICustomerService {
    /**
     * 保存客户
     */
    void saveCustomer(CstCustomer customer);

    /**
     * 查询所有客户
     * @param criteria
     */
    List<CstCustomer> findAllCustomer(DetachedCriteria criteria);

    /**
     * 查询所有客户级别
     * @return
     */
    List<BaseDict> findAllCustLevel();

    /**
     * 查询所有客户信息来源
     *
     * @return
     */
    List<BaseDict> findAllCustSource();

    /**
     * 删除客户
     *
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
     * @param custId
     * @return
     */
    CstCustomer findById(long custId);

    /**
     * 投影查询客户列表
     *
     * @return
     */
    List<CstCustomer> findAllCustomer();
}
