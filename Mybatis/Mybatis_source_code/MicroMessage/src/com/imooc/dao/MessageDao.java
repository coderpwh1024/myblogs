package com.imooc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imooc.bean.Message;

/**
 * 和message表相关的数据库操作
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList = new ArrayList<Message>();
		try {
			// 加载数据库启动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取驱动连接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message", "root", "root");

			// String sql ="select ID,COMMAND ,DESCRIPTION , CONTENT FROM
			// MESSAGE";
			StringBuilder sql = new StringBuilder("select ID,COMMAND ,DESCRIPTION , CONTENT FROM MESSAGE where 1=1");
			List<String> paramList = new ArrayList<String>();

			if (command != null && !"".equals(command.trim())) {
				sql.append(" and command =?");
				paramList.add(command);
			}

			if (description != null && !"".equals(description.trim())) {
				sql.append(" and description like '%'?'%'");
				paramList.add(description);
			}

			// 预编译对象
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			for (int i = 0; i < paramList.size(); i++) {
				statement.setString(i + 1, paramList.get(i));
			}

			// 执行sql,返回结果集
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageList;
	}
}
