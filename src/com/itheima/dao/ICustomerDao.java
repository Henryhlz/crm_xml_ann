package com.itheima.dao;

import com.itheima.domain.CstCustomer;

import java.util.List;

/**
 * 客户持久层接口
 *
 * @author Henryhlz
 */
public interface ICustomerDao {

    /**
     * 保存客户
     */
    void saveCustomer(CstCustomer customer);

    /**
     * 查询所有客户
     */
    List<CstCustomer> findAllCustomer();
}
