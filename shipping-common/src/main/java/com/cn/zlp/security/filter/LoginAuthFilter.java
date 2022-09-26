package com.cn.zlp.security.filter;


import com.cn.zlp.security.common.dto.model.UserInfo;
import com.cn.zlp.security.common.exception.LoginException;
import com.cn.zlp.security.common.util.JwtTokenUtil;
import com.cn.zlp.security.common.util.RedisClient;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginAuthFilter extends OncePerRequestFilter {

    @Autowired
    private RedisClient redisClient;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token=request.getHeader("token");
        if(StringUtil.isNullOrEmpty(token)){
            filterChain.doFilter(request,response);
            return ;
        }
        //使用jwt解析token
       String userid_key= JwtTokenUtil.parse(token);

        // 从redis根据userid是否存在

        UserInfo  userInfo= redisClient.getObject(userid_key,UserInfo.class);
        if(userInfo==null){
            throw new LoginException("用户不存在或者没有登录");
        }

        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userInfo,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);


    }
}
