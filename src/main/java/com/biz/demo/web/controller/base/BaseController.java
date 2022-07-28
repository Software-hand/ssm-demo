package com.biz.demo.web.controller.base;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version V0.1
 * @项目名称：springBootDemo
 * @类名称：BaseController
 * @类描述：
 * @创建人：justin
 * @创建时间：2018-05-04 11:13
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 描述：返回json格式数据到前端页面
     * @author justin
     * @创建时间 2017年6月14日 下午3:24:20
     */
    public void writeJson(Object object, HttpServletResponse response) {
        try {
            String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
            response.setContentType("text/html;charset=utf-8");
            // response.setContentType("application/json");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description：验证分页参数pageNum和pageSize
     * @author：justin
     * @date：2019-10-14 10:08
     */
    public String validatePageParam(int pageNum, int pageSize) {
        String msg = "";
        if (pageNum <= 0 || pageSize <= 0) {
            msg = "参数【pageNum】或【pageSize】异常！必须是大于0的整数！";
        }
        return msg;
    }

    /**
     * 将对象装换为map
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    protected boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        return fileSize > size;
    }

}
