对象的初始化

　　(1) 非静态对象的初始化

　　在创建对象时，对象所在类的所有数据成员会首先进行初始化。

　　基本类型：int型，初始化为0。

　　如果为对象：这些对象会按顺序初始化。

　　※在所有类成员初始化完成之后，才调用本类的构造方法创建对象。

　　构造方法的作用就是初始化。

　　(2) 静态对象的初始化

　　程序中主类的静态变量会在main方法执行前初始化。

　　不仅第一次创建对象时，类中的所有静态变量都初始化，并且第一次访问某类(注意此时

　　未创建此类对象)的静态对象时，所有的静态变量也要按它们在类中的

   顺序初始化。

　　继承时，对象的初始化过程

　　(1) 主类的超类由高到低按顺序初始化静态成员，无论静态成员是否为private。

　　(2) 主类静态成员的初始化。

　　(3) 主类的超类由高到低进行默认构造方法的调用。注意，在调用每一个超类的默认构造

　　方法前，先进行对此超类进行非静态对象的初始化。

　　(4) 主类非静态成员的初始化。

　　(5) 调用主类的构造方法。

　　关于构造方法

　　(1) 类可以没有构造方法，但如果有多个构造方法，就应该要有默认的
  
   构造方法，否则在继承此类时，需要在子类中显式调用父类的某一个非默认的构造

   方法了。

　　(2) 在一个构造方法中，只能调用一次其他的构造方法，并且调用构造方法的语句

   必须是

　　第一条语句。

　　有关public、private和protected

　　(1) 无public修饰的类，可以被其他类访问的条件是：a.两个类在同  一文件中， b.两个类

　　在同一文件夹中，c.两个类在同一软件包中。

　　(2) protected：继承类和同一软件包的类可访问。

　　(3) 如果构造方法为private，那么在其他类中不能创建该类的对象。

　　抽象类

　　(1) 抽象类不能创建对象。

　　(2) 如果一个类中一个方法为抽象方法，则这个类必须为

   abstract抽象类。

　　(3) 继承抽象类的类在类中必须实现抽象类中的抽象方法。

　　(4) 抽象类中可以有抽象方法，也可有非抽象方法。抽象方法不能为private。

　　(5) 间接继承抽象类的类可以不给出抽象方法的定义。

　　final关键字

　　(1) 一个对象是常量，不代表不能转变对象的成员，仍可以其成员进行操作。

　　(2) 常量在使用前必须赋值，但除了在声明的同时初始化外，就只能在构造方法中初

  始化。

　　(3) final修饰的方法不能被重置(在子类中不能出现同名方法)。

　　(4) 如果声明一个类为final，则所有的方法均为final，无论其是否被final修饰，

   但数据

　　成员可为final也可不是。

　　接口interface (用implements来实现接口)

　　(1) 接口中的所有数据均为 static和final即静态常量。尽管可以不用这两个关键

   字修饰

　　，但必须给常量赋初值。

　　(2) 接口中的方法均为public，在实现接口类中，实现方法必须可public关键字。

　　(3) 如果使用public来修饰接口，则接口必须与文件名相同。

　　多重继承

　　(1) 一个类继承了一个类和接口，那么必须将类写在前面，接口写在后
 面，接口之间用逗号分隔。

　　(2) 接口之间可多重继承，注意使用关键字extends。

　　(3) 一个类虽只实现了一个接口，但不仅要实现这个接口的所有方法，还要实现这个

   接口

　　继承的接口的方法，接口中的所有方法均须在类中实现。

　　接口的嵌入

　　(1) 接口嵌入类中，可以使用private修饰。此时，接口只能在所在的类中实现，其

   他类不

　　能访问。

　　(2) 嵌入接口中的接口一定要为public。

　　类的嵌入

　　(1) 类可以嵌入另一个类中，但不能嵌入接口中。

　　(2) 在静态方法或其他方法中，不能直接创建内部类对象，需通过手段来取得。

　　手段有两种：
   class A {

　　class B {}

　　B getB() {

　　B b = new B();

　　return b;

　　}

　　}

　　static void m() {

　　A a = new A();

　　A.B ab = a.getB(); // 或者是 A.B ab = a.new B();

　　}

　

　　(3) 一个类继承了另一个类的内部类，因为超类是内部类，而内部类的构造方法不能自动

　　被调用，这样就需要在子类的构造方法中明确的调用超类的构造方法。

