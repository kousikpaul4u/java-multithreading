package naming;

import common.LoopTaskC;

public class NamingThreadsSecondWay {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main Thread start here...");
        new Thread(new LoopTaskC(), "MA-FEE").start();

        Thread t2 = new Thread(new LoopTaskC());
        t2.setName("DELETE-WALLET");
        t2.start();

        System.out.println("[" + currentThreadName + "] Main Thread ends here...");
    }

}
