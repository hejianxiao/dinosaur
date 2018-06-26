package com.app.entity.sys;

import com.app.entity.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 创建人: Hjx
 * Date: 2018/6/13
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends SuperEntity<User> {

    private String name;

    private String userName;

    private String password;

    private String salt;

    private String status;

    private Date createTime;

    private Date updateTime;

}
