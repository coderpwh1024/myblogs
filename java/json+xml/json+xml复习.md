# JSON,Jackson,xml  #

   json和xml 我们常用的数据格式交换,关于json常用的解析工具 **fastjson,jackson,gson,json-lib** 等工具解析。

**关于jackson学习列举一些小demo。**

**Link实体类**

```
package com.coderpwh.code3;

/**
 * 实体类
 * 
 * @author 彭文浩
 *
 */
public class Link {
	private String phone; // 移动电话
	
	private String address; // 地址
	
	private String qq; // QQ
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
}

```
**user 实体类**

```
package com.coderpwh.code3;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 实体类
 * @author 彭文浩
 *
 */
public class User {
	private String id; //标识  
	
    private String name;    //姓名  
    
    private int age;    //年龄  
    
    private double pay; //工资   
    
    private boolean valid;  //是否有效  
    
    private char one; //一个字符  
    
    private Date birthday;  //生日  
      
    private Link link; //联系方式，自定义  
      
    private Map map; //测试用  
    
    private List list; //测试用  
    
    private Set set; //测试用
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public char getOne() {
		return one;
	}
	public void setOne(char one) {
		this.one = one;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}

}

```
**测试类，对象与json，map,list,set 与json相互转换**

```
package com.coderpwh.code3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json 对象,map,list,set 相互转换
 * 
 * @author 彭文浩
 *
 */
public class JsonTest {
	public static void main(String[] args) throws IOException {
		User user = new User();
		user.setId("01");
		user.setName("java");
		user.setAge(10);
		user.setPay(6666.88);
		user.setValid(true);
		user.setOne('E');
		user.setBirthday(new Date(20l * 366 * 24 * 3600 * 1000)); // 1990年

		Link link = new Link();
		link.setAddress("深圳市");
		link.setPhone("13012345678");
		link.setQq("123456");
		user.setLink(link);

		// Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("aa", "My name is aa");
		map.put("bb", "My name is bb");
		map.put("cc", "My name is cc");
		user.setMap(map);

		// List
		List<String> list = new ArrayList<String>();
		list.add("普洱茶");
		list.add("铁观音");
		list.add("碧螺春");
		user.setList(list);

		// Set
		Set<String> set = new HashSet();
		set.add("足球");
		set.add("篮球");
		set.add("乒乓球");
		user.setSet(set);

		ObjectMapper mapper = new ObjectMapper();

		// 对象转json
		String userjson = mapper.writeValueAsString(user);
		System.out.println(userjson);
		System.out.println("===============================");
		/**
		 * { "id": "01", "name": "java", "age": 10, "pay": 6666.88, "valid":
		 * true, "one": "E", "birthday": 632448000000, "link": { "phone":
		 * "13012345678", "address": "深圳市", "qq": "123456" }, "map": { "aa": "My
		 * name is aa", "bb": "My name is bb", "cc": "My name is cc" }, "list":
		 * [ "普洱茶", "铁观音", "碧螺春" ], "set": [ "足球", "篮球", "乒乓球" ] }
		 */

		// json ---> map
		@SuppressWarnings("rawtypes")
		Map mp = mapper.readValue(userjson, Map.class);

		System.out.println("pay:" + mp.get("pay").getClass().getName());
		System.out.println("valid:" + mp.get("valid").getClass().getName());
		System.out.println("birthday:" + mp.get("birthday").getClass().getName());
		System.out.println("link:" + mp.get("link").getClass().getName());
		System.out.println("list:" + mp.get("list").getClass().getName());
		System.out.println("map:" + mp.get("map").getClass().getName());
		System.out.println("set:" + mp.get("set").getClass().getName());

		// map --->json
		String mapjson = mapper.writeValueAsString(mp);
		System.out.println(mapjson);
		System.out.println("===============================");
		
		// json ---> 对象
		User us = mapper.readValue(userjson, User.class);
		System.out.println("ID:" + us.getId());
		System.out.println("age:" + us.getAge());
		System.out.println("Name:" + us.getName());
		System.out.println("One:" + us.getOne());
		System.out.println("Pay:" + us.getPay());
		System.out.println("Birthday:" + us.getBirthday());
		System.out.println("Link:" + us.getLink());
		System.out.println("List:" + us.getList());
		System.out.println("Map:" + us.getMap());
		System.out.println("Set:" + us.getSet());
		
		System.out.println("===============================");

	}

}

```

运行结果:

```
{"id":"01","name":"java","age":10,"pay":6666.88,"valid":true,"one":"E","birthday":632448000000,"link":{"phone":"13012345678","address":"深圳市","qq":"123456"},"map":{"aa":"My name is aa","bb":"My name is bb","cc":"My name is cc"},"list":["普洱茶","铁观音","碧螺春"],"set":["足球","篮球","乒乓球"]}
===============================
pay:java.lang.Double
valid:java.lang.Boolean
birthday:java.lang.Long
link:java.util.LinkedHashMap
list:java.util.ArrayList
map:java.util.LinkedHashMap
set:java.util.ArrayList
{"id":"01","name":"java","age":10,"pay":6666.88,"valid":true,"one":"E","birthday":632448000000,"link":{"phone":"13012345678","address":"深圳市","qq":"123456"},"map":{"aa":"My name is aa","bb":"My name is bb","cc":"My name is cc"},"list":["普洱茶","铁观音","碧螺春"],"set":["足球","篮球","乒乓球"]}
===============================
ID:01
age:10
Name:java
One:E
Pay:6666.88
Birthday:Tue Jan 16 08:00:00 GMT+08:00 1990
Link:com.coderpwh.code3.Link@7f9a81e8
List:[普洱茶, 铁观音, 碧螺春]
Map:{aa=My name is aa, bb=My name is bb, cc=My name is cc}
Set:[足球, 篮球, 乒乓球]

```
当然也可以用第三工具json 格式化一下

**思考：json 中的中括号和大括号区别？**

