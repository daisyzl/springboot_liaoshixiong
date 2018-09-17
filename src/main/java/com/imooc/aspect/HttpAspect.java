package com.imooc.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.controller.GirlController.girlList(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}",joinPoint.getArgs());

        logger.info("1111111111");
    }
    @After("log()")
    public void doAfter(){
        logger.info("2222222222");

    }

    @AfterReturning(returning = "object",pointcut ="log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());

    }

    /*
    运行结果
2018-09-17 19:00:31.178  INFO 4944 --- [nio-8081-exec-1] com.imooc.aspect.HttpAspect              : url=http://127.0.0.1:8081/girls
2018-09-17 19:00:31.178  INFO 4944 --- [nio-8081-exec-1] com.imooc.aspect.HttpAspect              : method=GET
2018-09-17 19:00:31.178  INFO 4944 --- [nio-8081-exec-1] com.imooc.aspect.HttpAspect              : ip=127.0.0.1
2018-09-17 19:00:31.179  INFO 4944 --- [nio-8081-exec-1] com.imooc.aspect.HttpAspect              : class_method=com.imooc.controller.GirlController.girlList
2018-09-17 19:00:31.180  INFO 4944 --- [nio-8081-exec-1] com.imooc.aspect.HttpAspect              : args={}
2018-09-17 19:00:31.180  INFO 4944 --- [nio-8081-exec-1] com.imooc.aspect.HttpAspect              : 1111111111
2018-09-17 19:00:31.204  INFO 4944 --- [nio-8081-exec-1] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
Hibernate: select girl0_.id as id1_0_, girl0_.age as age2_0_, girl0_.cup_size as cup_size3_0_ from girl girl0_
2018-09-17 19:00:31.281  INFO 4944 --- [nio-8081-exec-1] com.imooc.aspect.HttpAspect              : 2222222222
2018-09-17 19:00:31.281  INFO 4944 --- [nio-8081-exec-1] com.imooc.aspect.HttpAspect              : response=[Girl{id=1, cupSize='B', age=18}, Girl{id=2, cupSize='C', age=18}]
     */

//    @Before("execution(public * com.imooc.controller.GirlController.girlList(..))")
//    public void log(){
//        System.out.println("6666666666");
//
//    }
//    @After("execution(public * com.imooc.controller.GirlController.girlList(..))")
//    public void doAfter(){
//        System.out.println("7777777777777777");
//
//    }
}
