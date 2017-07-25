#sql开发技巧之一

常见的sql语句类型

![](http://i.imgur.com/12nkRf7.png)

![](http://i.imgur.com/58fyrFw.png)

DDL  数据定义语言

TPL  事务处理语言

DCL  数据控制语言

DML  数据操作语言

#sql 语言介绍

     正确使用SQL很重要吗？

增加数据库处理效率，减少应用相应时间

减少数据库服务器负载，增加服务器稳定

减少服务器间通讯网络流量

#如何正确使用join从句

![](http://i.imgur.com/0HqEvNN.png)


![](http://i.imgur.com/0Myc16E.png)

--  创建数据库

-- create  database mooc

use mooc

-- 创建表

create TABLE user1(

 `id` BIGINT(20) not NULL auto_increment,

 `user_name` VARCHAR(255) DEFAULT null,

 PRIMARY KEY(`id`)

)ENGINE=INNODB DEFAULT CHARSET=utf8;


-- 语句添加

INSERT into user1 (`id`,`user_name`)VALUE(1,'唐僧'),
(2,'悟空'),(3,'八戒'),(4,'沙僧')


-- 表二

create TABLE user2(

 `id` BIGINT(20) not NULL auto_increment,

 `user_name` VARCHAR(255) DEFAULT null,

 PRIMARY KEY(`id`)

)ENGINE=INNODB DEFAULT CHARSET=utf8;

-- 表二语句添加

insert into user2(`id`,`user_name`)value(1,'悟空'),

(2,'牛魔王'),(3,'牛二王'),(4,'牛三王'),(5,'铁扇公主')

 
-- 内连接

 select  a.user_name, a.over,b.over from user1 a  INNER JOIN user2 b where a.user_name = b.user_name
#左外连接
 
![](http://i.imgur.com/mo2IK6E.png)


-- 左外连接

select a.user_name,a.over ,b.over from user1 a LEFT JOIN user2 b ON a.user_name = b.user_name where b.user_name is not NULL

-表1 left join  表二 on 1.=2.  左外连接以左边表为准,用where 条件过滤

![](http://i.imgur.com/Sx3yEGH.png)
