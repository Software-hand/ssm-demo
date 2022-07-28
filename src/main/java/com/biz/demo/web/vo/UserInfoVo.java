package com.biz.demo.web.vo;

import com.biz.demo.web.model.base.BasePage;
import lombok.Getter;
import lombok.Setter;

/**
 * 描述：
 * @version 1.0
 * @author： justin
 * @date： 2022-06-13 15:07:17
 */
@Getter
@Setter
public class UserInfoVo extends BasePage {
      private String userName;
      private String realName;
      private String phone;
      private String lockFlag;
}
