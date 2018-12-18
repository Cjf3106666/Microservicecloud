package com.cjf.microservicecloudapi.service;

import com.cjf.microservicecloudapi.model.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DeptClientServiceFallbcakFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public int add(Dept dept) {
                return 0;
            }

            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("不存在该ID，Consumer客户端提供的的降级消息，此刻服务Provider已经关闭").setDbSource("数据库中无此记录");
            }
            @Override
            public List<Dept> getAll() {
                return null;
            }
        };
    }
}
