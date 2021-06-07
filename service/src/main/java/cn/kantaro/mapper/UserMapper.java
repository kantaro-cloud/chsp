package cn.kantaro.mapper;


import cn.kantaro.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    User getUserByUserId(@Param("userId")String userId);

    User getUserByEmail(@Param("email") String email);

}
