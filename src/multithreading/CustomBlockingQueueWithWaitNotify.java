package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueueWithWaitNotify<E> {
    Queue<E> queue;
    int size;

    public CustomBlockingQueueWithWaitNotify(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public void put(E e){
        synchronized (queue){
            while(queue.size() == size){
                try {
                    queue.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            queue.add(e);
            queue.notifyAll();
        }
    }

    public E take(){
        synchronized (queue){
            while(queue.size() == 0){
                try {
                    queue.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            E e = queue.remove();
            queue.notifyAll();
            return e;
        }
    }
}
