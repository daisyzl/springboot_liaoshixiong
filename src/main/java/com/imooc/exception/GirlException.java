package com.imooc.exception;

import com.imooc.enums.ResultEnum;

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
