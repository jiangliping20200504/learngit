package com.example.demo.thread;

import java.util.Date;
import java.util.concurrent.Callable;

public class CMyThread implements Callable {

    private String taskNum;

    public CMyThread(String taskNum) {
        this.taskNum = taskNum;
    }

    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }

    /*@Override
    public Object call() throws Exception {
        System.out.println("当前是线程---" + Thread.currentThread().getName());
        return "ThreeMyThread返回值";
    }*/
}
