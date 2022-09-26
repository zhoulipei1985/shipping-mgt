package com.cn.zlp.shipping.mgt.web.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSigner;
import com.cn.zlp.security.common.util.JwtTokenUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Test
    public void test(){
        String token =JwtTokenUtil.create("zhangsan");
        System.out.println("================"+token);
    }
}