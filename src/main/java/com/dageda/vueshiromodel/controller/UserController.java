package com.dageda.vueshiromodel.controller;

import com.dageda.vueshiromodel.entity.shiro.LoginInfo;
import com.dageda.vueshiromodel.entity.shiro.User;
import com.dageda.vueshiromodel.service.userservice.UserService;
import com.dageda.vueshiromodel.util.Ciphertext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.io.SerializationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description:
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private UserService userService;

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unAuth")
    public Map unAuth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "未登录");
        return map;
    }

    /**
     * 未授权
     * @return
     */
    @RequestMapping(value = "/noAuth")
    public Map noAuth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "未授权");
        return map;
    }
    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public Map login(String nickname, String password, HttpServletRequest request) {
        //调用写好的     计算密文获取
        System.out.println(Ciphertext.getCiphertext(password, nickname));
        Map<String, Object> map = new HashMap();
        /**
         * 使用Shiro编写认证操作
         */
        //1.获得subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(nickname, password);
        // 记住
        token.setRememberMe(true);
        //3. 执行登录方法
        try {
            subject.login(token);
            //验证是否登录成功
            if (subject.isAuthenticated()) {
                User user = (User) subject.getPrincipal();
                request.getSession().setAttribute("user", user);
                LoginInfo loginInfo = userService.getLoginInfo(user.getId());
                logger.info("登录成功！");
                //登录成功
                map.put("msg", "登录成功");
                map.put("success", loginInfo);
            }
        } catch (UnknownAccountException e) {
            //用户名不存在 ，登录失败
            map.put("msg", "用户名不存在");
        } catch (IncorrectCredentialsException e) {
            //密码错误 ，登录失败
            map.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            //账号被锁定 ，登录失败
            map.put("msg", "账号被锁定");
        } catch (SerializationException e) {
            //序列化
            map.put("msg", "序列化异常");
        }
        return map;
    }
}
