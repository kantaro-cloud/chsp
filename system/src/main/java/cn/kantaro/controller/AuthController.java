package cn.kantaro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthController {

    /**
     * 跳转首页
     */
    @GetMapping("")
    public void index1(HttpServletResponse response){
        //内部重定向
        try {
            response.sendRedirect("/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "登录成功";
    }

    @RequestMapping("/loginError")
    @ResponseBody
    public String loginError() {
        return "登录失败";
    }

    @RequestMapping("/loginPage")
    public String login() {
        return "login_page";
    }

    /**
     * 为了方便测试，我们调整添加另一个控制器 /whoim 的代码 ，让他返回当前登录的用户信息，
     * 前面说了，他是存在SecurityContextHolder 的全局变量中，所以我们可以这样获取
     */
    @RequestMapping("/whoim")
    @ResponseBody
    @PreAuthorize("@el.check('user','admin:list')")
    public Object whoIm()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}