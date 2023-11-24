package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TliasLog {
    private Integer id;
    private String username;
    private String className;
    private String argus;
    private Long runTime;
    private String methodName;
    private String result;
}
