package com.cjf.springcloud.microservicecloudconsumerdept9002.controller;

import com.cjf.microservicecloudapi.model.Dept;
import com.cjf.microservicecloudapi.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class depcontroller_consumer {
    @Autowired
    private DeptClientService service = null;

    public int add(Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> getAll() {
        return service.getAll();
    }
}
