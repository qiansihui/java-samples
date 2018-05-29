package com.samples.acl.service.user.impl;

import com.samples.acl.service.user.UserService;
import com.samples.acl.service.user.entry.User;
import org.springframework.stereotype.Service;

/**
 * @Author qianqian.sun
 * @Date 2018/1/9
 * 描述：
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findByLogin(String login) {
        User user = new User();
        user.setLogin("user");
        user.setPassword("123");
        return user;
    }

}
