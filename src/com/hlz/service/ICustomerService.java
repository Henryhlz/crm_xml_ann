package com.hlz.service;

import com.hlz.domain.CstCustomer;

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
     */
    List<CstCustomer> findAllCustomer();
}
