package com.cjf.springcloud.microservicecloudproviderdept8003.service;

import com.cjf.microservicecloudapi.model.Dept;

import java.util.List;

public interface deptservice {

    public int add(Dept dept);
    public List<Dept> getAll();
    public Dept get(int id);

}
