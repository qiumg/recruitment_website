package com.website.client.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 2267751680865696851L;

    /**是否成功**/
    private Boolean success = false ;
    /**返回消息**/
    private String message;
    /**返回数据**/
    private Object data;
    //省略getter和setter方法
    private Object pwd1;

    private Object pwd2;

}
