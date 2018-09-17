package com.imooc.controller;

import com.imooc.repository.GirlRepository;
import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /*
    查询所有女生
     */

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }
    /*
    添加一个女生
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        //id是自增，不用填写
        return girlRepository.save(girl);
    }
    /*
    添加一个女生避免写入过多参数,单个属性换成对象
     */
    @PostMapping(value = "/girls/param")
    public Girl girlAdd_Param(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        //id是自增，不用填写
        return girlRepository.save(girl);
    }

    //查询一个女生
    @GetMapping(value ="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }
    //更新一个女生
    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    //删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        Girl girl=new Girl();
        girl.setId(id);
        girlRepository.delete(girl);
        //delete要传入一个对象，不是一个id
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return  girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();

    }


}
