package com.biz.demo;

import com.biz.demo.web.dao.IUserInfoDao;
import com.biz.demo.web.entity.TUserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/8/4 9:48
 * @description:
 */
@SpringBootTest
public class MapperConfigTest {

    @Autowired
    IUserInfoDao iUserInfoDao;



    // 1、查询
    @Test
    public void testSelectList(){
        List<TUserInfo> list = iUserInfoDao.getAllTUserInfo();
        list.forEach(System.out::println);

        for (TUserInfo i : list){
            System.out.println(i.getId()+ "----" +i.getUserName() + "----" + i.getPassword());
        }
    }

    // 2、增加
    @Test
    public void testInsert(){
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setId("3");
        tUserInfo.setUserName("12312");
        tUserInfo.setRealName("zxc");
        tUserInfo.setPassword("3333333");
        iUserInfoDao.insertAll(tUserInfo);
    }

    // 3、修改 将 id 1 的用户 修改用户名
    @Test
    public void testUpdate(){
                iUserInfoDao.updateUserNameById("dark-update","1");
    }

    // 4、删除 自己配置的，不需要新建实体类，直接传入 Sting 3
    @Test
    public void testDelete(){
        iUserInfoDao.deleteById("3");
    }

}
