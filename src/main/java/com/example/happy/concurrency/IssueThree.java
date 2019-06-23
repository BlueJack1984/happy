package com.example.happy.concurrency;

public class IssueThree {

    private volatile Integer value = 3;

    public static void main(String[] args) {
        new IssueThree().volatileTest();
    }

    private void volatileTest() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value = 6;
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("&&&&&&&&--->" + value);
                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("&&&&&&&&--->" + value);
            }
        });
        thread1.start();
        thread2.start();
    }


}
