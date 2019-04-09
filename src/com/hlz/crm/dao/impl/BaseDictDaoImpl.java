package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.IBaseDictDao;
import com.hlz.crm.domain.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Henryhlz
 */
@Repository
public class BaseDictDaoImpl implements IBaseDictDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 根据字典类型查询字典表数据
     *
     * @param typeCode
     * @return
     */
    @Override
    public List<BaseDict> findBaseDictByTypeCode(String typeCode) {
        return (List<BaseDict>) hibernateTemplate.find("from BaseDict where dictTypeCode = ?", typeCode);
    }
}
