package com.cjf.springcloud.microservicecloudconsumerdept9001.controller;

import com.cjf.microservicecloudapi.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class depcontroller_consumer {
  //  private static final String Rest_Url_Prefix ="http://localhost:8001";
    private static final String Rest_Url_Prefix ="http://MICROSERVICECLOUD-DEPT";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public int add(Dept dept){
    return restTemplate.postForObject(Rest_Url_Prefix+"/dept/add",dept,int.class);
    }
    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable int id){
        return restTemplate.getForObject(Rest_Url_Prefix+"/dept/get/"+id,Dept.class);
    }


    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(Rest_Url_Prefix+"/dept/getall",List.class);
    }

    @RequestMapping("/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(Rest_Url_Prefix+"/dept/discovery",Object.class);
    }
}
