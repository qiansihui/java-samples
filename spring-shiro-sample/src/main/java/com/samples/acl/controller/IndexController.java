package com.samples.acl.controller;

import com.samples.acl.service.user.entry.User;
import com.samples.acl.shiro.CurrentUser;
import com.samples.acl.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author qianqian.sun
 * @Date 2017/5/27
 * 描述：
 */
@Controller
@Slf4j
public class IndexController {


    @RequestMapping("/")
    public String index() {
        return "login";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }


    @RequestMapping("/auth")
    @ResponseBody
    public ResultVO auth(@RequestParam("login") String login, @RequestParam("password") String password) {
        ResultVO resultVO = new ResultVO(true);
        //验证登录
        AuthenticationToken token = new UsernamePasswordToken(login, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            resultVO.setUrl("/home");
        } catch (AuthenticationException e) {
            resultVO.setOk(false);
            resultVO.setMsg("账号或者密码错误");
            return resultVO;
        }
        return resultVO;
    }


    @RequestMapping("/home")
    public String home(@CurrentUser User user, Model model) {
        log.info("进入主页，用户:{}", user.getLogin());
        model.addAttribute("name", user.getLogin());
        return "home";
    }

}
