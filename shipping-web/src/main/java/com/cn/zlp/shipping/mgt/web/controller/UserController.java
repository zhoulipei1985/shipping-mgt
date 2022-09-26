package com.cn.zlp.shipping.mgt.web.controller;

import com.cn.zlp.security.common.annotation.Wession;
import com.cn.zlp.security.common.dto.vo.UserVo;
import com.cn.zlp.shipping.mgt.service.UserService;
import com.cn.zlp.user.pojo.TbUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

;import java.util.Date;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")

    public Object hello()  {
        return userService.sayHello();
    }

    @GetMapping("/login")

    public String login(  UserVo userVo)  {
        return userService.login(userVo);
    }
    @GetMapping("/register")
    public String registerUser(){

        TbUserinfo tbUserinfo=new TbUserinfo();
        tbUserinfo.setPassword("123456");
        tbUserinfo.setUserId(1223);
        tbUserinfo.setUserName("zhaoqian123");
        tbUserinfo.setAddress("广东深圳");
        tbUserinfo.setAge(20);
        tbUserinfo.setUpdateDate(new Date());
        tbUserinfo.setMobliePhone("1363279026");
        tbUserinfo.setCreatedBy("system");
        tbUserinfo.setUpdateBy("system");
        tbUserinfo.setCreatedDate(new Date());
        userService.addUser(tbUserinfo);

        return "";

    }

    @GetMapping("/query")
    @ResponseBody
    public Object queryUser(String username){


        TbUserinfo tbUserinfo=userService.queryUserByName(username);

        return tbUserinfo;

    }
}
