package com.hlz.action;

import com.hlz.domain.CstCustomer;
import com.hlz.service.ICustomerService;
import com.opensymphony.xwork2.ActionSupport;


import java.util.List;

/**
 * @author Henryhlz
 */
public class CustomerAction extends ActionSupport {
    private CstCustomer customer = new CstCustomer();
    private List<CstCustomer> customers;
    private ICustomerService customerService;


    /**
     * 添加客户
     *
     * @return
     */
    public String addCustomer() {
        return "addCustomer";
    }

    /**
     * 查询所有客户
     *
     * @return
     */
    public String findAllCustomer() {
        customers = customerService.findAllCustomer();
        return "findAllCustomer";
    }

    public CstCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CstCustomer customer) {
        this.customer = customer;
    }

    public List<CstCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CstCustomer> customers) {
        this.customers = customers;
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
}
