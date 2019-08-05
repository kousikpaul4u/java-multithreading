package threads;

import java.util.concurrent.TimeUnit;

// 1. We are using Runnable interface instead of extending Thread class
// 2. We are writing start() method outside the constructor by this way We can able to capture Thread reference in main method
// 3. We can able to manipulate the thread execution
// 4. Here task definition is entirely isolated with thread related code
public class FourthWay {
    public static void main(String[] args) {
        System.out.println("Main Thread start here...");
        new Thread(new FourthTask());
        Thread t = new Thread(new FourthTask());
        t.start();
        System.out.println("Main Thread ends here...");
    }
}
class FourthTask implements Runnable {
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
    public FourthTask() {
        this.id = ++count;
    }
}