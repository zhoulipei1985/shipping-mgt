package com.cn.zlp.security.common.util;


import io.jsonwebtoken.*;

import java.io.Serializable;
import java.util.Date;



public class JwtTokenUtil implements Serializable {
    private static long tokenEcpiration = 24*60*60*1000;
    public static String create(String subject) {
        JwtBuilder jwtBuilder = Jwts.builder(); //获得JWT构造器

        return jwtBuilder.setSubject(subject) //设置用户数据
                .setIssuedAt(new Date()) //设置jwt生成时间
                .setExpiration(new Date(System.currentTimeMillis()+tokenEcpiration))//设置token有效期
                .signWith(SignatureAlgorithm.HS256, "123456") //设置token加密方式和密码
                .compressWith(CompressionCodecs.GZIP)
                .compact();

    }

    public static String parse(String token) {
        if (token != null) {
            JwtParser jwtParser = Jwts.parser(); //获取jwt解析器
            jwtParser.setSigningKey("123456");
            try {
                //如果token正确(密码，有效期)则正常运行，否则抛出异常
                Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
                Claims body = claimsJws.getBody();//获取body
                String subject = body.getSubject();//获取body中subject中的值

                return subject;
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }
}
