package multithreading;

import static multithreading.OneTwoThreePrinterType.*;
import static multithreading.PrinterType.ODD;

public class PrintOneTwoThree {

    public static void main(String[] args) {
        OneTwoThreeState state = new OneTwoThreeState(ONE);

        OneTwoPrinter one = new OneTwoPrinter(state, TWO, ONE, 1);
        OneTwoPrinter two = new OneTwoPrinter(state, THREE, TWO, 2);
        OneTwoPrinter three = new OneTwoPrinter(state, ONE, THREE, 3);

        Thread t1 = new Thread(one);
        Thread t2 = new Thread(two);
        Thread t3 = new Thread(three);

        t2.start();
        t1.start();
        t3.start();
    }


}

class OneTwoPrinter implements Runnable {

    private int n = 10;
    private OneTwoThreeState state;
    private OneTwoThreePrinterType next;
    private OneTwoThreePrinterType current;
    private int counter = 1;

    public OneTwoPrinter(OneTwoThreeState state, OneTwoThreePrinterType next, OneTwoThreePrinterType current, int counter) {
        this.state = state;
        this.next = next;
        this.current = current;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter < n) {
            synchronized (state) {
                while (state.getNextPrinterType() != current) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread " + current + " " + counter);
                counter += 3;
                state.setNextPrinterType(next);
                state.notifyAll();
            }
        }
    }
}

class OneTwoThreeState {
    private OneTwoThreePrinterType nextPrinterType;

    public OneTwoThreePrinterType getNextPrinterType() {
        return nextPrinterType;
    }

    public void setNextPrinterType(OneTwoThreePrinterType nextPrinterType) {
        this.nextPrinterType = nextPrinterType;
    }

    public OneTwoThreeState(OneTwoThreePrinterType nextPrinterType) {
        this.nextPrinterType = nextPrinterType;
    }
}

enum OneTwoThreePrinterType {
    ONE,
    TWO,
    THREE;
}

