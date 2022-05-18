import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public  class Concurrent extends AbstractQueuedSynchronizer implements Runnable{

    volatile int count = 100;

    Lock lock = new ReentrantLock();



    public int doCalculate() {
        lock.lock();



        try {
            for (int i = 0; i < 10; i++) {
                count--;
                System.out.println(Thread.currentThread().getName() + "==" + count);
            }
        } catch (Exception e) {

        }finally {
            lock.unlock();

        }

        return count;
    }

    @Override
    public void run() {
        int v = doCalculate();

    }

    public static void main(String[] args) {
        Concurrent concurrent = new Concurrent();

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(concurrent);
            thread1.start();
        }




    }

}
