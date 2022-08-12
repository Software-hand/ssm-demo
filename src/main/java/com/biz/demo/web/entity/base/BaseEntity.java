package com.biz.demo.web.entity.base;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V0.1
 * @项目名称：springBootDemo
 * @类名称：BaseEntity
 * @类描述：
 * @创建人：justin
 * @创建时间：2018-05-03 16:19
 */
@Getter
@Setter
public class BaseEntity implements Serializable {
    /**
     * 主键ID  32位UUID
     */
    @ApiModelProperty(value = "主键ID", required = true)
    @TableId(value = "id", type = IdType.ASSIGN_ID) // 该类型为未设置主键类型(注解里等于跟随全局,全局里约等于 INPUT)  ID型填充类
    private String id;
    /**
     * 创建人
     *  hidden = true ：隐藏
     */
    @ApiModelProperty(value = "创建人", hidden = true) // hidden = true 隐藏
    @TableField(fill = FieldFill.INSERT) // 更新时填充字段 填入当前时间
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)  // 更新时填充字段
    private Date createDate;
    /**
     * 最后修改人
     */
    @ApiModelProperty(value = "修改人", hidden = true)
    @TableField(fill = FieldFill.UPDATE) // 插入和更新时填充字段
    private String updateBy;
    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "修改时间", hidden = true)
    @TableField(exist = false)  // 是否为数据库表字段 默认 true 存在，false 不存在
    private Date updateDate;
    /*
    当我们项目中实体类中，需要该属性，但是却不是数据库中的字段我们可以用：
    @TableField(exist = false) 注解加载bean属性上，表示当前属性不是数据库的字段，
    但在项目中必须使用，这样在新增等使用bean的时候，mybatis-plus就会忽略这个，不会报错。
    @TableField（）中@TableField(exist =true) 默认为true,表明为数据库字段对应的实体类变量。
    */

    @TableLogic(value = "1", delval = "9")   // 逻辑删除
    @TableField(select = false)  // 是否进行 select 查询     大字段可设置为 false 不加入 select 查询范围
    private int delFlag;
}
/*
public enum FieldFill {
    *//**
     * 默认不处理
     *//*
    DEFAULT,
    *//**
     * 插入时填充字段
     *//*
    INSERT,
    *//**
     * 更新时填充字段
     *//*
    UPDATE,
    *//**
     * 插入和更新时填充字段
     *//*
    INSERT_UPDATE
}*/
