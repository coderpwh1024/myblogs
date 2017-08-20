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


##


# Socket通信

![](http://i.imgur.com/jnXKgkF.png)


![](http://i.imgur.com/PSpe90a.png)

![](http://i.imgur.com/UbM6Mh0.png)


##

客户端和服务端

![](http://i.imgur.com/hXIIxS5.png)

![](http://i.imgur.com/VUyNxcW.png)

##

demo:

 > 客户端:

package com.imooc;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.PrintWriter;

import java.net.Socket;

import java.net.UnknownHostException;


/**

 * 客户端
 

 * @author 彭文浩

 */

 
public class Client {

	public static void main(String[] args) {
		try {
			//1.创建客户端Socket，指定服务器地址和端口
			Socket socket=new Socket("localhost", 8888);
			//2.获取输出流，向服务器端发送信息
			OutputStream os=socket.getOutputStream();//字节输出流
			PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
			pw.write("用户名：alice;密码：789");
			pw.flush();
			socket.shutdownOutput();//关闭输出流
			//3.获取输入流，并读取服务器端的响应信息
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("我是客户端，服务器说："+info);
			}
			//4.关闭资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

  
> 服务端

package com.imooc;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.PrintWriter;

import java.net.ServerSocket;

import java.net.Socket;


/**

 * 基于TCP协议的Socket通信,实现用户登录 服务端


 * @author 彭文浩
 
 */

public class Server {

	public static void main(String[] args) {

		try {
			// 1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);
			// 2. 调用accept() 方法开始监听,等待客户端的连接
			System.out.println("***服务器即将启动,等待客户端的连接***");
			Socket socket = serverSocket.accept();
			
			// 3. 获取输入 流,并读取客户信息
			InputStream is = socket.getInputStream(); // 字节输入流
			InputStreamReader isr = new InputStreamReader(is); // 将字节流转换为字符流
			BufferedReader br = new BufferedReader(isr); // 为输入流添加缓冲
			String info = null;
			while ((info = br.readLine())!= null) {   //  循环读取客户端信息
               System.out.println("我是服务,客户端说:"+info);
			}
			socket.shutdownInput(); // 关闭输入流
			
			// 4.获取输出流,响应客户单请求
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os); // 包装成打印流
			pw.write("欢迎您!");
		    pw.flush();  // 调用flush()方法将缓冲输出
		    
		    
		    
			// 5.关闭资源
		    pw.close();
		    os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


 此时要先运行服务端后运行客户端，结果如图:

![](http://i.imgur.com/VydSBBW.png)

![](http://i.imgur.com/pr4TQF9.png)

 
  