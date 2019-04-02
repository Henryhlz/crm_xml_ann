package com.hlz.dao.impl;

import com.hlz.dao.ICustomerDao;
import com.hlz.domain.CstCustomer;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * @author Henryhlz
 */
public class CustomerDaoImpl implements ICustomerDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void saveCustomer(CstCustomer customer) {
        hibernateTemplate.save(customer);
    }

    @Override
    public List<CstCustomer> findAllCustomer() {
        return (List<CstCustomer>) hibernateTemplate.find("from CstCustomer ");
    }
}
