package com.dylan.rbac.common.mapper;

import com.dylan.rbac.common.model.Example;
import com.dylan.rbac.common.model.ModelBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<E extends ModelBean, C extends Example, PK> {
    long countByExample(C example);

    int deleteByExample(C example);

    int deleteByPrimaryKey(PK id);

    int insert(E record);

    int insertSelective(E record);

    List<E> selectByExample(C example);

    E selectByPrimaryKey(PK id);

    int updateByExampleSelective(@Param("record") E record, @Param("example") C example);

    int updateByExample(@Param("record") E record, @Param("example") C example);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);
}
