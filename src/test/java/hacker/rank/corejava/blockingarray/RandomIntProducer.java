package hacker.rank.corejava.blockingarray;

import java.util.Random;

public class RandomIntProducer {
    
    void execute(BlockingArray blockingArray) throws InterruptedException {
        Random rd = new Random();
        while (true) {
            int newElement = rd.nextInt(100);
            blockingArray.add(newElement);
            Thread.currentThread().sleep(1000);
        }
    }
}
