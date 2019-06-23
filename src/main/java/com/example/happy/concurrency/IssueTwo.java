package com.example.happy.concurrency;

public class IssueTwo {

    private static String a = "A";
    private static String b = "B";

    public static void main(String[] args) {
        new IssueTwo().deadLock();
    }

    private void deadLock() {
        //线程1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1持有了a的锁，正在等待b的锁");
                    synchronized (b) {
                        System.out.println("thread1");
                    }
                }
            }
        });
        //线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("线程2持有了b的锁，正在等待a的锁");
                    synchronized (a) {
                        System.out.println("thread2");
                    }
                }

            }
        });

        thread1.setName("curry1");
        thread2.setName("curry2");
        thread1.start();
        thread2.start();
    }
}
