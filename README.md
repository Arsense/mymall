# mymall
mall商城购物系统学习

始于2019-10-15

# 项目结构

- mymall-admin 管理端  (因为不是RPC服务 所以service还是集成到端) 开发基本完成
- mymall-dao 数据库底层操作
- mymall-domain 基本属性类
- mymall-shop 商品前台及接口
运行后访问
Api文档:  http://localhost:8081/swagger-ui.html
端口是配置在application.yml


##  引用技术

技术 | 说明 | 官网
----|----|----
Spring Boot | 容器+MVC框架 | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
MyBatis | ORM框架  | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)
MyBatisGenerator | 数据层代码生成 | [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html)
PageHelper | MyBatis物理分页插件 | [http://git.oschina.net/free/Mybatis_PageHelper](http://git.oschina.net/free/Mybatis_PageHelper)
Swagger-UI | 文档生产工具 | [https://github.com/swagger-api/swagger-ui](https://github.com/swagger-api/swagger-ui)
Redis | 分布式缓存 | [https://redis.io/](https://redis.io/)
JWT | JWT登录支持 | [https://github.com/jwtk/jjwt](https://github.com/jwtk/jjwt)
Lombok | 简化对象封装工具 | [https://github.com/rzwitserloot/lombok](https://github.com/rzwitserloot/lombok)
## 功能设计

## 一 商品管理
## 二 品牌管理
## 二  订单
## 三 营销管理
## 四 用户权限



## 待完成
@Validated 与 与@Empty之类校验没加    
权限控制没加

#problem
- 没有全局异常处理
- 日志打印追踪一般般

## 项目进度 
总体进度：35%   3.1w/8w

## 目标

门槛 :对数据结构与技术栈做个总结
挑战: 1. 扩展几个功能
     2. 创建多个用户做渗透测试
## 参考
前端部署参考:
https://juejin.im/post/5d2c7c6b518825076377d7b9
