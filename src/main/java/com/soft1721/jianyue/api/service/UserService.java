package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;

public interface UserService {

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    User getUserByMobile(String mobile);

    /**
     * 登录方法
     *
     * @param userDTO
     * @return boolean
     */
    int signIn(UserDTO userDTO);

    void updateUser(User user);

    User getUserById(int userId);


    /**
     * 用户注册方法
     * @param userDTO
     * @return int
     */
    void signUp(UserDTO userDTO);

}
