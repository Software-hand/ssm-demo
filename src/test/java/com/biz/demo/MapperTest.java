package com.biz.demo;

import com.biz.demo.web.dao.IUserInfoDao;
import com.biz.demo.web.entity.TUserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author: 软件手
 * @date: 2022/8/4 9:00
 * @description:
 */
@SpringBootTest
public class MapperTest {

    @Autowired
    IUserInfoDao iUserInfoDao;

    // 1、查询
    @Test
    public void testSelectList(){
        // 通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<TUserInfo> list= iUserInfoDao.selectList(null);
        list.forEach(System.out::println);

        for (TUserInfo i : list){
            System.out.println(i.getId()+ "----" +i.getUserName() + "----" + i.getPassword());
        }
    }
    // 2、增加
    @Test
    public void testInsert(){

        TUserInfo tUserInfo = new TUserInfo();

        tUserInfo.setId("4");
        tUserInfo.setUserName("4444");
        tUserInfo.setRealName("mj");
        tUserInfo.setPassword("123456");
        iUserInfoDao.insert(tUserInfo);

    }

    // 3、修改
    @Test
    public void testUpdate(){
        TUserInfo tUserInfo = new TUserInfo();

        tUserInfo.setId("4");
        tUserInfo.setUserName("55555");
        tUserInfo.setRealName("zxc");
        tUserInfo.setPassword("88888");
        iUserInfoDao.updateById(tUserInfo);
    }

    // 4、删除
    @Test
    public void testDelete(){
        TUserInfo tUserInfo = new TUserInfo();

        tUserInfo.setId("3");
        iUserInfoDao.deleteById(tUserInfo);
    }


}