　　接上例：

　　class C extends A.B {

　　C() {

　　new A().super(); // 这一句就实现了对内部类构造方法的调用。

　　}

　　}

　　构造方法也可这样写：

　　C(A a) {

　　a.super();

　　} // 使用这个构造方法创建对象，要写成C c = new C(a); a是A的对象。

　　异常类

　　JAVA中除了RunTimeException 类，其他异常均须捕获或抛出。

   JAVA相关基础知识

   1、面向对象的特征有哪些方面

   1.抽象：

   抽象就是忽略一个主题中与当前目标无关的那些方面，以便更充分地注意与当前目标有关的方面。







9、Collection 和 Collections的区别。
　　
Collection是集合类的上级接口，继承与他的接口主要有Set 和List.

Collections是针对集合类的一个帮助类，他提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作。

10、&和&&的区别。

&是位运算符，表示按位与运算，&&是逻辑运算符，表示逻辑与（and）。

11、HashMap和Hashtable的区别。

HashMap是Hashtable的轻量级实现（非线程安全的实现），他们都完成了Map接口，主要区别在于HashMap允许空（null）键值（key）,

由于非线程安全，效率上可能高于Hashtable。

HashMap允许将null作为一个entry的key或者value，而Hashtable不允许。

HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。

Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现。

最大的不同是，Hashtable的方法是Synchronize的，

而HashMap不是，在多个线程访问Hashtable时，不需要自己为它的方法实现同步，

而HashMap 就必须为之提供外同步

（如果是ArrayList：List lst = Collections.synchronizedList(new ArrayList());如果是HashMap：Map map = Collections.synchronizedMap(new HashMap());）。

Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差异。

12、final, finally, finalize的区别。
　　
final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。

finally是异常处理语句结构的一部分，表示总是执行。

finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。


13、sleep() 和 wait() 有什么区别?

sleep是线程类（Thread）的方法，导致此线程暂停执行指定时间，给执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。

调用sleep不会释放对象锁。

wait是Object类的方法，对此对象调用wait方法导致本线程放弃对象锁，进入等待此对象的等待锁定池，

只有针对此对象发出notify方法（或notifyAll）后本线程才进入对象锁定池准备获得对象锁进入运行状态。

14、Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型?

方法的重写Overriding和重载Overloading是Java多态性的不同表现。

重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。

如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。

子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被“屏蔽”了。

如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。

Overloaded的方法是可以改变返回值的类型。

15、error和exception有什么区别?

error 表示恢复不是不可能但很困难的情况下的一种严重问题。

比如说内存溢出。不可能指望程序能处理这样的情况。

exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。

16、同步和异步有何异同，在什么情况下分别使用他们？举例说明。

如果数据将在线程间共享。

例如正在写的数据以后可能被另一个线程读到，或者正在读的数据可能已经被另一个线程写过了，那么这些数据就是共享数据，必须进行同步存取。

当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方法的返回时，就应该使用异步编程，在很多情况下采用异步途径往往更有效率。

17、abstract class和interface有什么区别?

声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。

然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。

不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类为。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法。

接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。

多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。

接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。

当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。

然后，它可以在实现了该接口的类的任何对象上调用接口的方法。

由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。
引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口。

18、heap和stack有什么区别。

栈是一种线形集合，其添加和删除元素的操作应在同一段完成。栈按照后进先出的方式进行处理。

堆是栈的一个组成元素

19、forward 和redirect的区别

forward是服务器请求资源，服务器直接访问目标地址的URL，把那个URL的响应内容读取过来，

然后把这些内容再发给浏览器，浏览器根本不知道服务器发送的内容是从哪儿来的，所以它的地址栏中还是原来的地址。

redirect就是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址，

一般来说浏览器会用刚才请求的所有参数重新请求，所以session,request参数都可以获取。

20、EJB与JAVA BEAN的区别？

Java Bean 是可复用的组件，对Java Bean并没有严格的规范，理论上讲，

任何一个Java类都可以是一个Bean。但通常情况下，由于Java Bean是被容器所创建（如Tomcat）的，

所以Java Bean应具有一个无参的构造器，另外，通常Java Bean还要实现Serializable接口用于实现Bean的持久性。

Java Bean实际上相当于微软COM模型中的本地进程内COM组件，它是不能被跨进程访问的。Enterprise Java Bean 相当于DCOM，

