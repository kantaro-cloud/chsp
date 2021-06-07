package cn.kantaro.service;

import cn.kantaro.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {

    User getUserByUserId(String id);

    Boolean insertUser(User user) throws Exception;

    User getUserByEmail(String email);
}
