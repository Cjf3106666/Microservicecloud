package com.cjf.springcloud.microservicecloudproviderdept8003.mapper;


import com.cjf.microservicecloudapi.model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DeptMapper {


    int deleteByPrimaryKey(Long deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept>selectAll();

}