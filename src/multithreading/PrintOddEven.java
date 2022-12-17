package multithreading;

import lombok.Getter;
import lombok.Setter;

import static multithreading.PrinterType.ODD;

public class PrintOddEven {
    public static void main(String[] args) {
        State state = new State(ODD);

        Printer odd = new Printer(state, PrinterType.EVEN, ODD,1);
        Printer even = new Printer(state, ODD, PrinterType.EVEN,2);

        Thread t1 = new Thread(odd);
        Thread t2 = new Thread(even);

        t2.start();
        t1.start();
    }


}

class Printer implements Runnable{

    private int n = 10;
    private State state;
    private PrinterType next;
    private PrinterType current;
    private int counter = 1;

    public Printer(State state, PrinterType next, PrinterType current, int counter) {
        this.state = state;
        this.next = next;
        this.current = current;
        this.counter = counter;
    }

    @Override
    public void run() {
        while(counter < n) {
            synchronized (state) {
                while (state.getNextPrinterType() != current) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread " + current + " " + counter);
                counter+=2;
                state.setNextPrinterType(next);
                state.notifyAll();
            }
        }
    }
}

class State {
    private PrinterType nextPrinterType;

    public PrinterType getNextPrinterType() {
        return nextPrinterType;
    }

    public void setNextPrinterType(PrinterType nextPrinterType) {
        this.nextPrinterType = nextPrinterType;
    }

    public State(PrinterType nextPrinterType) {
        this.nextPrinterType = nextPrinterType;
    }
}

enum PrinterType{
    ODD,
    EVEN;
}