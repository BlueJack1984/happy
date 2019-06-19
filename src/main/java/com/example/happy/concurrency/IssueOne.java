package com.example.happy.concurrency;

public class IssueOne {

    private static final long count = 10000L;

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
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
    }
}
