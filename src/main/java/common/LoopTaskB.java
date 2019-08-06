package common;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public void run() {

        Thread.currentThread().setName("MA-FEE-" + instanceNumber);
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

    public LoopTaskB() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskB: " + instanceNumber;
    }

}
