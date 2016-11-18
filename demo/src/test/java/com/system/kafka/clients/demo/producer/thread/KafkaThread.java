package com.system.kafka.clients.demo.producer.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * KafkaThread
 *
 * @author weiwei(Duan.Yu)
 * @version 1.0.0 createTime: 2016/11/17 下午4:32
 */
public class KafkaThread {

    /**
     * Main lock guarding all access
     */
    final ReentrantLock lock = new ReentrantLock(true);

    /**
     * Condition for waiting puts
     */
    private final Condition notFull = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        KafkaThread kafkaThread = new KafkaThread();
        kafkaThread.tcounthread04(1);
        kafkaThread.tcounthread04(2);
        kafkaThread.tcounthread04(1);
    }

    public void tcounthread04(int count) throws InterruptedException {
        System.out.println("count==" + count);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 1) {
                System.out.println("fuck");
                count++;
                notFull.await();
            }
            System.out.println("失败之作");
        } finally {
            lock.unlock();
        }
    }

    public static void thead01() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
            System.out.println("hehe===" + i);
        }
    }

    public static void thead02() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void thead03() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
        System.out.println("??");
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
