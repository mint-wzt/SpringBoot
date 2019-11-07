package com.wzt.springboot.springboot.service;

import com.wzt.springboot.springboot.model.SysUser;
import com.wzt.springboot.springboot.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s){
        SysUser user = userRepository.findByUsername(s);
        if (user == null){
            throw new  UsernameNotFoundException("用户名不存在！");
        }
        return user;
    }
}
