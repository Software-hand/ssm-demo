package com.biz.demo.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.biz.demo.web.entity.TUserInfo;
import com.biz.demo.web.model.UserInfoModel;
import com.biz.demo.web.vo.UserInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V0.1
 * @项目名称：xgt-service
 * @类名称：IUserService
 * @类描述：
 * @创建人：justin
 * @创建时间：2020/10/26 16:42
 */
public interface IUserInfoService extends IService<TUserInfo> {
    /**
     * @description：分页查询
     * @author：justin
     * @date：2020/10/26 16:45
     */
    PageInfo<UserInfoModel> queryUserInfoList(UserInfoVo userVo);

    /**
     * @description：获取用户信息-分页
     * @author：justin
     * @date：2022/6/13 15:22
     */
    List<UserInfoModel> searchUserInfoList(UserInfoVo userInfoDto);
}
