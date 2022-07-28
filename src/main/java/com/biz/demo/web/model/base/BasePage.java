package com.biz.demo.web.model.base;


import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName: BasePage
 * Package: com.ywh.common.entity
 * Describe:
 * 分页实体类
 */
public class BasePage {

    /**
     * 当前每页显示数
     */
    @ApiModelProperty(value = "每页显示数")
    private Integer pageSize;

    /**
     * 当前页数
     */
    @ApiModelProperty(value = "页数")
    private Integer pageNum;

    public Integer getPageNum() {
        return pageNum == null || pageNum == 0 ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null || pageSize == 0 ? 1000 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
