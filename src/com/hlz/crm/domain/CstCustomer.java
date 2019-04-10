package com.hlz.crm.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Henryhlz
 */
@Entity
@Table(name = "cst_customer", schema = "crm")
public class CstCustomer {
    private long custId;
    private String custName;
    private BaseDict custSource;
    private String custIndustry;
    private BaseDict custLevel;
    private String custAddress;
    private String custPhone;
    private Set<CstLinkman> linkmanSet = new HashSet<CstLinkman>(0);

    @Id
    @Column(name = "cust_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    @Basic
    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Basic
    @ManyToOne(targetEntity = BaseDict.class)
    @JoinColumn(name = "cust_source", referencedColumnName = "dict_id")
    public BaseDict getCustSource() {
        return custSource;
    }

    public void setCustSource(BaseDict custSource) {
        this.custSource = custSource;
    }

    @Basic
    @Column(name = "cust_industry")
    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    @Basic
    @ManyToOne(targetEntity = BaseDict.class)
    @JoinColumn(name = "cust_level", referencedColumnName = "dict_id")
    public BaseDict getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(BaseDict custLevel) {
        this.custLevel = custLevel;
    }

    @Basic
    @Column(name = "cust_address")
    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Basic
    @Column(name = "cust_phone")
    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @OneToMany(mappedBy = "customer")
    public Set<CstLinkman> getLinkmanSet() {
        return linkmanSet;
    }

    public void setLinkmanSet(Set<CstLinkman> linkmanSet) {
        this.linkmanSet = linkmanSet;
    }

    public CstCustomer() {
    }

    public CstCustomer(long custId, String custName) {
        this.custId = custId;
        this.custName = custName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CstCustomer that = (CstCustomer) o;
        return custId == that.custId &&
                Objects.equals(custName, that.custName) &&
                Objects.equals(custSource, that.custSource) &&
                Objects.equals(custIndustry, that.custIndustry) &&
                Objects.equals(custLevel, that.custLevel) &&
                Objects.equals(custAddress, that.custAddress) &&
                Objects.equals(custPhone, that.custPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, custName, custSource, custIndustry, custLevel, custAddress, custPhone);
    }

    @Override
    public String toString() {
        return "CstCustomer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
