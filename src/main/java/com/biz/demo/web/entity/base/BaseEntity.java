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
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    /**
     * 最后修改人
     */
    @ApiModelProperty(value = "修改人", hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;
    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "修改时间", hidden = true)
    @TableField(exist = false)
    private Date updateDate;

    @TableLogic(value = "1", delval = "9")
    @TableField(select = false)
    private int delFlag;
}
