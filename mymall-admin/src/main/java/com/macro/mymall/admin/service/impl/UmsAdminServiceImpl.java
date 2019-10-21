package com.macro.mymall.admin.service.impl;

import com.macro.domain.model.ums.UmsAdmin;
import com.macro.domain.model.ums.UmsAdminExample;
import com.macro.domain.model.ums.UmsPermission;
import com.macro.mapper.UmsAdminMapper;
import com.macro.mapper.UmsPermissionMapper;
import com.macro.mymall.admin.service.UmsAdminService;
import com.macro.mymall.admin.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author tangwei
 * @date 2019/10/18 18:40
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    /**
     * 权限认证的service
     */
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UmsAdminMapper adminMapper;

    @Autowired
    private UmsPermissionMapper umsPermissionMapper;


    @Override
    public String login(@NotEmpty(message = "用户名不能为空") String username, @NotEmpty(message = "密码不能为空") String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

//            if(!passwordEncoder.matches(password,userDetails.getPassword())){
//                throw new BadCredentialsException("密码不正确");
//            }

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            //更新登陆时间
//            updateLoginTimeByUsername(username);
//            insertLoginLog(username);

        } catch (Exception e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample adminExample = new UmsAdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> umsAdmin = adminMapper.selectByExample(adminExample);
        if (!CollectionUtils.isEmpty(umsAdmin)) {
            return umsAdmin.get(0);
        }
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long id) {
        return umsPermissionMapper.getPermissionList(id);
    }
}
