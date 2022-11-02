/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.booleanchoice.exercise.concurrent.notice;


import java.util.concurrent.*;

/**
 *
 * @author booleanchoice
 * @version $Id: TestThreadNotice.java, v 0.1 2019年03月18日 8:42 PM booleanchoice Exp $
 */
public class TestThreadNotice {

    public static void main(String[] args) {
        // 信号量方式
        Semaphore as = new Semaphore(1);
        Semaphore bs = new Semaphore(1);
        Semaphore cs = new Semaphore(1);
        try {
            // 先把 b 和 c 的信号量置为持有状态
            bs.acquire();
            cs.acquire();
        } catch (Exception e) {

        }
        Printer a = new Printer("A", 10, as, bs);
        Printer b = new Printer("B", 10, bs, cs);
        Printer c = new Printer("C", 10, cs, as);
        Executor executor = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque());
        executor.execute(a);
        executor.execute(b);
        executor.execute(c);
    }

}

class Printer implements Runnable {

    private String content;
    private Integer times;
    private Semaphore current;
    private Semaphore next;

    public Printer(String content, Integer times, Semaphore current, Semaphore next) {
        this.content = content;
        this.times = times;
        this.current = current;
        this.next = next;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < times; i++) {
                current.acquire();
                System.out.println(Thread.currentThread().getName() + " print: " + content);
                next.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}