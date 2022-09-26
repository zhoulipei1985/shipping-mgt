package com.cn.zlp.shipping.mgt.service;



import com.alibaba.fastjson2.JSON;
import com.cn.zlp.mapper.TbUserinfoMapper;
import com.cn.zlp.security.common.dto.model.UserInfo;
import com.cn.zlp.security.common.dto.vo.UserVo;
import com.cn.zlp.security.common.util.JwtTokenUtil;
import com.cn.zlp.security.common.util.RedisClient;
import com.cn.zlp.user.pojo.TbUserinfo;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class UserService  {
    private long tokenEcpiration = 24*60*60*1000;
    //编码秘钥
    private String tokenSignKey = "123456";
    @Autowired
    private RedisClient redisClient;

    @Autowired
    private TbUserinfoMapper userinfoMapper;
    @Autowired
    AuthenticationManager authenticationManager;
    public String sayHello(){

        return "hello,world";
    }
    public String login(UserVo userVo){
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userVo.getUserName(), userVo.getPassword());
        Authentication authentication=authenticationManager.authenticate(authRequest);
        if(null==authentication){
            System.out.println("用户不存在");
            throw new InternalAuthenticationServiceException("登录失败");

        }
         UserInfo  userInfo =(UserInfo)authentication.getPrincipal();
        //String json=JSON.toJSONString(userInfo.getUser());
        //redisClient.add(userInfo.getUser().getUserId(),userInfo.getUser());
        redisClient.add(userInfo.getUser().getUserId(),userInfo,15*60 ,TimeUnit.SECONDS);

        //disTemplate.opsForValue().set("hello_"+userInfo.getUsername(),json);
         String token=JwtTokenUtil.create(String.valueOf(userInfo.getUser().getUserId()));

        return token;
    }
   public void addUser(TbUserinfo userinfo){
       userinfoMapper.insertSelective(userinfo);
   }

   public TbUserinfo queryUserByName(String userName) {
       return  userinfoMapper.selectByUserName(userName);

   }

}
