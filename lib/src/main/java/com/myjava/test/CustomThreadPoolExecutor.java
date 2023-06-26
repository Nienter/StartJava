package com.myjava.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadPoolExecutor {
    private ThreadPoolExecutor poll = null;

    public void init() {
        poll = new ThreadPoolExecutor(10, 30, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10), new CustomThreadFactory(),
                new CustomRejectExecutionHandler());
    }

    public void destroy() {
        if (poll != null)
            poll.shutdownNow();
    }

    public ThreadPoolExecutor getPoll() {
        return poll;
    }
    private class CustomThreadFactory implements ThreadFactory{
        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            String threadName = thread.getName()+ count.addAndGet(1);
            thread.setName(threadName);
            return thread;
        }
    }
    private class CustomRejectExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                System.out.println("reject");
                System.out.println(Thread.currentThread());
                executor.getQueue().put(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable =
                new Runnable() {
                    @Override
                    public void run() {
                        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor();
                        customThreadPoolExecutor.init();
                        ExecutorService pool = customThreadPoolExecutor.getPoll();
                        for (int i = 0; i < 100; i++) {
                            System.out.println("提交第"+i+"个任务");
                            int finalI = i;
                            pool.execute(new Runnable() {
                                @Override
                                public void run() {
                                    System.out.println(finalI +"Task is running");
                                    try {
                                        Thread.sleep(3000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });

                        }
                    }
                };

        Thread thread = new Thread(runnable);
        thread.setName("wyuu");
         thread.start();

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