即分布式组件。它是基于Java的远程方法调用（RMI）技术的，所以EJB可以被远程访问（跨进程、跨计算机）。

但EJB必须被布署在诸如Webspere、WebLogic这样的容器中，EJB客户从不直接访问真正的EJB组件，而是通过其容器访问。

EJB容器是EJB组件的代理，EJB组件由容器所创建和管理。客户通过容器来访问真正的EJB组件。

21、Static Nested Class 和 Inner Class的不同。

Static Nested Class是被声明为静态（static）的内部类，它可以不依赖于外部类实例被实例化。

而通常的内部类需要在外部类实例化后才能实例化。

22、JSP中动态INCLUDE与静态INCLUDE的区别？

动态INCLUDE用jsp:include动作实现 <jsp:include page="included.jsp" flush="true" />

它总是会检查所含文件中的变化，适合用于包含动态页面，并且可以带参数。

静态INCLUDE用include伪码实现,定不会检查所含文件的变化，适用于包含静态页面<%@ include file="included.htm" %>

23、什么时候用assert。

assertion(断言)在软件开发中是一种常用的调试方式，很多开发语言中都支持这种机制。

在实现中，assertion就是在程序中的一条语句，它对一个boolean表达式进行检查，

一个正确程序必须保证这个boolean表达式的值为true；

如果该值为false，说明程序已经处于不正确的状态下，系统将给出警告或退出。

一般来说，assertion用于保证程序最基本、关键的正确性。assertion检查通常在开发和测试时开启。

为了提高性能，在软件发布后，assertion检查通常是关闭的。

24、GC是什么? 为什么要有GC?

　　GC是垃圾收集的意思（Gabage Collection）,内存处理是编程人员容易出现问题的地方，

  忘记或者错误的内存回收会导致程序或系统的不稳定甚至崩溃，

Java提供的GC功能可以自动监测对象是否超过作用域从而达到自动回收内存的目的，

Java语言没有提供释放已分配内存的显示操作方法。

25、short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错?

short s1 = 1; s1 = s1 + 1; （s1+1运算结果是int型，需要强制转换类型）

short s1 = 1; s1 += 1;（可以正确编译）

26、Math.round(11.5)等於多少? Math.round(-11.5)等於多少?

Math.round(11.5)==12

Math.round(-11.5)==-11

round方法返回与参数最接近的长整数，参数加1/2后求其floor.

27、String s = new String("xyz");创建了几个String Object?

两个

28、设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序。

以下程序使用内部类实现线程，对j增减的时候没有考虑顺序问题。

public class ThreadTest1{

private int j;

public static void main(String args[]){

ThreadTest1 tt=new ThreadTest1();

Inc inc=tt.new Inc();

Dec dec=tt.new Dec();

for(int i=0;i<2;i++){

Thread t=new Thread(inc);

t.start();

t=new Thread(dec);

t.start();

}

}

private synchronized void inc(){

j++;

System.out.println(Thread.currentThread().getName()+"-inc:"+j);

}

private synchronized void dec(){

j--;

System.out.println(Thread.currentThread().getName()+"-dec:"+j);

}

class Inc implements Runnable{

public void run(){

for(int i=0;i<100;i++){

inc();

}

}

}

class Dec implements Runnable{

public void run(){

for(int i=0;i<100;i++){

dec();

}

}

}

}

29、Java有没有goto?

java中的保留字，现在没有在java中使用。

30、启动一个线程是用run()还是start()?

启动一个线程是调用start()方法，使线程所代表的虚拟处理机处于可运行状态，这意味着它可以由JVM调度并执行。

这并不意味着线程就会立即运行。run()方法可以产生必须退出的标志来停止一个线程。

31、EJB包括（SessionBean,EntityBean）说出他们的生命周期，及如何管理事务的？

SessionBean：Stateless Session Bean 的生命周期是由容器决定的，当客户机发出请求要建立一个Bean的实例时，

EJB容器不一定要创建一个新的Bean的实例供客户机调用，而是随便找一个现有的实例提供给客户机。

当客户机第一次调用一个Stateful Session Bean 时，容器必须立即在服务器中创建一个新的Bean实例，

并关联到客户机上，以后此客户机调用Stateful Session Bean 的方法时容器会把调用分派到与此客户机相关联的Bean实例。

EntityBean：Entity Beans能存活相对较长的时间，并且状态是持续的。

只要数据库中的数据存在，Entity beans就一直存活。

