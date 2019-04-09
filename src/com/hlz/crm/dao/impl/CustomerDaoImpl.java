package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.ICustomerDao;
import com.hlz.crm.domain.CstCustomer;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Henryhlz
 */
@Repository
public class CustomerDaoImpl implements ICustomerDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public void saveCustomer(CstCustomer customer) {
        hibernateTemplate.save(customer);
    }

    @Override
    public List<CstCustomer> findAllCustomer(DetachedCriteria criteria) {
        return (List<CstCustomer>) hibernateTemplate.findByCriteria(criteria);
    }

    /**
     * 删除客户
     *
     * @param custId
     */
    @Override
    public void removeCustomer(long custId) {
        CstCustomer customer = findById(custId);
        hibernateTemplate.delete(customer);
    }


    /**
     * 编辑客户
     *
     * @param customer
     */
    @Override
    public void editCustomer(CstCustomer customer) {
        hibernateTemplate.update(customer);
    }

    /**
     * 查询单个客户
     *
     * @param custId
     */
    @Override
    public CstCustomer findById(long custId) {
        return hibernateTemplate.load(CstCustomer.class, custId);
    }
}
