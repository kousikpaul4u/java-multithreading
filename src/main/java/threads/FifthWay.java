package threads;

import java.util.concurrent.TimeUnit;

// This approach is used for handling UI events, we don't need multiple instance for Thread.
// When any UI event arise it will create threads inline and execute core logic
public class FifthWay {
    public static void main(String[] args) {
        System.out.println("Main Thread start here...");
        new Thread(new Runnable() {
            public void run() {
                for (int i = 10; i > 0; i--) {
                    System.out.println("Tick->" + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 10; i > 0; i--) {
                    System.out.println("Tick->" + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }
}
