package com.hlz.crm.action;

import com.hlz.crm.domain.CstCustomer;
import com.hlz.crm.service.ICustomerService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * @author Henryhlz
 */
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({
        @Result(name = "addCustomerPage", type = "dispatcher", location = "/jsp/customer/add.jsp"),
        @Result(name = "addCustomer", type = "redirectAction", location = "findAllCustomer"),
        @Result(name = "findAllCustomer", type = "dispatcher", location = "/jsp/customer/list.jsp")
})
public class CustomerAction extends ActionSupport {
    private CstCustomer customer = new CstCustomer();
    private List<CstCustomer> customers;
    @Autowired
    private ICustomerService customerService;


    /**
     * 跳转添加客户页面
     *
     * @return
     */
    @Action("addCustomerPage")
    public String addCustomerPage() {
        return "addCustomerPage";
    }

    /**
     * 添加客户
     *
     * @return
     */
    @Action("addCustomer")
    public String addCustomer() {
        customerService.saveCustomer(customer);
        return "addCustomer";
    }

    /**
     * 查询所有客户
     *
     * @return
     */
    @Action("findAllCustomer")
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

}
