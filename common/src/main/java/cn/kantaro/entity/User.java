package cn.kantaro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@TableName("tb_user")
public class User implements Serializable {

    @TableField(value = "user_id")
    private String userId;

    private String username;

    private String password;

    private String email;

    private String phone;

    private Integer role;

    private Integer status;

    @TableField(value = "create_time")
    private Date createTime;


    @Override
    public String toString() {
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", createTime=" + sdf.format(createTime) +
                '}';
    }
}
