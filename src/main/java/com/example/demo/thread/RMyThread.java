package com.example.demo.thread;

public class RMyThread implements Runnable {

    private int ticket = 50;
    @Override
    public void run() {
        System.out.println("当前是线程---" + Thread.currentThread().getName() );
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "当前售出第" + ticket + "张票");
                ticket --;
            }
        }
    }
}
