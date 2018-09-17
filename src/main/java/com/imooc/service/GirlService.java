package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
//如果不添加会报错Consider defining a bean of type 'com.imooc.service.GirlService' in your con
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA=new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlA.setCupSize("B");
        girlA.setAge(19);
        girlRepository.save(girlB);


    }
}
