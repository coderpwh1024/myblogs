package com.coderpwh.concurrency;

import com.coderpwh.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
@NotThreadSafe
public class ConcurrencyTest {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;

//    public static   Logger log = org.slf4j.LoggerFactory.getLogger("aa");

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = new  ThreadPoolExecutor(200,300,1L,TimeUnit.DAYS,new LinkedBlockingDeque());
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {

//                    log.error("exception:",e);

                }
                countDownLatch.countDown();

            });
            countDownLatch.await();
            executorService.shutdown();
//             log.info("count:{}",count);
            System.out.println("count:" + count);
        }

    }

    public static void add() {
        count++;
    }


}
