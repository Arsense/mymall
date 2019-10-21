package com.macro.mymall.admin.service.impl;

import com.macro.mymall.admin.service.UmsAdminService;
import com.macro.mymall.admin.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

/**
 * @author tangwei
 * @date 2019/10/18 18:40
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public String login(@NotEmpty(message = "用户名不能为空") String username, @NotEmpty(message = "密码不能为空") String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
                token = jwtTokenUtil.generateToken(userDetails);
            //更新登陆时间
//            updateLoginTimeByUsername(username);
//            insertLoginLog(username);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
