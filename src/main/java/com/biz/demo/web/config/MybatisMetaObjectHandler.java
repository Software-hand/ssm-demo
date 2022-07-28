package com.biz.demo.web.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description：实体修改或新增时修改日期
 * @author：zhangke
 * @date：2021/6/30 17:38
 */
@Slf4j
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    //    插入时候的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("新增时填充的值");
//      String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("createDate", new Date(), metaObject);
//        this.setFieldValByName("createBy", myRedisService.getUserName(), metaObject);
        this.setFieldValByName("delFlag", 1, metaObject);
        // 补充工作流字段
//        if(metaObject.getOriginalObject() instanceof BaseWFEntity){
//            this.setFieldValByName("reqPos", securityService.securityUserDetails().getPosInfo().getPosCode(), metaObject);
//            this.setFieldValByName("reqName", securityService.getUserName(), metaObject);
//        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("修改时填充的值");
//        this.setFieldValByName("updateBy", myRedisService.getUserName(), metaObject);
    }

}
