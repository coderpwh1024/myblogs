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
