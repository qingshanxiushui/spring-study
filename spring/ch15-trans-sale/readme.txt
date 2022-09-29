ch15-trans-sale: 购买商品。 默认事务的处理

1.新建库，表sale和goods
2.创建maven项目
3.加入gav
   spring依赖， mybatis依赖， mysql驱动。 junit依赖
   mybatis-spring依赖（mybatis网站上提供的，用来在spring项目中，创建mybatis对象）
   spring有关事务的依赖。

4.创建实体类 Sale ，Goods
5.创建dao接口和mapper文件
  SaleDao
  GoodsDao
  两个mapper文件

6.创建mybatis主配置文件

7.创建service接口和他的实现类， 实现buy的方法。

8.创建spring的配置文件
  声明数据源
  声明SqlSessionFactoryBean
  声明dao代理的对象
  声明自定义service对象

9.测试