package com.biz.demo.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biz.demo.web.dao.IUserInfoDao;
import com.biz.demo.web.entity.TUserInfo;
import com.biz.demo.web.model.UserInfoModel;
import com.biz.demo.web.service.IUserInfoService;
import com.biz.demo.web.vo.UserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version V0.1
 * @项目名称：xgt-service
 * @类名称：UserServiceImpl
 * @类描述：
 * @创建人：justin
 * @创建时间：2020/10/26 16:47
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<IUserInfoDao, TUserInfo> implements IUserInfoService {
    @Autowired
    private IUserInfoDao userInfoDao;

    @Override
    public PageInfo<UserInfoModel> queryUserInfoList(UserInfoVo userVo) {
        PageHelper.startPage(userVo.getPageNum(), userVo.getPageSize());
        List<UserInfoModel> list = userInfoDao.queryUserInfoList(userVo);
        return new PageInfo(list);
    }

    @Override
    public List<UserInfoModel> searchUserInfoList(UserInfoVo userVo) {
        return userInfoDao.queryUserInfoList(userVo);
    }
}