而不是按照应用程序或者服务进程来说的。即使EJB容器崩溃了，Entity beans也是存活的。

Entity Beans生命周期能够被容器或者 Beans自己管理。

EJB通过以下技术管理实务：对象管理组织（OMG）的对象实务服务（OTS），

Sun Microsystems的Transaction Service（JTS）、Java Transaction API（JTA），开发组（X/Open）的XA接口。

32、应用服务器有那些？

BEA WebLogic Server，IBM WebSphere Application Server，Oracle9i Application Server，jBoss，Tomcat

33、给我一个你最常见到的runtime exception。

 ArithmeticException, ArrayStoreException, BufferOverflowException, BufferUnderflowException, 

 CannotRedoException, CannotUndoException, ClassCastException, CMMException, 

 ConcurrentModificationException,

 DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, 

IllegalPathStateException, IllegalStateException, ImagingOpException, IndexOutOfBoundsException, 

MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException,

 ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, 

UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException

34、接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)?

接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数。

35、List, Set, Map是否继承自Collection接口?

List，Set是，Map不是

36、说出数据连接池的工作机制是什么?

J2EE服务器启动时会建立一定数量的池连接，并一直维持不少于此数目的池连接。

客户端程序需要连接时，池驱动程序会返回一个未使用的池连接并将其表记为忙。

如果当前没有空闲连接，池驱动程序就新建一定数量的连接，新建连接的数量有配置参数决定。

当使用的池连接调用完成后，池驱动程序将此连接表记为空闲，其他调用就可以使用这个连接。

37、abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized?

都不能

38、数组有没有length()这个方法? String有没有length()这个方法？

数组没有length()这个方法，有length的属性。String有有length()这个方法。

39、Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别?

Set里的元素是不能重复的，那么用iterator()方法来区分重复与否。equals()是判读两个Set是否相等。

equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值。

40、构造器Constructor是否可被override?

构造器Constructor不能被继承，因此不能重写Overriding，但可以被重载Overloading。

41、是否可以继承String类?

String类是final类故不可以继承。

42、swtich是否能作用在byte上，是否能作用在long上，是否能作用在String上?

switch（expr1）中，expr1是一个整数表达式。

因此传递给 switch 和 case 语句的参数应该是 int、 short、 char 或者 byte。long,string 都不能作用于swtich。

43、try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后?

会执行，在return前执行。

44、编程题: 用最有效率的方法算出2乘以8等於几?

2 << 3

45、两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对?

不对，有相同的hash code。

46、当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递?

是值传递。

Java 编程语言只有值传递参数。

当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。

对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的。

47、当一个线程进入一个对象的一个synchronized方法后，其它线程是否可进入此对象的其它方法?

不能，一个对象的一个synchronized方法只能由一个线程访问。

48、编程题: 写一个Singleton出来。

Singleton模式主要作用是保证在Java应用程序中，一个类Class只有一个实例存在。

一般Singleton模式通常有几种种形式:

第一种形式: 定义一个类，它的构造函数为private的，它有一个static的private的该类变量，

在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。

public class Singleton {

private Singleton(){}

　　 //在自己内部定义自己一个实例，是不是很奇怪？

　　 //注意这是private 只供内部调用

　　 private static Singleton instance = new Singleton();

　　 //这里提供了一个供外部访问本class的静态方法，可以直接访问　　

　　 public static Singleton getInstance() {

　　　　 return instance; 　　

　　 }

}

第二种形式:

public class Singleton {

　　private static Singleton instance = null;

　　public static synchronized Singleton getInstance() {

　　//这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 
　
　　//使用时生成实例，提高了效率！

　　if (instance==null)

　　　　instance＝new Singleton();

    return instance; 　　

}

}
其他形式:

定义一个类，它的构造函数为private的，所有方法为static的。

一般认为第一种形式要更加安全些

49、Java的接口和C++的虚类的相同和不同处。

由于Java不支持多继承，而有可能某个类或对象要使用分别在几个类或对象里面的方法或属性，

现有的单继承机制就不能满足要求。与继承相比，接口有更高的灵活性，因为接口中没有任何实现代码。

当一个类实现了接口以后，该类要实现接口里面所有的方法和属性，并且接口里面的属性在默认状态下面都是public static,

所有方法默认情况下是public.一个类可以实现多个接口。

50、Java中的异常处理机制的简单原理和应用。

