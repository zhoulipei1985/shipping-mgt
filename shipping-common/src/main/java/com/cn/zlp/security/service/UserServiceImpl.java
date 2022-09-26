package com.cn.zlp.security.service;

import com.cn.zlp.mapper.TbUserinfoMapper;
import com.cn.zlp.security.common.dto.model.UserInfo;
import com.cn.zlp.user.pojo.TbUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired

    private TbUserinfoMapper userinfoMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("管理员信息1："+username);
        TbUserinfo user=  userinfoMapper.selectByUserName(username);
        //System.out.println("管理员信息："+user.getUserName()+"   "+new BCryptPasswordEncoder().encode(user.getPassword()));
        if (Objects.isNull(user)){
            System.out.println("用户不存在123");
            throw new InternalAuthenticationServiceException("用户名或者密码错误");
        }
        System.out.println("管理员信息："+user.getUserName()+"   "+user.getPassword());
        //user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return new UserInfo(user);
    }
}
