package com.imooc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL常用的 方法
 * 
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
