package com.cjf.microservicecloudapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept {
    private Long deptno;

    private String dname;

    private String dbSource;

}