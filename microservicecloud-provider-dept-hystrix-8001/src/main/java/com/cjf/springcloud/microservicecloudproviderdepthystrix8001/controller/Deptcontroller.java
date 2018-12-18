package com.cjf.springcloud.microservicecloudproviderdepthystrix8001.controller;

import com.cjf.microservicecloudapi.model.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Deptcontroller {
    @Autowired
    private com.cjf.springcloud.microservicecloudproviderdepthystrix8001.service.deptservice deptservice;
    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Object get(@PathVariable("id") int id){
        Dept dept= deptservice.get(id);
        if(dept==null){
            throw  new RuntimeException("该ID:"+id+"没有对应信息");
        }
        return dept;
    }

    public Object processHystrix_Get(@PathVariable("id") int deptno){
        return "不存在该ID";
    }

    @HystrixCommand
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public int add(@RequestBody Dept dept){
        dept.setDbSource("dept3");
        return deptservice.add(dept);
    }

    @HystrixCommand
    @RequestMapping(value = "/dept/getall",method = RequestMethod.GET)
    public List<Dept> getall(){
        return deptservice.getAll();
    }

    @HystrixCommand
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
