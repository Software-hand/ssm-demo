package com.biz.demo.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.biz.demo.web.entity.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @version V0.1
 * @项目名称：xgt-service
 * @类名称：TUser
 * @类描述：
 * @创建人：justin
 * @创建时间：2020/10/26 16:22
 */
@Getter
@Setter // 拥有相应方法
@TableName("t_user_info") // 数据库表名
@Service  // Spring容器管理 实体类
public class TUserInfo extends BaseEntity {
    // knife4j    required = true :必填
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @ApiModelProperty(value = "姓名", required = true)
    private String realName;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "联系电话")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "生日")
    private String birthday;
    @ApiModelProperty(value = "性别：0：女，1：男")
    private String sex;
    @ApiModelProperty(value = "启禁用：0：启用，1：禁用")
    private String lockFlag;

}
