package com.biz.demo.web.model.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;

/**
 * 描述：
 * @version 1.0
 * @author： justin
 * @date： 2022-06-13 12:14:11
 */
@Getter
@Setter
@AllArgsConstructor
public class ResMsg {
    /**
     * 返回状态码，参照HTTP标准状态码 ： 200为正确，403为鉴权失败,503服务无效
     */
    @ApiModelProperty(value = "返回状态码：true/false", required = true)
    private int code;

    /**
     * 成功与否标识
     */
    @ApiModelProperty(value = "成功标识：true/false", required = true)
    private boolean success;
    /**
     * 消息文本
     */
    @ApiModelProperty(value = "文本描述")
    private String msg;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "返回的数据内容")
    private Object obj;

    public ResMsg() {
    }

    public static ResMsg success() {
        return new ResMsg(HttpStatus.SC_OK, true, "操作成功", null);
    }

    public static ResMsg success(Object obj) {
        return new ResMsg(HttpStatus.SC_OK, true, "操作成功", obj);
    }

    public static ResMsg success(String msg, Object obj) {
        return new ResMsg(HttpStatus.SC_OK,true, msg, obj);
    }

    public static ResMsg error(String msg) {
        return new ResMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR,false, msg, null);
    }

    public static ResMsg error(String msg, Object obj) {
        return new ResMsg(HttpStatus.SC_INTERNAL_SERVER_ERROR,false, msg, obj);
    }
    public static ResMsg error(int errorCode,String msg) {
        return new ResMsg(errorCode,false, msg,null);
    }
}
