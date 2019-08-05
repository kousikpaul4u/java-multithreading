package executor;

import common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingSingleThreadExecutor {

    public static void main(String[] args) {
        System.out.println("Main Thread start here...");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());

        executorService.shutdown();

        System.out.println("Main Thread ends here...");
    }

}
