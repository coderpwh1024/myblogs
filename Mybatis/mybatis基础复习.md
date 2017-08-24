#Mybatis 复习


##案列：

![](http://i.imgur.com/0U10vWD.png)

##
页面一帮都在WEB-INF 下是为了方便控制和管理，如果直接放在WebRoot下就可以直接访问到


![](http://i.imgur.com/4dqqPEN.png)

##code:


 `package com.imooc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;


/**
 * 列表页面初始化控制
 * @author 彭文浩
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			req.setCharacterEncoding("UTF-8");
			String command = req.getParameter("command");
			String description = req.getParameter("description");
			
			
			
			// 加载数据库启动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取驱动连接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message","root","root");

			
/*	String sql ="select ID,COMMAND ,DESCRIPTION , CONTENT FROM MESSAGE";*/

			StringBuilder sql = new StringBuilder("select ID,COMMAND ,DESCRIPTION , CONTENT FROM MESSAGE where 1=1");
             List<String> paramList = new ArrayList<String>();
			 
			if(command!=null && !"".equals(command.trim())){
				sql.append(" and command =?");
				paramList.add(command);
			}
			
			if(description!=null&& !"".equals(description.trim())){
				sql.append(" and description like '%'?'%'");
				paramList.add(description);
			}
			
			  // 预编译对象
			 PreparedStatement statement = conn.prepareStatement(sql.toString());
			 for(int i=0;i<paramList.size();i++){
					statement.setString(i+1, paramList.get(i));
			}
			 
			 // 执行sql,返回结果集
		     ResultSet rs = statement.executeQuery();
		     
		     List<Message> messageList = new ArrayList<Message>();
		     while(rs.next()){
		    	 Message message  = new Message();
		    	 messageList.add(message);
		    	 message.setId(rs.getString("ID"));
		    	 message.setCommand(rs.getString("COMMAND"));
		    	 message.setDescription(rs.getString("DESCRIPTION"));
		         message.setContent(rs.getString("CONTENT"));
		     }
		     req.setAttribute("messageList", messageList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	

}
`

页面效果:

![](http://i.imgur.com/LudmMp6.png)

![](http://i.imgur.com/4CvrGUT.png)

使用原始的jdbc 编写一般就是这个几个步骤

1.加载数据库驱动

2.获取数据库连接对象

3.sql预编译

4.sql 执行返回结果集

5.关闭连接

本项目中没有关闭连接，sql拼接和数据库连接尤其容易出错，用户名和密码。拼接 and 的前面注意空格等。

