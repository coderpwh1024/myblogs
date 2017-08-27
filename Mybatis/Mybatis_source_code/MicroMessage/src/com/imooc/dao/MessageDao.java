package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/**
 * 和message表相关的数据库操作
 */
public class MessageDao {
	/**
	 * Mybatis方式
	 * 
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbaccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			sqlSession = dbaccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			messageList = sqlSession.selectList("Message.queryMessageList", message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}

		}

		return messageList;
	}

	/**
	 * 单条删除
	 * 
	 * @param id
	 */
	public void deleteOne(int id) {
		DBAccess dbaccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbaccess.getSqlSession();
			// 通过SqlSession执行sql语句
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}
     
	
	public void deleteBath(List<Integer> ids){
		DBAccess dbaccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbaccess.getSqlSession();
			// 通过SqlSession执行sql语句
			sqlSession.delete("Message.deleteBath", ids);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}
	
	// 用于测试 SqlSession 是否跑通
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
		Map<String, Message> messageMap = new HashMap<String, Message>();
		Logger log = null;
	}

	/**
	 * JDBC实现 根据查询条件查询消息列表
	 */
	/*
	 * public List<Message> queryMessageList(String command, String description)
	 * { List<Message> messageList = new ArrayList<Message>(); try { // 加载数据库启动
	 * Class.forName("com.mysql.jdbc.Driver"); // 获取驱动连接对象 Connection conn =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message",
	 * "root", "root");
	 * 
	 * // String sql ="select ID,COMMAND ,DESCRIPTION , CONTENT FROM //
	 * MESSAGE"; StringBuilder sql = new
	 * StringBuilder("select ID,COMMAND ,DESCRIPTION , CONTENT FROM MESSAGE where 1=1"
	 * ); List<String> paramList = new ArrayList<String>();
	 * 
	 * if (command != null && !"".equals(command.trim())) {
	 * sql.append(" and command =?"); paramList.add(command); }
	 * 
	 * if (description != null && !"".equals(description.trim())) {
	 * sql.append(" and description like '%'?'%'"); paramList.add(description);
	 * }
	 * 
	 * // 预编译对象 PreparedStatement statement =
	 * conn.prepareStatement(sql.toString()); for (int i = 0; i <
	 * paramList.size(); i++) { statement.setString(i + 1, paramList.get(i)); }
	 * 
	 * // 执行sql,返回结果集 ResultSet rs = statement.executeQuery(); while (rs.next())
	 * { Message message = new Message(); messageList.add(message);
	 * message.setId(rs.getString("ID"));
	 * message.setCommand(rs.getString("COMMAND"));
	 * message.setDescription(rs.getString("DESCRIPTION"));
	 * message.setContent(rs.getString("CONTENT")); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return messageList; }
	 */
}
