package com.imooc.repository;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository<Girl, Integer>中Integer表示id
public interface GirlRepository extends JpaRepository<Girl, Integer>{
    //通过年龄查询
    public List<Girl> findByAge(Integer gae);
}
