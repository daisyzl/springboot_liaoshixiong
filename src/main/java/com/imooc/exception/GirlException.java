package com.imooc.exception;

import com.imooc.enums.ResultEnum;

//RuntimeException才会事物回滚
//为了方便排查错误
public class GirlException  extends RuntimeException{
    public Integer getCode() {
        return code;
    }
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();

    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private Integer code;


}
