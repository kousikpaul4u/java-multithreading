package threads;

import java.util.concurrent.TimeUnit;

public class SecondWay {
    public static void main(String[] args) {
        System.out.println("Main Thread start here...");
        new SecondTask().start();
        Thread t = new SecondTask();
        t.start();
        System.out.println("Main Thread ends here...");
    }
}
class SecondTask extends Thread {
    private static int count = 0;
    private int id;
    @Override
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
    public SecondTask() {
        this.id = ++count;
    }
}
