package com.coderpwh.code.other;

import java.util.concurrent.*;

/**
 * @author coderpwh
 * @create 2019-08-20 23:10
 * @desc ${DESCRIPTION}
 **/
public class ThreadPoolFactory {

    /**
     * 线程池
     */
    private static final int INIT_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 10;


    /**
     * 线程池
     */
    public static final ThreadPoolExecutor AttendanceTaskPool = new
            ThreadPoolExecutor(INIT_POOL_SIZE,
            MAX_POOL_SIZE,
            0,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1000),
            new ThreadPoolExecutor.AbortPolicy());


    /*
     * Runnable 异步
     */
    public static String addTaskAttendanceRecordSubmit(Runnable r) {
        System.out.println("考勤任务当前运行线程数:" + getActiveCount(AttendanceTaskPool));
        System.out.println("考勤任务当前阻塞线程数:" + getBlockingQueue(AttendanceTaskPool));
        AttendanceTaskPool.execute(r);
        return "success";

    }


    /**
     * 同步
     *
     * @param c
     * @return
     */
    public static String addTaskAttendanceRecordSubmit(Callable c) {
        String m = null;
        System.out.println("考勤任务当前运行线程数:" + getActiveCount(AttendanceTaskPool));
        System.out.println("考勤任务当前阻塞线程数:" + getBlockingQueue(AttendanceTaskPool));

        Future<?> future = AttendanceTaskPool.submit(c);

        try {
            Object obj = future.get();
            if(obj!=null)
                m = (String)obj;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
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
     * 最大线程数
     *
     * @param pool
     * @return
     */
    public static int getMaximunPoolSize(ThreadPoolExecutor pool) {
        return pool.getMaximumPoolSize();
    }

    /**
     * 阻塞线程数
     */
    public static int getBlockingQueue(ThreadPoolExecutor pool) {
        return pool.getQueue().size();
    }


}
