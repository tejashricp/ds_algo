package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueueWithLocks<E> {
    private Queue<E> queue;
    private int size;
    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();


    public CustomBlockingQueueWithLocks(Queue<E> queue, int size) {
        this.queue = new LinkedList<E>();
        this.size = size;
    }

    public void put(E e){
    lock.lock();
    try {
        while (queue.size() == size) {
            notFull.await();
        }
        queue.add(e);
        notEmpty.signalAll();
    } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
    } finally {
        lock.unlock();
    }

    }

    public void take(){
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            E e = queue.remove();
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
