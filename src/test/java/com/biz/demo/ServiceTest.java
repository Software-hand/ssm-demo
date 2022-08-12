package com.biz.demo;

import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.biz.demo.web.entity.TUserInfo;
import com.biz.demo.web.service.IUserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/8/4 7:58
 * @description:
 */
@SpringBootTest
public class ServiceTest {

    @Autowired
    private IUserInfoService iUserInfoService;

    // 1、查询记录总数
    @Test
    public void testSelect1(){
        int count = iUserInfoService.count();
        System.out.println("记录总数：count = " + count);
    }

    // 2、添加多条用户数据
    @Test
    public void testInsert(){
        List<TUserInfo> list = new ArrayList<>();
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setId("3");
        tUserInfo.setUserName("rjs");
        tUserInfo.setRealName("mj");
        tUserInfo.setPassword("123456");
        tUserInfo.setCreateBy("软件手");

        list.add(tUserInfo);
        iUserInfoService.saveBatch(list);
    }

    // 2、添加一条用户数据
    @Test
    public void testInsert1(){

        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setId("3");
        tUserInfo.setUserName("rjs");
        tUserInfo.setRealName("mj");
        tUserInfo.setPassword("123456");

        iUserInfoService.save(tUserInfo);
    }

    // 3、根据id修改用户数据
    @Test
    public void testUpdate(){
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setId("2");
        tUserInfo.setUserName("shadows");
        tUserInfo.setRealName("updateTest");
        tUserInfo.setPassword("471583744");

        iUserInfoService.updateById(tUserInfo);
    }

    // 4、根据id删除用户数据
    @Test
    public void testDelete(){
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setId("2");
        iUserInfoService.removeById(tUserInfo);
    }

}
