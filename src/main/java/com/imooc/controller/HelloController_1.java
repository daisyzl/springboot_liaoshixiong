package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "hello")
//对整个类添加一个映射
public class HelloController_1 {
    @Autowired
    private GirlProperties girlProperties;

    //    @RequestMapping(value = {"/say"},method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myid){
        return "id: " +myid;
    }
}
