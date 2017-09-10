# Spring 复习 #

![](https://i.imgur.com/iHBUYlx.png)

![](https://i.imgur.com/w0fGass.png)

![](https://i.imgur.com/tK66W4R.png)


![](https://i.imgur.com/HuGiGH1.png)


## **spring 注入** ##

**设置注入和构造注入**

![](https://i.imgur.com/cknUG6v.png)

 ![](https://i.imgur.com/snCnjel.png)


## Bean配置 ##

![](https://i.imgur.com/8cNYU7h.png)

![](https://i.imgur.com/4Bt253a.png)

![](https://i.imgur.com/d8eDqdk.png)


## Bean 的生命周期 ##

**bean的概念:**

由IoC容器管理的那些组成你应用程序的对象我们就叫它Bean， Bean就是由Spring容器初始化、装配及管理的对象，除此之外，bean就与应用程序中的其他对象没有什么区别了。



![](https://i.imgur.com/COV949U.png)

![](https://i.imgur.com/2dYvhp4.png)

![](https://i.imgur.com/fdRdwoa.png)

![](https://i.imgur.com/l5tkhcd.png)

![](https://i.imgur.com/T9EzBuo.png)

代码：

测试类

```
package com.imooc.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by 彭文浩 on 2017/9/10.
 */
public class BeanLifeCycle implements InitializingBean,DisposableBean {

    /**
     *  defaultInit（） 与 defaultDestory() 是默认配置
     *  全局初始化和销毁, 而 destroy() 与 afterPropertiesSet() 是实现了
     *  InitializingBean 与 DisposableBean 接口，start()与 stop()
     *  则是在全局配置的
     */
    public void defaultInit(){
        System.out.println("bean defaultInit");
    }

    public void defaultDestory(){
        System.out.println("bean defaultDestory");
    }


    public void destroy() throws Exception {
        System.out.println("Bean destroy");

    }

    public void afterPropertiesSet() throws Exception {

        System.out.println("Bean afterPropertiesSet");
    }


    public  void start(){

        System.out.println("start");
    }

    public  void stop(){
        System.out.println("stop");
    }

}


```
spring-lifecycle.xml 

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd" 
        default-init-method="defautInit" default-destroy-method="defaultDestroy">


    <bean id="beanLifeCycle" class="com.imooc.lifecycle.BeanLifeCycle"  init-method="start" destroy-method="stop"></bean>

</beans>

```
 而运行结果是:

**Bean afterPropertiesSet
start
Bean destroy
stop**

先执行接口的初始化其次在执行配置文件初始化，销毁先执行接口里的方法后执行配置文件的销毁

## Bean装配  ##
