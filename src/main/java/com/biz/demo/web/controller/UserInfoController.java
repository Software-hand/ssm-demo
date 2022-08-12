package com.biz.demo.web.controller;

import com.biz.demo.web.controller.base.BaseController;
import com.biz.demo.web.entity.TUserInfo;
import com.biz.demo.web.entity.base.BaseEntity;
import com.biz.demo.web.model.UserInfoModel;
import com.biz.demo.web.model.base.ResMsg;
import com.biz.demo.web.service.IUserInfoService;
import com.biz.demo.web.util.PasswordUtil;
import com.biz.demo.web.vo.UserInfoVo;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.biz.demo.web.model.base.ResMsg.error;
import static com.biz.demo.web.model.base.ResMsg.success;

/**
 * @version V0.1
 * @项目名称：xgt-service
 * @类名称：UserController
 * @类描述：
 * @创建人：justin
 * @创建时间：2020/10/26 16:31
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserInfoController extends BaseController {
    @Autowired
    private IUserInfoService userInfoService;


//    @ResponseBody // 将java对象转为json格式的数据。
//    @RequestMapping("/hello")
//    public String hello(){
//        return "首页";
//    }



    @ApiOperation(value = "分页查询列表", response = ResMsg.class)
    @PostMapping(value = "/queryUserInfoList")
    public ResMsg queryUserInfoList(@RequestBody UserInfoVo userInfoDto) {
        try {
            String msg = validatePageParam(userInfoDto.getPageNum(), userInfoDto.getPageSize());
            if (StringUtils.isNotEmpty(msg)) {
                return error(msg);
            }
            PageInfo<UserInfoModel> list = userInfoService.queryUserInfoList(userInfoDto);
            return success(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常", e);
            return error("系统异常：" + e.getMessage());
        }
    }

    @ApiOperation(value = "保存用户", response = ResMsg.class)
    @ApiOperationSupport(ignoreParameters = {"user.id"})
    @PostMapping(value = "/saveUserInfo")
    public ResMsg saveUserInfo(@RequestBody TUserInfo user) {
        try {
            Integer count = userInfoService.lambdaQuery().eq(TUserInfo::getUserName, user.getUserName()).count();
            if (count > 0) {
                return error("保存失败！用户名：" + user.getUserName() + "已经存在！");
            }
            user.setPassword(PasswordUtil.getMD5(user.getPassword()));
            userInfoService.save(user);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常", e);
            return error("系统异常：" + e.getMessage());
        }
    }

    @ApiOperation(value = "根据ID获取数据", response = ResMsg.class)
    @ApiImplicitParam(name = "id", value = "主键id", dataType = "string", paramType = "query", required = true)
    @GetMapping(value = "/getUserInfoById")
    public ResMsg getUserInfoById(@RequestParam(name = "id") String id) {
        try {
            TUserInfo userInfo = userInfoService.getById(id);
            if (userInfo == null) {
                return error("数据不存在");
            }
            userInfo.setPassword(null);
            return success(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常", e);
            return error("系统异常：" + e.getMessage());
        }
    }

    @ApiOperation(value = "修改用户", response = ResMsg.class)
    @ApiOperationSupport(ignoreParameters = {"user.userName"})
    @PostMapping(value = "/updateUserInfo")
    public ResMsg updateUserInfo(@RequestBody TUserInfo user) {
        try {
            if (StringUtils.isEmpty(user.getId())) {
                return error("参数异常");
            }
            userInfoService.updateById(user);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常", e);
            return error("系统异常：" + e.getMessage());
        }
    }

    @ApiOperation(value = "删除用户", response = ResMsg.class)
    @PostMapping(value = "/deleteUserInfo")
    public ResMsg deleteUserInfo(@RequestBody UserInfoModel userInfoModel) {
        try {
            if (StringUtils.isEmpty(userInfoModel.getId())) {
                return error("参数异常");
            }
            if (StringUtils.equals("admin", userInfoModel.getUserName())) {
                return error("超级管理员【admin】禁止删除！");
            }
            userInfoService.removeById(userInfoModel.getId());
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常", e);
            return error("系统异常：" + e.getMessage());
        }
    }

    @ApiOperation(value = "初始化密码", response = ResMsg.class)
    @PostMapping(value = "/initPassword")
    public ResMsg initPassword(@RequestBody UserInfoModel userInfoModel) {
        try {
            if (StringUtils.isEmpty(userInfoModel.getId())) {
                return error("参数异常");
            }
            userInfoModel.setPassword(PasswordUtil.getMD5("123456"));
            userInfoService.updateById(userInfoModel);
            return success("成功初始化密码为：123456");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常", e);
            return error("系统异常：" + e.getMessage());
        }
    }

    @ApiOperation(value = "修改密码", response = ResMsg.class)
    @PostMapping(value = "/updatePasswordSelf")
    public ResMsg updatePasswordSelf(@RequestBody Map<String, String> userMap) {
        try {
            String userId = userMap.get("userId");
            String userName = userMap.get("userName");
            String oldPwd = userMap.get("oldPwd");
            String newPwd = userMap.get("newPwd");
            if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(userName)
                    || StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(newPwd)) {
                return error("参数异常");
            }
            //根据userId和旧密码验证是否正确
            Integer count = userInfoService.lambdaQuery().eq(TUserInfo::getUserName, userName).eq(TUserInfo::getPassword, PasswordUtil.getMD5(oldPwd)).count();
            if (count == 0) {
                return error("密码修改失败！原因：旧密码不正确！");
            }
            userInfoService.lambdaUpdate().set(TUserInfo::getPassword, PasswordUtil.getMD5(newPwd)).eq(BaseEntity::getId, userId).update();
            return success("密码修改成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("密码修改异常", e);
            return error("系统异常：" + e.getMessage());
        }
    }

    @ApiOperation(value = "获取用户", response = ResMsg.class)
    @PostMapping(value = "/searchUserInfoList")
    public ResMsg searchUserInfoList(@RequestBody UserInfoVo userInfoDto) {
        try {
            List<UserInfoModel> list = userInfoService.searchUserInfoList(userInfoDto);
            return success(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常", e);
            return error("系统异常：" + e.getMessage());
        }
    }

}
