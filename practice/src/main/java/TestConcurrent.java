public class TestConcurrent implements Runnable{
    @Override
    public void run() {
        int total = 100;

        for (int i = 1; i <= total; i++) {
            System.out.println(Thread.currentThread().getName()+"这是第"+i+"个数字");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        TestConcurrent testConcurrent = new TestConcurrent();

        Thread thread = new Thread(testConcurrent);
        Thread thread1 = new Thread(testConcurrent);
        thread.start();
        thread1.start();
    }
}
