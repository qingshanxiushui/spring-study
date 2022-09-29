ch14-spring-mybatis: spring集成mybatis

实现步骤：
1.使用的mysql库， 使用学生表 student2(id int 主键列， 自动增长，
                                    name varchar(80),
                                    age int)

2.创建maven项目

3.加入依赖gav
  spring依赖， mybatis依赖， mysql驱动。 junit依赖
  mybatis-spring依赖（mybatis网站上提供的，用来在spring项目中，创建mybatis对象）
  spring有关事务的依赖。


  mybatis和spring整合的时候， 事务是自动提交的。

4.创建实体类Student

5.创建Dao接口和mapper文件写sql语句

6.写mybatis主配置文件

7.创建service接口和他的实现类

8.创建spring的配置文件
  1）声明数据源DataSource,使用的阿里的Druid连接池
  2) 声明SqlSessionFactoryBean类，在这个类内部创建的是SqlSessionFactory对象。
  3）声明MapperScannerConfiguration类，在内部创建dao代理对象，
     创建的对象都放在spring容器中。

  4）声明Service对象，把3）的中dao赋值给service属性

9.测试dao访问数据库