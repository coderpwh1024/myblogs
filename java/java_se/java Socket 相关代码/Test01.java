package com.imooc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAdress类
 * 
 * @author 彭文浩
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
