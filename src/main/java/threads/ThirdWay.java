package threads;

import java.util.concurrent.TimeUnit;

// 1. We are using Runnable interface instead of extending Thread class
// 2. We are creating Thread object in constructor and  providing 'this' reference before starting the Thread immediately
// 3. We are not capturing Thread reference in main method
// 4. This kind of approach is useful when we need fire and forget threads. We don't care about threads completion after starting it.
public class ThirdWay {
    public static void main(String[] args) {
        System.out.println("Main Thread start here...");
        new ThirdTask();
        new ThirdTask();
        System.out.println("Main Thread ends here...");
    }
}

class ThirdTask implements Runnable {
    private static int count = 0;
    private int id;
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("<" + id + ">Tick->" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public ThirdTask() {
        this.id = ++count;
        new Thread(this).start();
    }

}