package com.pwh.mycode.chapter09;

import java.util.concurrent.*;

/**
 * 线程池工厂
 */
public class ThreadPoolFactory {

    private static final int INIT_POOL_SIZE = 4;

    private static final int MAX_POOL_SIZE = 10;


    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(INIT_POOL_SIZE,
            MAX_POOL_SIZE, 0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1000),
            new ThreadPoolExecutor.AbortPolicy());


    /**
     * 异步
     *
     * @param r
     * @return
     */
    public static String addTaskSubmint(Runnable r) {
        System.out.println("运行的线程数:" + getActiveCount(threadPoolExecutor));
        System.out.println("阻塞的线程数:" + getBlockingQueue(threadPoolExecutor));
        threadPoolExecutor.execute(r);
        return "success";
    }


    /**
     * 同步
     *
     * @param c
     * @return
     */
    public static String addTaskSubmit(Callable c) {
        String m = null;
        System.out.println("运行的线程数:" + getActiveCount(threadPoolExecutor));
        System.out.println("阻塞的线程数:" + getBlockingQueue(threadPoolExecutor));
        Future<?> future = threadPoolExecutor.submit(c);

        try {
            Object object = future.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "success";
    }





    /**
     * 运行线程数
     *
     * @param pool
     * @return
     */
    public static int getActiveCount(ThreadPoolExecutor pool) {
        return pool.getActiveCount();
    }


    /**
     * 获取最大的线程数
     *
     * @param pool
     * @return
     */
    public static int getMaximunPoolSize(ThreadPoolExecutor pool) {
        return pool.getMaximumPoolSize();
    }

    /***
     * 阻塞的线程数
     * @param pool
     * @return
     */
    public static int getBlockingQueue(ThreadPoolExecutor pool) {

        return pool.getQueue().size();
    }


}
