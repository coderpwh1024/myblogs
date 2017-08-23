 
#mysql 行列转换

 mysql 行列转换 ，在项目中应用的极其频繁，尤其是一些金融项目里的报表。其中最为头痛的就是多行转多列，动态的列行转换。最近在研究这些行里转换，还是从最为简单的行列转换开始。
   

sql 脚本
```

-- 创建表  学生表
CREATE TABLE `student` (
    `stuid` VARCHAR(16) NOT NULL COMMENT '学号',
    `stunm` VARCHAR(20) NOT NULL COMMENT '学生姓名',
    PRIMARY KEY (`stuid`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB; 


-- 课程表 

CREATE TABLE `courses` (
    `courseno` VARCHAR(20) NOT NULL,
    `coursenm` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`courseno`)
)
COMMENT='课程表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;


-- 成绩表
CREATE TABLE `score` (
    `stuid` VARCHAR(16) NOT NULL,
    `courseno` VARCHAR(20) NOT NULL,
    `scores` FLOAT NULL DEFAULT NULL,
    PRIMARY KEY (`stuid`, `courseno`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

-- 插入数据

-- 学生表数据

Insert Into student (stuid, stunm) Values('1001', '张三');
Insert Into student (stuid, stunm) Values('1002', '李四');
Insert Into student (stuid, stunm) Values('1003', '赵二');
Insert Into student (stuid, stunm) Values('1004', '王五');
Insert Into student (stuid, stunm) Values('1005', '刘青');
Insert Into student (stuid, stunm) Values('1006', '周明');

-- 课程表数据 
Insert Into courses (courseno, coursenm) Values('C001', '大学语文');
Insert Into courses (courseno, coursenm) Values('C002', '新视野英语');
Insert Into courses (courseno, coursenm) Values('C003', '离散数学');
Insert Into courses (courseno, coursenm) Values('C004', '概率论与数理统计');
Insert Into courses (courseno, coursenm) Values('C005', '线性代数');
Insert Into courses (courseno, coursenm) Values('C006', '高等数学(一)');
Insert Into courses (courseno, coursenm) Values('C007', '高等数学(二)');

-- 成绩表数据

Insert Into score(stuid, courseno, scores) Values('1001', 'C001', 67);
Insert Into score(stuid, courseno, scores) Values('1002', 'C001', 68);
Insert Into score(stuid, courseno, scores) Values('1003', 'C001', 69);
Insert Into score(stuid, courseno, scores) Values('1004', 'C001', 70);
Insert Into score(stuid, courseno, scores) Values('1005', 'C001', 71);
Insert Into score(stuid, courseno, scores) Values('1006', 'C001', 72);
Insert Into score(stuid, courseno, scores) Values('1001', 'C002', 87);
Insert Into score(stuid, courseno, scores) Values('1002', 'C002', 88);
Insert Into score(stuid, courseno, scores) Values('1003', 'C002', 89);
Insert Into score(stuid, courseno, scores) Values('1004', 'C002', 90);
Insert Into score(stuid, courseno, scores) Values('1005', 'C002', 91);
Insert Into score(stuid, courseno, scores) Values('1006', 'C002', 92);
Insert Into score(stuid, courseno, scores) Values('1001', 'C003', 83);
Insert Into score(stuid, courseno, scores) Values('1002', 'C003', 84);
Insert Into score(stuid, courseno, scores) Values('1003', 'C003', 85);
Insert Into score(stuid, courseno, scores) Values('1004', 'C003', 86);
Insert Into score(stuid, courseno, scores) Values('1005', 'C003', 87);
Insert Into score(stuid, courseno, scores) Values('1006', 'C003', 88);
Insert Into score(stuid, courseno, scores) Values('1001', 'C004', 88);
Insert Into score(stuid, courseno, scores) Values('1002', 'C004', 89);
Insert Into score(stuid, courseno, scores) Values('1003', 'C004', 90);
Insert Into score(stuid, courseno, scores) Values('1004', 'C004', 91);
Insert Into score(stuid, courseno, scores) Values('1005', 'C004', 92);
Insert Into score(stuid, courseno, scores) Values('1006', 'C004', 93);
Insert Into score(stuid, courseno, scores) Values('1001', 'C005', 77);
Insert Into score(stuid, courseno, scores) Values('1002', 'C005', 78);
Insert Into score(stuid, courseno, scores) Values('1003', 'C005', 79);

-- 
select st.stuid,st.stunm  from student  st 

select sc.stuid , sc.courseno,sc.scores  from score sc 

select  cs.courseno,cs.coursenm   from courses cs
```

要求: 查询每个学生的 每门课程与每门成绩

```
 select   st.stuid ID ,  st.stunm 姓名, cs.coursenm 课程名 ,sc.scores 成绩     from  student st, score sc ,courses cs
 
where st.stuid = sc.stuid and sc.courseno = cs.courseno  
```
结果:
![这里写图片描述](http://img.blog.csdn.net/20170823155414499?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


这是4列27行

我们行转成列，ID对应姓名对应每门课程对应每门成绩


静态行专列

```
 select st.stuid 编号, st.stunm 姓名 ,
Max(case c.coursenm when '大学语文' then s.scores else 0 end ) '大学语文',
max(case c.coursenm when '新视野英语' then IFNULL(s.scores,0)else 0 end) '新视野英语',
Max(case c.coursenm when '离散数学' then IFNULL(s.scores,0) ELSE 0 END) '离散数学',
MAX(case c.coursenm when '概率论与数理统计' then IFNULL(s.scores,0) else 0 end) '概率论与数理统计',
MAX(case c.coursenm  when '线性代数' then IFNULL(s.scores,0) else 0 END) '线性代数',
MAX(case c.coursenm when '高等数学(一)' THEN IFNULL(s.scores,0) else 0 end) '高等数学(一)',
MAX(case c.coursenm when '高等数学(二)' THEN IFNULL(s.scores,0) else 0 end) '高等数学(二)'
from  student st 
LEFT JOIN score s on st.stuid = s.stuid
LEFT JOIN courses c on c.courseno = s.courseno
GROUP BY st.stuid
```

再来看看 运行结果:

 ![这里写图片描述](http://img.blog.csdn.net/20170823155759846?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这就是实现了简单的行列

再来看看group_concat() 这个函数

group_concat()，手册上说明:该函数返回带有来自一个组的连接的非NULL值的字符串结果。
比较抽象，难以理解。

通俗点理解，其实是这样的：group_concat()会计算哪些行属于同一组，将属于同一组的列显示出来。要返回哪些列，由函

数参数(就是字段名)决定。分组必须有个标准，就是根据group by指定的列进行分组。

这些都是从网上看到的解释，但还是不好理解，我们直接上代码，看看run出来的结果，根据run之后的结果再回过来看！

```
select   s.stuid 编号 , GROUP_CONCAT(courseno) 课程号 , GROUP_CONCAT(s.scores)  成绩  from score s GROUP BY  s.stuid

```

看看运行后的结果:
之前效果:

![这里写图片描述](http://img.blog.csdn.net/20170823161322332?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


![这里写图片描述](http://img.blog.csdn.net/20170823161242032?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

非常明显GROUP_CONCAT() 作用 ,将课程号courseno, 成绩 scores 的结果集放在一起。



**也可以参看这篇文章**

[http://blog.csdn.net/sinat_27406925/article/details/77507478](http://blog.csdn.net/sinat_27406925/article/details/77507478 "mysql 行列转换")