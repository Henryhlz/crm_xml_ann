package com.hlz.crm.service.impl;

import com.hlz.crm.dao.IBaseDictDao;
import com.hlz.crm.dao.ICustomerDao;
import com.hlz.crm.domain.BaseDict;
import com.hlz.crm.domain.CstCustomer;
import com.hlz.crm.service.ICustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 客户业务层接口的实现类
 *
 * @author Henryhlz
 */
@Service
/*开启事务*/
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private IBaseDictDao baseDictDao;

    /**
     * 保存客户
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveCustomer(CstCustomer customer) {
        customerDao.saveCustomer(customer);
    }

    /**
     * 查询所有客户
     * @param criteria
     */
    @Override
    public List<CstCustomer> findAllCustomer(DetachedCriteria criteria) {
        return customerDao.findAllCustomer(criteria);
    }

    /**
     * 查询所有客户级别
     *
     * @return
     */
    @Override
    public List<BaseDict> findAllCustLevel() {
        return baseDictDao.findBaseDictByTypeCode("006");
    }

    /**
     * 查询所有客户信息来源
     *
     * @return
     */
    @Override
    public List<BaseDict> findAllCustSource() {
        return baseDictDao.findBaseDictByTypeCode("002");
    }

    /**
     * 删除客户
     *
     * @param custId
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void removeCustomer(long custId) {
        customerDao.removeCustomer(custId);
    }

    /**
     * 编辑客户
     *
     * @param customer
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void editCustomer(CstCustomer customer) {
        customerDao.editCustomer(customer);
    }

    /**
     * @param custId
     * @return
     */
    @Override
    public CstCustomer findById(long custId) {
        return customerDao.findById(custId);
    }
}
