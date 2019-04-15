package com.shsxt.service;

import com.shsxt.base.BaseService;
import com.shsxt.dao.UserMapper;
import com.shsxt.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xlf on 2019/4/15.
 */
@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;
}
