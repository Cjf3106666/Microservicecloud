package com.cjf.springcloud.microservicecloudproviderdept8001.controller;

import com.cjf.microservicecloudapi.model.Dept;
import com.cjf.springcloud.microservicecloudproviderdept8001.service.deptservice;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class Deptcontroller {
    @Autowired
    private deptservice deptservice;
    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand
    @RequestMapping(value = "/dept/get/{deptno}",method = RequestMethod.GET)
    public Dept get(@PathVariable int deptno){
        return deptservice.get(deptno);
    }
    @HystrixCommand
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public int add(@RequestBody Dept dept){
        dept.setDbSource("dept1");
        return deptservice.add(dept);
    }
    @HystrixCommand
    @RequestMapping(value = "/dept/getall",method = RequestMethod.GET)
    public List<Dept> getall(){
        return deptservice.getAll();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list=discoveryClient.getServices();
        System.out.println("***********"+list);
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance e:serviceInstances
             ) {
            System.out.println(e.getServiceId()+"\t"+e.getHost()+"\t"+e.getPort()+"\t"+e.getUri());
        }
        return serviceInstances;
    }

}
