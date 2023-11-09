### 前后端项目搭建

构建前端 Vue 框架: [教程](https://learner.blog.csdn.net/article/details/88926242) *Vue + SpringBoot项目的教程，非常推荐看一看*

构建后端 SSM 框架：[教程](https://yichun.blog.csdn.net/article/details/100192558) *非常详细的介绍SSM的整合过程*

选用SSM而不是SpringBoot的原因是，感觉SSM更自由，而且本项目采用的配置方式并没有很复杂。

### 前端项目中各配置文件

1. `/src/main.js` 设置全局注册变量、引入第三方工具（Element UI、store）。
2. `/src/router/index.js` 配置页面路由，每个路由对象都包含了路径（`path`），名称（`name`）和组件（`component`）的配置。其中，`path`表示URL路径，`name`是路由的名称，`component`是该路径对应的组件。
3. `/config/index.js` 配置proxy代理（包括后端接口地址）、Vue项目的地址和端口。
4. `/src/App.vue` 根组件，所有的组件都会被装在这个组件中
5. `/src/store/index.js` 配置vuex

### 后端软件包分层结构

1. `org.example`（或你的公司域名反转）：顶级包，用于放置整个项目的基础设施和通用代码。
2. `org.example.controller`：存放控制器（Controller）类，用于接收和处理前端请求，协调业务逻辑的调用，并返回响应结果。
3. `org.example.service`：存放服务（Service）类，用于实现业务逻辑的具体处理，可以调用数据访问层（DAO）进行数据操作。
4. `org.example.dao`：存放数据访问层（DAO）类，用于数据库的操作和访问。
5. `org.example.model`（或`org.example.entity`）：存放数据模型（Model）或实体（Entity）类，用于表示业务对象和数据库表的映射关系。
6. `org.example.util`：存放项目中的工具类，如日期处理、文件操作等通用的辅助类。
7. `org.example.exception`：存放项目中的异常类，用于处理异常情况并返回合适的错误信息。
8. `org.example.vo`：存放值对象（Value Object）或数据传输对象（DTO），用于在前后端之间传递数据。

### 前端项目使用时需要修改的地方

1. 修改 `/config/index.js` 中 *代理的模板地址（后端地址）* 即`proxyTable`中的`target`字段

2. 修改 `/config/index.js` 中的 `host`和`port` *即前端地址和端口*

### 后端项目使用时需要修改的地方

1. 修改 *顶级包* 的包名，检查 `/resources/applicationContext.xml` 、`/resources/springmvc.xml`、`/resources/SqlMapConfig.xml` 中对应的包名是否正确。

2. 修改 `/resources/applicationContext.xml` 、`/resources/SqlMapConfig.xml` 中的数据库连接池信息：

   8.x版本的MySQL，则驱动为 `com.mysql.cj.jdbc.Driver`，

   5.x版本的MySQL，则驱动为 `com.mysql.jdbc.Driver`。

3. 修改 `pom.xml` 中 `<properties></properties>` 中的 `mysql.version` 为本地的MySQL版本。修改项目基本信息 `<groupId>org.example</groupId> <artifactId>Spring-Demo</artifactId>`

### 已实现/解决的功能

1. 以标签页-卡片的形式来展示页面，方便切换
2. 前端登录拦截器
3. 跨域问题

### 待实现/解决的问题

1. 跨域后导致后端session失效
2. 整合websocket
3. 整合Log4j2
4. 拦截器
5. Redis
6. 任务调度框架(Quartz或Spring Task）

### 更新日志

**2023-06-05**  新增工具类`ObjectUtil.haveEmpty` 

作用：对参数object中的属性进行判断，如果**属性类型为String且为空串**，则返回`Result.error`，错误代码为201。