当JAVA程序违反了JAVA的语义规则时，JAVA虚拟机就会将发生的错误表示为一个异常。

违反语义规则包括2种情况。一种是JAVA类库内置的语义检查。

例如数组下标越界,会引发IndexOutOfBoundsException;

访问null的对象时会引发NullPointerException。
另一种情况就是JAVA允许程序员扩展这种语义检查，程序员可以创建自己的异常，

并自由选择在何时用throw关键字引发异常。所有的异常都是java.lang.Thowable的子类。

51、垃圾回收的优点和原理。并考虑2种回收机制。

Java语言中一个显著的特点就是引入了垃圾回收机制，使c++程序员最头疼的内存管理的问题迎刃而解，

它使得Java程序员在编写程序的时候不再需要考虑内存管理。

由于有个垃圾回收机制，Java中的对象不再有“作用域”的概念，只有对象的引用才有“作用域”。

垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存。

垃圾回收器通常是作为一个单独的低级别的线程运行，
不可预知的情况下对内存堆中已经死亡的或者长时间没有使用的对象进行清楚和回收，

程序员不能实时的调用垃圾回收器对某个对象或所有对象进行垃圾回收。

回收机制有分代复制垃圾回收和标记垃圾回收，增量垃圾回收。

52、请说出你所知道的线程同步的方法。

wait():使一个线程处于等待状态，并且释放所持有的对象的lock。

sleep():使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要捕捉InterruptedException异常。

notify():唤醒一个处于等待状态的线程，注意的是在调用此方法的时候，并不能确切的唤醒某一个等待状态的线程，

而是由JVM确定唤醒哪个线程，而且不是按优先级。

Allnotity():唤醒所有处入等待状态的线程，注意并不是给所有唤醒线程一个对象的锁，而是让它们竞争。

53、你所知道的集合类都有哪些？主要方法？

最常用的集合类是 List 和 Map。

 List 的具体实现包括 ArrayList 和 Vector，它们是可变大小的列表，比较适合构建、存储和操作任何类型对象的元素列表。

List 适用于按数值索引访问元素的情形。

Map 提供了一个更通用的元素存储方法。

Map 集合类用于存储元素对（称作“键”和“值”），其中每个键映射到一个值。

54、描述一下JVM加载class文件的原理机制?

JVM中类的装载是由ClassLoader和它的子类来实现的,Java ClassLoader 是一个重要的Java运行时系统组件。

它负责在运行时查找和装入类文件的类。

55、char型变量中能不能存贮一个中文汉字?为什么?

能够定义成为一个中文的，因为java中以unicode编码，一个char占16个字节，所以放一个中文是没问题的

56、多线程有几种实现方法,都是什么?同步有几种实现方法,都是什么?

多线程有两种实现方法，分别是继承Thread类与实现Runnable接口

同步的实现方面有两种，分别是synchronized,wait与notify

57、JSP的内置对象及方法。

request表示HttpServletRequest对象。

它包含了有关浏览器请求的信息，并且提供了几个用于获取cookie, header, 和session数据的有用的方法。

response表示HttpServletResponse对象，并提供了几个用于设置送回 浏览器的响应的方法（如cookies,头信息等）

out对象是javax.jsp.JspWriter的一个实例，并提供了几个方法使你能用于向浏览器回送输出结果。

pageContext表示一个javax.servlet.jsp.PageContext对象。

它是用于方便存取各种范围的名字空间、servlet相关的对象的API，并且包装了通用的servlet相关功能的方法。

session表示一个请求的javax.servlet.http.HttpSession对象。Session可以存贮用户的状态信息

applicaton 表示一个javax.servle.ServletContext对象。这有助于查找有关servlet引擎和servlet环境的信息

config表示一个javax.servlet.ServletConfig对象。该对象用于存取servlet实例的初始化参数。

page表示从该页面产生的一个servlet实例

58、线程的基本概念、线程的基本状态以及状态之间的关系

线程指在程序执行过程中，能够执行程序代码的一个执行单位，每个程序至少都有一个线程，也就是程序本身。

Java中的线程有四种状态分别是：运行、就绪、挂起、结束。

59、JSP的常用指令

<%@page language=”java” contenType=”text/html;charset=gb2312” session=”true” buffer=”64kb” autoFlush=”true” 

isThreadSafe=”true” info=”text” errorPage=”error.jsp” isErrorPage=”true” isELIgnored=”true”
 
