package com.cn.zlp.security.common.dto.model;

import com.cn.zlp.user.pojo.TbUserinfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserInfo implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public TbUserinfo getUser() {
        return user;
    }

    public void setUser(TbUserinfo user) {
        this.user = user;
    }

    TbUserinfo user;
    public UserInfo(TbUserinfo user){
        this.user=user;

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
