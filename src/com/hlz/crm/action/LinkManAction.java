package com.hlz.crm.action;

import com.hlz.crm.domain.CstCustomer;
import com.hlz.crm.domain.CstLinkman;
import com.hlz.crm.service.ICustomerService;
import com.hlz.crm.service.ILinkManService;
import com.hlz.framework.commons.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Henryhlz
 */
@Controller
@ParentPackage("struts-default")
@Namespace("/linkman")
@Results({
        @Result(name = "addLinkManPage", type = "dispatcher", location = "/jsp/linkman/add.jsp"),
        @Result(name = "success", type = "dispatcher", location = "/jsp/success.jsp"),
        @Result(name = "findAllLinkManPage", type = "dispatcher", location = "/jsp/linkman/list.jsp"),
        @Result(name = "findAll", type = "redirectAction", location = "findAllLinkMan"),
        @Result(name = "editLinkManPage", type = "dispatcher", location = "/jsp/linkman/edit.jsp")
})
public class LinkManAction extends ActionSupport {
    private CstLinkman linkman = new CstLinkman();
    private List<CstCustomer> customers;
    @Autowired
    private ILinkManService linkManService;
    @Autowired
    private ICustomerService customerService;
    private int pageNum;
    private Page page;

    /**
     * 编辑联系人页面
     *
     * @return
     */
    @Action("editLinkManPage")
    public String editLinkManPage() {
        linkman = linkManService.findById(linkman.getLkmId());
        customers = customerService.findAllCustomer();
        return "editLinkManPage";
    }

    /**
     * 编辑联系人页面
     *
     * @return
     */
    @Action("editLinkMan")
    public String editLinkMan() {
        linkManService.editLinkMan(linkman);
        return "findAll";
    }

    /**
     * 删除联系人
     *
     * @return
     */
    @Action("deleteLinkMan")
    public String deleteLinkMan() {
        linkManService.deleteLinkMan(linkman.getLkmId());
        return "findAll";
    }

    /**
     * 新增联系人页面
     *
     * @return
     */
    @Action("addLinkMan")
    public String addLinkMan() {
        linkManService.addLinkMan(linkman);
        return SUCCESS;
    }

    /**
     * 新增联系人页面
     *
     * @return
     */
    @Action("addLinkManPage")
    public String addLinkManPage() {
        //查询所有客户
        customers = customerService.findAllCustomer();
        return "addLinkManPage";
    }

    /**
     * 新增联系人页面
     *
     * @return
     */
    @Action("findAllLinkMan")
    public String findAllLinkMan() {
        DetachedCriteria criteria = DetachedCriteria.forClass(CstLinkman.class);
        //拼装条件查询
        //判断是否输入联系人名字
        if (StringUtils.isNoneBlank(linkman.getLkmName())) {
            criteria.add(Restrictions.like("lkmName", "%" + linkman.getLkmName() + "%"));
        }
        //判断是否输入所属客户
        if (linkman.getCustomer() != null && linkman.getCustomer().getCustId() != 0) {
            criteria.add(Restrictions.eq("customer", linkman.getCustomer()));
        }
        //判断是否输入联系人职务
        if (StringUtils.isNoneBlank(linkman.getLkmPosition())) {
            criteria.add(Restrictions.like("lkmPosition", "%" + linkman.getLkmPosition() + "%"));
        }
        //判断是否输入联系人性别
        if (StringUtils.isNoneBlank(linkman.getLkmGender())) {
            criteria.add(Restrictions.eq("lkmGender", linkman.getLkmGender()));
        }

        //查询结果
        page = linkManService.findAllLinkMan(criteria, pageNum);
        //查询所有客户
        customers = customerService.findAllCustomer();
        return "findAllLinkManPage";
    }

    public CstLinkman getLinkman() {
        return linkman;
    }

    public void setLinkman(CstLinkman linkman) {
        this.linkman = linkman;
    }

    public List<CstCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CstCustomer> customers) {
        this.customers = customers;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
