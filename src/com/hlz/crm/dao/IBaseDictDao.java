package com.hlz.crm.dao;

import com.hlz.crm.domain.BaseDict;

import java.util.List;

/**
 * @author Henryhlz
 */
public interface IBaseDictDao {
    /**
     * 根据字典类型查询字典表数据
     *
     * @param typeCode
     * @return
     */
    List<BaseDict> findBaseDictByTypeCode(String typeCode);
}
