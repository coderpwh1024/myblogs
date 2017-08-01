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

# 使用join更新表

UPDATE user1 a JOIN (select b.`user_name`  from user1 a  INNER JOIN  user2 b on a.`user_name` = b.`user_name`) c
on a.user_name = c.user_name SET a.over = '齐天大圣' 

其中用到子查询语句 select b.`user_name`  from user1 a  INNER JOIN  user2 b on a.`user_name` = b.`user_name` 

![](http://i.imgur.com/wI0K1Ax.png)


 -- 查询时间 0.004s
select  a.`user_name` ,a.`over` ,(select b.over from user2 b where a.user_name =b.user_name) as overd  
from user1 a 

--  JOIN 优化 查询时间 0.003

select  a.`user_name` ,a.`over` ,b.`over` as over2 from user1 a LEFT JOIN user2 b
on a.user_name = b.user_name

代码部分截图:

![](http://i.imgur.com/U3yPvn5.png)


#聚合子查询优化

![](http://i.imgur.com/AQkZXSc.png)


创建表的脚本

CREATE TABLE `NewTable` (

`id`  int NOT NULL ,

`user_id`  int NOT NULL ,

`timestr`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP ,

`kills`  int NULL ,

PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1;


添加语句脚本

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES('1', '2', '2017-07-27 21:54:02', '10');

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES ('2', '2', '2017-07-20 21:54:27', '2');

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES ('3', '2', '2017-07-12 21:54:39', '12');

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES ('4', '4', '2017-07-27 21:54:57', '3');

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES ('5', '2', '2017-07-26 21:55:13', '5');

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES ('6', '2', '2017-07-19 21:55:27', '1');

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES ('7', '3', '2017-07-19 21:55:42', '20');

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES ('8', '2', '2017-07-12 21:55:56', '10');

INSERT INTO `mooc`.`user_kills` (`id`, `user_id`, `timestr`, `kills`) VALUES ('9', '2', '2017-07-26 21:56:09', '17');

![](http://i.imgur.com/AVyV6VK.png)


--  聚合查询 

-- 查询出四人组合中打怪 最多的日期  0.001s

select  a.`user_name`,a.`over` ,b.kills from user1 a  LEFT JOIN  user_kills  b on a.id = b.user_id

where b.kills=( select max(kills) from user_kills c WHERE c.user_id = b.user_id)  


 -- join 使用子查询

select a.`user_name`,a.`over`,b.kills from user1 a join user_kills b  on a.id = b.user_id

join user_kills c ON c.user_id = b.user_id

GROUP BY  b.timestr,a.user_name ,a.over HAVING b.kills = MAX(c.kills)

 数据量大时两者的区别就出来的了

![](http://i.imgur.com/3pzUmgQ.png)



#SQL开发技巧 行列转换

如何进行行列转换

如何生成唯一序列号

如何删除重复数据


#1.如何进行行列转换

需要进行行列转换的场景

报表统计

汇总显示

 二行二列

select  a.`user_name` 姓名,  sum(b.kills) as  数量 from user1 a  JOIN user_kills b  on  b.`user_id` = a.id
GROUP BY a.`user_name`



select     sum(b.kills) as 悟空   from user1 a  JOIN user_kills b  on  b.`user_id` = a.id
 where  a.`user_name` = '悟空'

select     sum(b.kills) as 八戒   from user1 a  JOIN user_kills b  on  b.`user_id` = a.id
 where  a.`user_name` = '八戒'

select     sum(b.kills) as 沙僧   from user1 a  JOIN user_kills b  on  b.`user_id` = a.id
 where  a.`user_name` = '沙僧'

 cross join  交集

select * from (

select     sum(b.kills) as 悟空   from user1 a  JOIN user_kills b  on  b.`user_id` = a.id
 where  a.`user_name` = '悟空'
) a CROSS JOIN

(
select     sum(b.kills) as 八戒   from user1 a  JOIN user_kills b  on  b.`user_id` = a.id
 where  a.`user_name` = '八戒'
) b CROSS JOIN

(
select     sum(b.kills) as 沙僧   from user1 a  JOIN user_kills b  on  b.`user_id` = a.id
 where  a.`user_name` = '沙僧'
) c 

 case when 方式

select 
sum(case WHEN user_name='悟空' THEN kills END) as '悟空',
sum(case WHEN user_name='八戒' then kills END) as '八戒',
sum(case when user_name='沙僧' then kills END ) as '沙僧'
from user1 a JOIN user_kills b where a.id = b.user_id


![](http://i.imgur.com/3RdOPDh.jpg)

如图：

![](http://i.imgur.com/u397AdH.png)

如图:

![](http://i.imgur.com/fjWUjBq.png)



#如何生成唯一序列号

 需要使用唯一序列号的场景
 
 数据库主键
 
 业务序列号如发票号，车票号，订单号等...

生成序列号的方法

 ![](http://i.imgur.com/YFgMlQD.png)

如何选择生成序列号的方式

优先选择系统提供的序列号生成方式

在特殊情况下可以使用SQL方式生成序列号

用sql 来生成特殊的序列号

需求:生成订单序列号，并且订单号的格式如下

YYYYMMDDNNNNNNM  如201505120000003

用SQL来生成特殊的序列号

![](http://i.imgur.com/AjyUjPC.png)

如何处理重复的数据
 
 产生数据重复的原因

人为原因，如重复录入数据，重复提交 等...

系统原因:由于系统升级或设计的原因使原来可以重复的数据变为
不能重复了


如何查询数据是否重复？

利用group by 和 havinng 从句处理

1. 创建测试表


create TABLE user1_test(

id int auto_increment  not null,

user_name VARCHAR(3),

over varchar(5),

mobile varchar(100),

primary KEY(id)

)ENGINE = INNODB DEFAULT CHARSET=utf8;


2. 添加语句值测试表

INSERT into  user1_test(user_name,over,mobile)

select user_name, over,mobile from user1 LIMIT 2 ;

3.选出重复的语句

select user_name, over ,COUNT(*) from user1_test GROUP BY user_name ,over HAVING COUNT(*)>1;

![](http://i.imgur.com/W4HseJj.png)


4.删除重复的语句

DELETE a from user1_test a JOIN(

select user_name, over ,COUNT(*),MAX(id) as id   from user1_test GROUP BY 

user_name ,over HAVING COUNT(*)>1

) b on a.user_name = b.user_name where a.id<b.id

![](http://i.imgur.com/Y9KGgg4.png)

![](http://i.imgur.com/G0fFFjK.png)

#如何在子查询中匹配两个值

 什么是子查询？

当一个查询是另一个查询的条件是，称之为子查询。!

常见的子查询使用场景

使用子查询可以避免由于子查询中的数据产生的重复

使用子查询更符合语意，更好理解

 ![](http://i.imgur.com/xCFxIK0.png)




























