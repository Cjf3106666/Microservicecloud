package com.cjf.springcloud.microservicecloudproviderdepthystrix8001.service;

import com.cjf.microservicecloudapi.model.Dept;

import java.util.List;

public interface deptservice {

    public int add(Dept dept);
    public List<Dept> getAll();
    public Dept get(int id);

}
