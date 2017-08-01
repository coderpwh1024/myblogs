  # Classes More Than 5 Students

 ![这里写图片描述](http://img.blog.csdn.net/20170801162147814?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


代码：

select class from a   GROUP BY class HAVING COUNT(*)>=5

这样依旧会报错的，注意红色框里面，学生里是不可以重复的。

正确代码：

select  a.class FROM  (
select DISTINCT student ,class ,COUNT(*) from a GROUP BY class,student  ) a GROUP BY a.class 
HAVING COUNT(*)>=5

要防止学生重复
![这里写图片描述](http://img.blog.csdn.net/20170801162506738?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![这里写图片描述](http://img.blog.csdn.net/20170801162520181?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


leetcode 提交运行截图

![这里写图片描述](http://img.blog.csdn.net/20170801162608905?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

leetcode  代码:

select  a.class FROM  (
select DISTINCT student ,class ,COUNT(*) from courses   GROUP BY class,student  ) a GROUP BY a.class 
HAVING COUNT(*)>=5

