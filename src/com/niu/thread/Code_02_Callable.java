package com.niu.thread;

import java.util.concurrent.*;

public class Code_02_Callable implements Callable<Integer> {
    public static void main(String[] args) {
        Code_02_Callable code_02_callable=new Code_02_Callable();
        FutureTask<Integer> futureTask=new FutureTask<>(code_02_callable);


        Thread a=new Thread(futureTask, "线程a");
        a.start();
            try {
                System.out.println("子线程的返回值:" + futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

    }
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return i;
    }
}
