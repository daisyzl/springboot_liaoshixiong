package com.imooc.handle;

import com.imooc.domain.Result;
import com.imooc.exception.GirlException;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            return ResultUtil.failed(girlException.getCode(),girlException.getMessage());
        }
        else {
            logger.error("[系统异常]{}",e);
            return ResultUtil.failed(-1,"未知错误");
        }

    }

}
