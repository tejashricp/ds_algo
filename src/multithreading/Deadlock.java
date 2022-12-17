package multithreading;

import lombok.SneakyThrows;

public class Deadlock {

    public static void main(String[] args) {
        Object mon1 = new Object();
        Object mon2 = new Object();

        DeadLockExample1 example1 = new DeadLockExample1(mon1,mon2);
        DeadLockExample1 example2 = new DeadLockExample1(mon1, mon2);

        Runnable runnable1 = new Runnable(){
            public void run(){
                example1.func1();
            }
        };

        Runnable runnable2 = new Runnable(){
            public void run(){
                example2.func2();
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
    }
}


class DeadLockExample1 {
    Object monitor1;
    Object monitor2;

    public DeadLockExample1(Object monitor1, Object monitor2) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
    }

    @SneakyThrows
    public void func1() {
        System.out.println("Waiting lock on monitor object 1");
        synchronized (monitor1) {
            System.out.println("Acquired lock on monitor object 1");
            Thread.sleep(3000);
            System.out.println("Waiting lock on monitor object 2");
            synchronized (monitor2) {
                System.out.println("Acquired lock on monitor object 2");
            }
        }
    }

    @SneakyThrows
    public void func2() {
        System.out.println("Waiting lock on monitor object 2");
        synchronized (monitor2) {
            System.out.println("Acquired lock on monitor object 2");
            Thread.sleep(3000);
            System.out.println("Waiting lock on monitor object 1");
            synchronized (monitor1) {
                System.out.println("Acquired lock on monitor object 1");
            }
        }
    }

}
