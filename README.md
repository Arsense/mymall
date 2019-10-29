# mymall
mall商城购物系统学习

始于2019-10-15

# 项目结构

- mymall-admin 管理端  (因为不是RPC服务 所以service还是集成到端)
- mymall-dao 数据库底层操作
- mymall-domain 基本属性类
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

### 1. 商品查询
-  商品分类查询  完成
-  新品推荐状态更改 完成
-  推荐状态状态更改 完成
### 2 商品添加
-  基本属性的商品添加 完成

           
2. 商品分类管理
 -  商品分页查询 完成
 -  商品分类添加 完成
 -  修改导航栏状态 完成
 -  修改显示栏状态 完成
 -  删除商品分类 完成
 
### 3 商品类型
-  类型列表展示 完成
-  类型编辑 完成
-  类型添加 完成
-  类型删除 完成

### 4 商品属性列表

-  属性列表展示 完成
-  商品属性添加 完成
-  商品属性删除 完成
-  商品属性更新 完成
商品参数列表不知道干啥

### 品牌管理
- 品牌列表展示 完成
- 品牌添加  需要阿里云配置OSS上传
- 批量修改品牌制造商 完成
- 批量修改是否显示状态 完成
    
## 二  订单
### 1.订单管理
-  订单列表查询 完成
### 订单设置
-  订单设置查询 完成
### 3 退货申请处理
- 退货申请分页查询 完成
### 4 退货原因设置
- 退货原因分页查询 完成


## 三 营销管理


## 四 用户权限
-  用户登录 完成
-  用户鉴权 完成


## 待完成
@Validated 与 与@Empty之类校验没加    
权限控制没加

#problem
- 没有全局异常处理
- 日志打印追踪一般般

## 项目进度 

总体进度：26.2%   21007/8w


## 参考
前端部署参考:
https://juejin.im/post/5d2c7c6b518825076377d7b9
