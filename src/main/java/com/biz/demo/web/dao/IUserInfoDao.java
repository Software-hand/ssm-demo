package com.biz.demo.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.biz.demo.web.entity.TUserInfo;
import com.biz.demo.web.model.UserInfoModel;
import com.biz.demo.web.vo.UserInfoVo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V0.1
 * @项目名称：xgt-service
 * @类名称：IUserInfoDao
 * @类描述：
 * @创建人：justin
 * @创建时间：2020/10/26 16:48
 */
@Repository
public interface IUserInfoDao extends BaseMapper<TUserInfo> {
    /**
     * @description：分页查询
     * @author：justin
     * @date：2020/10/26 16:45
     */
    List<UserInfoModel> queryUserInfoList(UserInfoVo userVo);

}
