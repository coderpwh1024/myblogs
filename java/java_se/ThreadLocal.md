#ThreadLocal



   ThreadLocal 直译为 “线程本地，但如果真那么认为就是错的，ThreadLocal 它是一个容器，用来存放线程的局部变量.ThreadLocal的诞生 是为了解决多线程并发问题而设计的，只不过设计比较难用而已，至今没有得到广泛应用而已。
    
     一个序列号生成器的程序可能同时会有多个线程并发访问它，要保证每个序列号都是自增的，并且互不干扰。
    
     直接上代码:
 
 先定义了一个接口：
```
    public interface Sequence {


    int getNumber();
}

```


序列号自增 
```
public class ClientThread extends Thread {

    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
//        super.run();

        for (int i=0;i<3;i++){

            System.out.println(Thread.currentThread().getName()+"=>"+sequence.getNumber());
        }

    }
}
```
此时这里先不用ThreadLocal 来实现
```
public class SequenceA implements  Sequence {


     private static  int number = 0;

    @Override
    public int getNumber() {

        number = number + 1;
        return number;
    }


    public static void main(String[] args) {

        Sequence sequence = new SequenceA();

        ClientThread thread1 = new ClientThread(sequence);

        ClientThread thread2 = new ClientThread(sequence);

        ClientThread thread3  = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
```
看一下运行的结果图:
![这里写图片描述](http://img.blog.csdn.net/20170808111211572?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

为什么会出现这种效果？ 序列号是连续自增的，共享的static 变量无法保证线程安全，才会出现这种情况的。所以我们要做到线程安全的。

```
public class SequenceB  implements  Sequence{

    private  static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>(){

        @Override
        protected Integer initialValue() {   // 思考 此时为什么是protected?
            return 0;
        }
    };


    @Override
    public int getNumber() {

        numberContainer.set(numberContainer.get()+1);

        return numberContainer.get();
    }

    public static void main(String[] args) {

        Sequence sequence = new SequenceB();

        ClientThread thread1 = new ClientThread(sequence);

        ClientThread thread2 = new ClientThread(sequence);

        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();


    }

}

```
再来看看运行的结果:
![这里写图片描述](http://img.blog.csdn.net/20170808111643527?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

此时每个线程都是安全的，每个线程的数字都是1-3递增.ThreadLocal 保证了每个线程都是相互独立的，同样是static 变量，对于不同的线程，它没有被共享，而是各个线程各一份，这样就保证了线程的安全。

![这里写图片描述](http://img.blog.csdn.net/20170808112128399?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjc0MDY5MjU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这是ThreadLocal 的api

当然我们也可以自己来实现一个ThreadLocal 

 

```
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hello world on 2017/8/8.
 */
public class MyThreadLocal<T> {

       private Map<Thread,T> container = Collections.synchronizedMap(new HashMap<Thread, T>()); // 此时 container 是线程安全的map 这是为什么？


    // set 方法实现
      public void Set(T value){

          container.put(Thread.currentThread(),value);
      }

    //
    public T get(){

        Thread thread = Thread.currentThread();

        T value = container.get(thread);

        if(value ==null &&!container.containsKey(thread)){
            value = initialValue();
            container.put(thread,value);
        }

         return  value;
    }


    public void remove(){
        container.remove(Thread.currentThread());
    }


    protected  T initialValue(){

        return  null;
    }




}

```

我们再来用MyThreadLocal 来实现一编

```
 public class SequenceC implements  Sequence {

     private  static  MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>(){
         @Override
         protected Integer initialValue() {

             return 0;
         }
     };


    @Override
    public int getNumber() {
        numberContainer.Set(numberContainer.get()+1);
        return  numberContainer.get();
    }

    public static void main(String[] args) {
          Sequence sequence = new SequenceB();

        ClientThread thread1 = new ClientThread(sequence);

        ClientThread thread2 = new ClientThread(sequence);

        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();

    }

}

```
效果都是一样，就不截图了。当我们遇到static 修饰的变量，多个线程需要独享自己static成员变量？
如果需要，可以考虑用ThreadLocal .