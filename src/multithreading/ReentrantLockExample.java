package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    ReentrantLock lock = new ReentrantLock();
    int counter = 1;


    public void foo1(){
        while(counter <= 10){
            if(counter % 2 == 0)
                System.out.println("Thread - 1 "+ counter);
            counter++;
        }
    }

    private void foo2() {
        while(counter <= 10){
            if(counter % 2 != 0)
                System.out.println("Thread - 2 "+ counter);
            counter++;
        }
    }


    public static void main(String[] args){
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        Runnable runnable1 = new Runnable(){

            @Override
            public void run() {
                reentrantLockExample.foo1();
            }
        };

        Runnable runnable2 = new Runnable(){

            @Override
            public void run() {
                reentrantLockExample.foo2();
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
    }
}
