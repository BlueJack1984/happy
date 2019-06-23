package com.example.happy.concurrency;

public class IssueOne {

    private static final long count = 10000L;

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        try {
            concurrency();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serial();

    }

    private static void concurrency()throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(long i = 0; i < count; i ++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for(long i = 0; i < count; i ++) {
            b --;
        }
        //使用线程的join方法，要求线程thread执行完毕之后才能执行下面语句
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency:" + time + " ms, b = " + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i = 0; i < count; i ++) {
            a += 5;
        }
        int b = 0;
        for(long i = 0; i < count; i ++) {
            b --;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + " ms, b = " + b);
    }
}