pageEncoding=”gb2312” import=”java.sql.*”%>

isErrorPage(是否能使用Exception对象)，isELIgnored(是否忽略表达式)

<%@include file=”filename”%>

<%@taglib prefix=”c”uri=”http://……”%>

60、什么情况下调用doGet()和doPost()？

Jsp页面中的form标签里的method属性为get时调用doGet()，为post时调用doPost()。

61、servlet的生命周期

web容器加载servlet，生命周期开始。通过调用servlet的init()方法进行servlet的初始化。

通过调用service()方法实现，根据请求的不同调用不同的do***()方法。

结束服务，web容器调用servlet的destroy()方法。

62、如何现实servlet的单线程模式

<%@ page isThreadSafe=”false”%>

63、页面间对象传递的方法

request，session，application，cookie等

64、JSP和Servlet有哪些相同点和不同点，他们之间的联系是什么？

JSP是Servlet技术的扩展，本质上是Servlet的简易方式，更强调应用的外表表达。

JSP编译后是"类servlet"。

Servlet和JSP最主要的不同点在于，Servlet的应用逻辑是在Java文件中，并且完全从表示层中的HTML里分离开来。

而JSP的情况是Java和HTML可以组合成一个扩展名为.jsp的文件。JSP侧重于视图，Servlet主要用于控制逻辑。

65、四种会话跟踪技术

会话作用域ServletsJSP 页面描述

page否是代表与一个页面相关的对象和属性。
一个页面由一个编译好的 Java servlet 类（可以带有任何的 include 指令，但是没有 include 动作）表示。

这既包括 servlet 又包括被编译成 servlet 的 JSP 页面

request是是代表与 Web 客户机发出的一个请求相关的对象和属性。

一个请求可能跨越多个页面，涉及多个 Web 组件（由于 forward 指令和 include 动作的关系）

session是是代表与用于某个 Web 客户机的一个用户体验相关的对象和属性。

一个 Web 会话可以也经常会跨越多个客户机请求

application是是代表与整个 Web 应用程序相关的对象和属性。

这实质上是跨越整个 Web 应用程序，包括多个页面、请求和会话的一个全局作用域

66、Request对象的主要方法：

setAttribute(String name,Object)：设置名字为name的request的参数值

getAttribute(String name)：返回由name指定的属性值

getAttributeNames()：返回request对象所有属性的名字集合，结果是一个枚举的实例

getCookies()：返回客户端的所有Cookie对象，结果是一个Cookie数组

getCharacterEncoding()：返回请求中的字符编码方式

getContentLength()：返回请求的Body的长度

getHeader(String name)：获得HTTP协议定义的文件头信息

getHeaders(String name)：返回指定名字的request Header的所有值，结果是一个枚举的实例

getHeaderNames()：返回所以request Header的名字，结果是一个枚举的实例

getInputStream()：返回请求的输入流，用于获得请求中的数据

getMethod()：获得客户端向服务器端传送数据的方法

getParameter(String name)：获得客户端传送给服务器端的有name指定的参数值

getParameterNames()：获得客户端传送给服务器端的所有参数的名字，结果是一个枚举的实例

getParameterValues(String name)：获得有name指定的参数的所有值

getProtocol()：获取客户端向服务器端传送数据所依据的协议名称

getQueryString()：获得查询字符串

getRequestURI()：获取发出请求字符串的客户端地址

getRemoteAddr()：获取客户端的IP地址

getRemoteHost()：获取客户端的名字

getSession([Boolean create])：返回和请求相关Session

getServerName()：获取服务器的名字

getServletPath()：获取客户端所请求的脚本文件的路径

getServerPort()：获取服务器的端口号

removeAttribute(String name)：删除请求中的一个属性

67、J2EE是技术还是平台还是框架？

J2EE本身是一个标准，一个为企业分布式应用的开发提供的标准平台。

J2EE也是一个框架，包括JDBC、JNDI、RMI、JMS、EJB、JTA等技术。

68、我们在web应用开发过程中经常遇到输出某种编码的字符，如iso8859-1等，如何输出一个某种编码的字符串？

Public String translate (String str) {

String tempStr = "";

try {

tempStr = new String(str.getBytes("ISO-8859-1"), "GBK");

tempStr = tempStr.trim();

}

catch (Exception e) {

System.err.println(e.getMessage());

}

return tempStr;

}

