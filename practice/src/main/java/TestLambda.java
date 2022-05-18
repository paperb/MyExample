import java.util.List;

public class TestLambda {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("world");
            }
        };
        runnable.run();
        r.run();
    }
}
