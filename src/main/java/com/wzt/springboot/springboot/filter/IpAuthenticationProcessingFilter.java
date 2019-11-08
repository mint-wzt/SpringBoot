package com.wzt.springboot.springboot.filter;

import com.wzt.springboot.springboot.token.IpAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IpAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    //使用/ipVerify该端点进行ip认证
    public IpAuthenticationProcessingFilter(){
        super(new AntPathRequestMatcher("/ipVerify"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException {
        //获取host信息
        String host = httpServletRequest.getRemoteHost();

        //交给内部的AuthenticationManager去认证，实现解耦
        return getAuthenticationManager().authenticate(new IpAuthenticationToken(host));
    }
}
