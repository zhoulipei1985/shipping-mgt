package com.cn.zlp.security.common.exception;

import org.springframework.security.core.AuthenticationException;


public class LoginException  extends AuthenticationException {

    public LoginException(String msg) {
        super(msg);
    }
}
