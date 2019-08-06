package common;

import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public void run() {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("<THREAD-" + currentThreadName + ">" + "<TASK-ID-" + taskId + "> STARTING ######");
        for (int i = 10; i > 0; i--) {
            System.out.println("<THREAD-" + currentThreadName + ">" + "<TASK-ID-" + taskId + "> TIC-TIC " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("<THREAD-" + currentThreadName + ">" + "<TASK-ID-" + taskId + "> DONE ######");
    }

    public LoopTaskC() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskC: " + instanceNumber;
    }

}
