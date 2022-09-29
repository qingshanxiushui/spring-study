ch18-spring-web:  完成学生注册功能。

步骤：
1. 新建 maven
2. 修改pom.xml
   spring,mybatis以外的依赖， servlet ， jsp依赖
3. 创建实体类 Student， 对应Student2表
4. 创建dao接口和mapper文件
5. 创建mybatis主配置文件
6. 创建service和实现类
7. 创建servlet，接收请求的参数，调用service对象
8. 创建jsp，提交请求参数
9. 创建jsp，作为视图，显示请求的处理结果
10.创建spring配置文件