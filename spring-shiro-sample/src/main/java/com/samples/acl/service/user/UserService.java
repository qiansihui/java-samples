package com.samples.acl.service.user;

import com.samples.acl.service.user.entry.User;

/**
 * @Author qianqian.sun
 * @Date 2018/1/9
 * 描述：
 */
public interface UserService {
    User findByLogin(String login);
}
