# Quartz简介 #

# 特点

1.强大的调度功能

 2.灵活的应用能力

 3.分布式和集群的能力

# 主要用到的设计模式

1.Builder 模式

2.Factory 模式

3.组件模式

4.链式写法

# 三个核心概念

1.调度器

2.任务

3.触发器

 ## Quartz体系结构 ##

1.JobDetail  

2.trigger

![](https://i.imgur.com/Mj8AOh4.png)


# Quartz 体系结构

重要组成

1.Job 接口

2.JobDetail 

3.JobBuilder

4.JobStore（接口）

5.Trigger (类)

6.TriggerBuilder

7.ThreadPool

8.Scheduler

9.Calendar 

一个Trigger 可以和多个Calendar 关联，以排除或包含某些时间点

10.监听器

JobListener,TriggerListener,SchedulerListener.


