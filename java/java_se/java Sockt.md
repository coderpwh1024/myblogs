#java Socket 编程

1.网络基础知识

2.InetAddress类

3.URL

4.TCP编程

5.UDP编程

![](http://i.imgur.com/6c5z5br.png)

两台计算机通过网络进行通信

必备条件: ip ,协议，端口

![](http://i.imgur.com/UvSiJd6.png)


      TCP/IP协议

![](http://i.imgur.com/obOibgL.png)

TCP/IP 模型

![](http://i.imgur.com/A9QeiSt.png)

IP地址:

![](http://i.imgur.com/CouNmkX.png)

端口:

![](http://i.imgur.com/9ujKLsG.png)

![](http://i.imgur.com/IdKPwFg.png)

java 中对网络的支持

![](http://i.imgur.com/yOBCTOd.png)

# InetAddress

  `
 `
package com.imooc;

import java.net.InetAddress;

import java.net.UnknownHostException;

import java.util.Arrays;


/**

 * InetAdress类


 * @author 彭文浩
 * 
 *
 */

public class Test01 {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress address = InetAddress.getLocalHost();
		System.out.println("计算机名:" + address.getHostName());
		System.out.println("计算机IP地址:" + address.getHostAddress());
		byte[] addr = address.getAddress();
		System.out.println("字节数组的ip地址:" + Arrays.toString(addr));
		System.out.println(address); // 直接获取计算机名和ip地址

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		// 根据计算机名获取InetAddress
		InetAddress address2 = InetAddress.getByName("PengWenHao");
		System.out.println("计算机名:" + address2.getHostName());
		System.out.println("计算机IP地址:" + address2.getHostAddress());

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		// 根据计算的IP地址获取InetAddress
		// InetAddress address3 = InetAddress.getLocalHost();
		// 或者
		InetAddress address3 = InetAddress.getByName("192.168.80.1");
		System.out.println("计算机名:" + address3.getHostName());
		System.out.println("计算机IP地址:" + address3.getHostAddress());

	}
}
`
`

运行结果:

 ![](http://i.imgur.com/wn1MTEw.png)






##

#URL 

![](http://i.imgur.com/GDDWrX5.png)

  ```
package com.imooc;


import java.net.MalformedURLException;

import java.net.URL;


/**

 * URL常用的 方法


 * @author 彭文浩

 *
 */


public class Test02 {

	public static void main(String[] args) {

		// 创建一个URL实例
		try {

			URL imooc = new URL("http://www.imooc.com");
			// ? 后面表示参数，#后面表示描点
			URL url = new URL(imooc, "/index.html?username=tom#test");
			System.out.println("协议:" + url.getProtocol());
			System.out.println("主机:" + url.getHost());
			// 如果没有指定端口号,则使用默认的端口号,此时getPort() 返回的是-1
			System.out.println("端口:" + url.getPort());
			System.out.println("文件路径:" + url.getPath());
            System.out.println("相对路径:"+url.getRef());
            System.out.println("查询字符串:"+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


```

运行结果:

![](http://i.imgur.com/PcB7bMo.png)


##

![](http://i.imgur.com/pVJckFS.png)


```

package com.imooc;

import java.io.BufferedReader;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;


/**

 *  使用url读取页面上的类容

 * @author 彭文浩

 *
 */

public class Test03 {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://www.baidu.com");
		   // 通过URL的openStream 方法获取URL对象所表示的资源字节输入流
			InputStream is =  url.openStream();
			// 将字节输入流转换为字符输入流
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
		    // 为字符输入流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine(); // 读取数据
			while(data!=null){
				System.out.println(data); // 输出数据
				data = br.readLine(); 
			}
			br.close();
			isr.close();
			is.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}

```
运行结果：

![](http://i.imgur.com/L2FMcVL.png)
