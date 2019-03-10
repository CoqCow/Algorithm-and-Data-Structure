package com.niu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Code_05_MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = true;

    public void set() {
        try {
            lock.lock();
            while (hasValue == true) {
                condition.await();
            }
            System.out.println("哥");
            hasValue = true;
            condition.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (hasValue == false) {
                condition.await();
            }
            System.out.println("牛");
            hasValue = false;
            condition.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    public static class SetThread extends Thread {
        private Code_05_MyService myService;

        public SetThread(Code_05_MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                myService.set();
            }
        }
    }

    public static class GetThread extends Thread {
        private Code_05_MyService myService;

        public GetThread(Code_05_MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                myService.get();
            }
        }
    }

    public static void main(String[] args) {
        Code_05_MyService myService = new Code_05_MyService();
        GetThread getThread = new GetThread(myService);
        SetThread setThread = new SetThread(myService);
        getThread.start();
        setThread.start();
    }
}
