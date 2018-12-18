package com.cjf.springcloud.microservicecloudproviderdepthystrix8001.service;

import com.cjf.microservicecloudapi.model.Dept;
import com.cjf.springcloud.microservicecloudproviderdepthystrix8001.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class deptserviceImp  implements deptservice{
    @Autowired
    private DeptMapper mapper;

    @Override
    public int add(Dept dept) {
        return mapper.insert(dept);
    }

    @Override
    public List<Dept> getAll() {
        return mapper.selectAll();
    }

    @Override
    public Dept get(int id) {
        return mapper.selectByPrimaryKey(Long.valueOf(id));
    }
}
