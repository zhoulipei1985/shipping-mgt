package com.cn.zlp.security.common.dto.vo;

import java.io.Serializable;

public class UserVo implements Serializable {

    /**
     * 密碼
     */
    public String password;
    /**
     * 用戶名
     */
    public String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
