import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread extends Thread{
    ReentrantLock lock = new ReentrantLock();
    volatile int total =  100;
    volatile int count =  0;


    @Override
    public void run() {

        //lock.lock();
        for (int i = 0; i < 100; i++) {
            total-=1;
            count+=1;
            System.out.println(Thread.currentThread().getName() + "===" + "total等于" + total);
        }
        try {
            System.out.println("total="+total);
            System.out.println("count="+count);
        }finally {
            //lock.unlock();
        }


    }

    public static void main(String[] args){
        TestThread testThread = new TestThread();

        Thread thread = new Thread(testThread);
        Thread thread1 = new Thread(testThread);

        thread.start();
        thread1.start();

    }
}
