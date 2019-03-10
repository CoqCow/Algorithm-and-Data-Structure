package com.niu.thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class Code_01_ThreadPoolExecutor {
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        ThreadPoolExecutor executor=new ThreadPoolExecutor
                (5,10,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        for(int i=0;i<20;i++){
            Mytask myTask = new Mytask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
    public static class Mytask implements Runnable{
        private int tastNum;
        public Mytask(int num){
            this.tastNum=num;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("正在执行task "+tastNum);
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task "+tastNum+"执行完毕");
        }

    }

}
