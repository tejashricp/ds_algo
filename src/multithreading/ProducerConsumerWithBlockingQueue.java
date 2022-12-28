package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerWithBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
         BlockingQueue<Item> queue = new ArrayBlockingQueue(10);

        Runnable r = new Runnable(){
            public void run(){
                int count  = 0;
                while(true){
                    try {
                        queue.put(new Item(count++));
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }};

        Runnable r1 = new Runnable(){
            public void run(){
                while(true){
                    try {
                        Item i = queue.take();
                        System.out.println(i.counter);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread p = new Thread(r);
                p.start();


        Thread c = new Thread(r1);
        c.start();

//        p.join();
//        c.join();


    }
}

class ProducerConsumerExample{

}

class Item{
    int counter;

    public Item(int counter) {
        this.counter = counter;
    }
}