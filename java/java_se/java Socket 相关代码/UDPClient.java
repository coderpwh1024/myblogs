package com.imooc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 客户端
 * 
 * @author 彭文浩
 *
 */
public class UDPClient {

	public static void main(String[] args) {
		try {
			/**
			 * 向服务端发送数据
			 */

			// 1.定义服务器的地址,端口号,数据
			InetAddress address = InetAddress.getByName("localhost");
			int part = 8800;
			byte[] data = "用户名:admin;密码:123".getBytes();
			// 2. 创建数据报,包含发送的数据信息
			DatagramPacket packet = new DatagramPacket(data, data.length, address, part);
			// 3. 创建DatagramSocket 对象
			DatagramSocket socket = new DatagramSocket();
			// 4.向服务器端发送数据报
			socket.send(packet);

			/**
			 * 接受服务端响应的数据
			 */
			// 1.创建数据报，用于接受服务器响应的数据
			byte[] data2 = new byte[1024];
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
			// 2. 接受服务端响应的数据
			socket.receive(packet2);
			// 3.读取数据
			String reply = new String(data2, 0, packet2.getLength());
			System.out.println("我是客户端,服务端说:" + reply);
			// 4.关闭资源
			socket.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
