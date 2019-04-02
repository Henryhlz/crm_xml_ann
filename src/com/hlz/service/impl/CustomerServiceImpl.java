package com.hlz.service.impl;

import com.hlz.dao.ICustomerDao;
import com.hlz.domain.CstCustomer;
import com.hlz.service.ICustomerService;

import java.util.List;

/**
 * 客户业务层接口的实现类
 *
 * @author Henryhlz
 */
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao;

    public void setCustomerDao(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 保存客户
     */
    @Override
    public void saveCustomer(CstCustomer customer) {
        customerDao.saveCustomer(customer);
    }

    /**
     * 查询所有客户
     */
    @Override
    public List<CstCustomer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }
}
