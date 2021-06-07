package cn.kantaro.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.kantaro.entity.User;
import cn.kantaro.mapper.UserMapper;
import cn.kantaro.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByUserId(String userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public Boolean insertUser(User user) throws Exception {
        User use = userMapper.getUserByEmail(user.getEmail());
        if (use != null) {
            throw new Exception("账号已存在");
        }
        Date now = new Date();
        User newUser = new User();
        newUser.setUserId(IdUtil.simpleUUID());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
        newUser.setRole(0);
        newUser.setStatus(user.getStatus());
        newUser.setCreateTime(now);
        return userMapper.insert(newUser) == 1;
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }
}