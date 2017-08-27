# Mybatis配置加载 #

**Dao需求**

1.对象能与数据库交互

2.能够执行sql


![](http://i.imgur.com/Kh3icYD.png)

##


# Mybatis之Sqlsession #

![](http://i.imgur.com/X723sTq.png)

  **Mybatis获取SqlSession 过程**

1.加载配置，并修改配置文件 Configuration.xml

![](http://i.imgur.com/ugCFTd6.png)

2.访问数据库类，得到SqlSession 对象

 ```
 public class DBAccess {

   public SqlSession getSqlSession() throws IOException{

	   // 1.通过配置文件获取数据库连接信息
	   Reader reader =  Resources.getResourceAsReader("com/imooc/conf/Configuration.xml");
	   
	   // 2.通过配置信息构建一个SqlSessionFactory
	   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	   
	   // 3.通过sqlSessionFactory 打开一个数据库会话
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   
	   return sqlSession;
   }
}
```


3.通过SqlSession 操作数据库

```
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

		try {
			dbaccess.getSqlSession();
			// 通过sqlSession执行SQL语句
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}

		}

		return null;
	}

	// 用于测试 SqlSession 是否跑通
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
	}
```
通过测试mybatis基本就跑通了

4.mapper映射器配置，编写sqlmapper.xml

![](http://i.imgur.com/C5A6z2Z.png)

启动一下项目，看看效果

![](http://i.imgur.com/i3BXnp4.png)


 **关于sql中拼接语句**

```
 <select id="queryMessageList" parameterType="com.imooc.bean.Message" resultMap="MessageResult">
    select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE
     <where>
         <if test="command !=null and !&quot;&quot;.equals(command.trim())">
             and COMMAND=#{command}
             </if>
             <if test="description !=null and !&quot;&quot;.equals(description.trim())">
             and DESCRIPTION like '%' #{description} '%'
            </if>         
         </where>
  </select>
```

其中关于sql拼接和sql 注入问题，还有mybatis的ognl表达式

执行SQL：Select * from emp where name = #{employeeName}
参数：employeeName=>Smith
解析后执行的SQL：Select * from emp where name = ？
执行SQL：Select * from emp where name = ${employeeName}
参数：employeeName传入值为：Smith
解析后执行的SQL：Select * from emp where name =Smith

综上所述、**${}方式会引发SQL注入的问题、同时也会影响SQL语句的预编译，所以从安全性和性能的角度出发，能使用#{}的情况下就不要使用${}**

  但是${}在什么情况下使用呢？

有时候可能需要直接插入一个不做任何修改的字符串到SQL语句中。这时候应该使用${}语法。

比如，动态SQL中的字段名，如：ORDER BY ${columnName}

注意：当使用${}参数作为字段名或表名时、需指定statementType为“STATEMENT”，如：

```
    <select id="queryMetaList" resultType="Map" statementType="STATEMENT">Select * from emp where name = ${employeeName} ORDER BY ${columnName}</select>   
```
其次关于mybatis 中的ongal

![](http://i.imgur.com/uao6Xaa.png)

![](http://i.imgur.com/SoGit3G.png)

更多关于Mybatis 中OGNL表达式 [http://blog.csdn.net/isea533/article/details/50061705](http://blog.csdn.net/isea533/article/details/50061705 "ognl")

