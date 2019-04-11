package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.ICustomerDao;
import com.hlz.crm.domain.CstCustomer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
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


    /**
     * 按条件查询记录数
     *
     * @param criteria
     * @return
     */
    @Override
    public int findTotalRecords(DetachedCriteria criteria) {
        criteria.setProjection(Projections.count("custId"));
        List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(criteria);
        return list.isEmpty() ? 0 : list.get(0).intValue();
    }

    @Override
    public void saveCustomer(CstCustomer customer) {
        hibernateTemplate.save(customer);
    }

    /**
     * 查询所有客户
     *
     * @param criteria
     * @param firstResult
     * @param maxResults
     */
    @Override
    public List<CstCustomer> findAllCustomer(DetachedCriteria criteria, int firstResult, int maxResults) {
        criteria.setProjection(null);
        return (List<CstCustomer>) hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
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

    /**
     * 投影查询客户列表
     *
     * @return
     */
    @Override
    public List<CstCustomer> findAll() {
        return (List<CstCustomer>) hibernateTemplate.find("select new CstCustomer(custId,custName) from CstCustomer");
    }
}
