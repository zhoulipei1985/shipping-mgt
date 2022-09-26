package com.cn.zlp.security.common.util;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenUtilTest {
    @Test
    public void test(){
//        String token=JwtTokenUtil.create("123");
//        System.out.println("JwtTokenUtilTest.test"+token);
//       String subject= JwtTokenUtil.parse("eyJhbGciOiJIUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSqspIzEsvTsxT0lHKTCxRsjI0MzUyNzQ2NzHWUUqtKEASsKgFAN6C13U0AAAA.ngUlr6Rl8Heei9G5YQ6SHruLYEJM53YeBGW5glLkHyU");
//        System.out.println("JwtTokenUtilTest.test"+subject);
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println(new BCryptPasswordEncoder().matches("123456","$2a$10$xmYKerCOMX84G8HwRA7DZ.29TrTrBO57UvKSvxAlwyC4xKIigIMIG"));
    }

}