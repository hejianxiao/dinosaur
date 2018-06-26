package com.app.service.sys.impl;

import com.app.entity.sys.User;
import com.app.mapper.sys.UserMapper;
import com.app.service.sys.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 创建人: Hjx
 * Date: 2018/6/13
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
