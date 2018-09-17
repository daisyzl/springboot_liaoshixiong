package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//对整个类添加一个映射
public class HelloController {


    @RequestMapping(value = {"/say"},method = RequestMethod.GET)
    public String say() {
        return "Hello Spring Boot";
    }
}
