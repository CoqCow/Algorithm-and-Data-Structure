package com.niu.thread;

import java.util.Date;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Callable callable=new MyCallable2();
        FutureTask futureTask=new FutureTask(callable);
        Thread thread=new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}

class MyCallable implements Callable<Object> {
    private String taskNum;

    MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }

    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(3000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}
class MyCallable2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        System.out.println("dfdsf");
        return "这是返回值";
    }
}