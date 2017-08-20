package com.imooc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 服务器端，实现基于UDP的用户登录
 * 
 * @author 彭文浩
 *
 */
public class UDPServer {
	public static void main(String[] args) {
             /**
              *  接受客户端发送的数据
              */
		 
		try {
			// 1. 创建服务端DatagramSocket,指定端口号
			DatagramSocket socket = new DatagramSocket(8800);
			// 2. 创建数据报,用于接受客户端发送的数据
			byte[] data = new byte[1024]; // 创建字节数组,指定接受数据包的大小
			DatagramPacket packet = new DatagramPacket(data, data.length);
			// 3. 接受客户端发送的数据
			System.out.println("***服务器端已经启动,等待客户端**");
			socket.receive(packet); // 此方法在接受数据报之前会一直阻塞
			// 4. 读取数据
			String info = new String(data, 0, packet.getLength());
			System.out.println("我是服务器,客户端说:" + info);

			/**
			 *  向客户端响应数据
			 */
			// 1.定义客户端的地址,端口号,数据
			InetAddress address = packet.getAddress();
			int part = packet.getPort();
			byte [] data2 = "欢迎您!".getBytes();
			// 2. 创建数据报,包含响应的数据信息
			DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,part);
			// 3. 响应客户端
			socket.send(packet2);
			
			// 4.关闭资源
			 socket.close();
			 
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
