 **介绍** 

Springboot微服务架构项目集合

 **架构说明** 

前端使用基本的三件套：HTML，CSS,JS

后端使用Springboot + MybatisPlus + Thymeleaf + shiro

数据源使用Druid，并开启其后台监控中心

使用阿里云OSS存储技术，用于存储博主头像，博客首图


 **工程结构说明** 

将三层架构分为三个模块进行多模块开发，且将每个项目也按照三层架构分别分入其中：

Dao_Tier ---  数据访问层

    Blog_Dao --- 个人博客项目的dao层

        entity --- 个人博客实体类

        mapper --- 对象持久化映射层

        swagger -- 接口测试


Service_Tier --- 业务逻辑层

    Blog_Service --- 个人博客的service层

        service（Impl） -- 业务层实现类和接口类

        utils --- 工具类


Web_Tier --- 表现层

    config --- 配置类

    controller --- 控制层（与前端进行数据传输）

    handler --- 数据库字段处理


 **网站首页展示** 

![网站首页](https://images.gitee.com/uploads/images/2021/0306/152701_701ef5c3_8359876.png "网站首页.PNG")



 **博客项目首页展示** 

![博客首页](https://images.gitee.com/uploads/images/2021/0306/152852_e733676c_8359876.png "博客首页.PNG")



 **博主信息展示** 

![博主信息](https://images.gitee.com/uploads/images/2021/0306/155814_f4c810d7_8359876.png "博主信息.PNG")

