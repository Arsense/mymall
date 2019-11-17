package com.macro.mymall.shop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tangwei
 * @date 2019/11/18 1:53
 */

@Configuration
@EnableTransactionManagement
@MapperScan({"com.macro.mapper","com.macro.mymall.shop.dao"})
public class MyBatisConfig {
}
