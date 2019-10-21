package com.macro.mymall.admin.config;

import com.macro.mymall.admin.permit.JwtAuthenticationTokenFilter;
import com.macro.mymall.admin.permit.RestAuthenticationEntryPoint;
import com.macro.mymall.admin.permit.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * EnableWebSecurity spring-security 开启才会生效
 * Spring Security默认是禁用注解的，要想开启注解， 需要在继承WebSecurityConfigurerAdapter的类上加@EnableGlobalMethodSecurity注解， 来判断用户对某个控制层的方法是否具有访问权限
 *
 * @author tangwei
 * @date 2019/10/16 18:32
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
//
//    @Autowired
//    private UmsAdminService adminService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;



    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()  //由于使用的是JWT 可以不要csrf,  sessionManagement基于token, 所以不需要session
                    .disable()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                     //允许对于网站静态资源的无授权访问
                    .antMatchers(HttpMethod.GET,
                            "/",
                            "/*.html",
                            "/favicon.ico",
                            "/**/*.html",
                            "/**/*.css",
                            "/**/*.js",
                            "/swagger-resources/**",
                            "/v2/api-docs/**"
                    )
                .permitAll()
                //对登陆注册要允许匿名访问
                .antMatchers("/admin/login","/admin/register")
                .permitAll()
                //跨域请求会先进行一次options请求
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                //测试时全部可以访问
                .antMatchers("/**")
                .permitAll()
                //除上面外的所有请求全部需要鉴权认真
                .anyRequest()
                .authenticated();
        //禁用缓存
        httpSecurity.headers().cacheControl();
        //添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权与未登陆结果返回
        httpSecurity.exceptionHandling()
                    .accessDeniedHandler(restfulAccessDeniedHandler)
                    .authenticationEntryPoint(restAuthenticationEntryPoint);

    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 注入加解密的类
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
