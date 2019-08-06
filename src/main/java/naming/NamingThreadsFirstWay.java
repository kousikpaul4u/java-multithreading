package naming;

import common.LoopTaskB;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingThreadsFirstWay {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main Thread start here...");
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new LoopTaskB());
        executorService.execute(new LoopTaskB());
        executorService.execute(new LoopTaskB());

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main Thread ends here...");
    }

}
