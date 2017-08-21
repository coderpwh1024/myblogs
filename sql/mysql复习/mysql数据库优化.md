#MySql数据库优化

数据库优化的目的

 ![](http://i.imgur.com/PZ80cHi.png)

    mysql数据优化方向

![](http://i.imgur.com/6sh7O5o.png)


     数据库慢日志
![](http://i.imgur.com/ClmluKa.png)


![](http://i.imgur.com/p9Zad5d.png)


![](http://i.imgur.com/N3f0ad7.png)

![](http://i.imgur.com/wAm4oHE.png)


![](http://i.imgur.com/qv2Lqat.png)


    sql Count()和Max()的优化方法

![](http://i.imgur.com/dTOd4Ml.png)

![](http://i.imgur.com/N2nD34H.png)


对于 max(payment_date) 查询 我们可以创建该字段（payment_date）索引,从而提高效率

![](http://i.imgur.com/YdyF8BH.png)

Count() 查询的正确方法

![](http://i.imgur.com/giTTW4n.png)


    子查询优化
  
![](http://i.imgur.com/NqARUEW.png)


    group by的优化

![](http://i.imgur.com/K1DKdGR.png)

![](http://i.imgur.com/Yx3H1ra.png)

     limit查询优化的方式


1.使用索引列或者主键进行Order by 操作
2.记录上次返回的主键，在下次查询时使用主键过滤



![](http://i.imgur.com/Ei6f66J.png)

![](http://i.imgur.com/n0G111E.png)

![](http://i.imgur.com/9wvb1yN.png)

# 索引优化

    如何选择合适的列建立索引

![](http://i.imgur.com/TVd3gVG.png)

![](http://i.imgur.com/KCzI5BU.png)

![](http://i.imgur.com/Ali2awd.png)

![](http://i.imgur.com/Zl3Biar.png)

##

#数据库结构优化

 数据库优化，选择合适数据类型

![](http://i.imgur.com/kpkstnN.png)

![](http://i.imgur.com/fqABWoa.png)

![](http://i.imgur.com/0nT3a0C.png)

##

数据库优化，范式与反范式优化

![](http://i.imgur.com/BU0xJjI.png)

![](http://i.imgur.com/Ha2SjfQ.png)

![](http://i.imgur.com/1ydfvj4.png)


##

垂直拆分和水平拆分

![](http://i.imgur.com/i3grwRN.png)

表拆分前：

![](http://i.imgur.com/HQV27YM.png)

![](http://i.imgur.com/TLGwjPQ.png)

表拆分后:

![](http://i.imgur.com/noq99dq.png)

![](http://i.imgur.com/2lyDv8R.png)


水平拆分

![](http://i.imgur.com/TxMEP2F.png)

![](http://i.imgur.com/KoBqrPA.png)

![](http://i.imgur.com/16G5DXJ.png)


















