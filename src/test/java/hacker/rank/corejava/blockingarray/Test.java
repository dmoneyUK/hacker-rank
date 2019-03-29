package hacker.rank.corejava.blockingarray;

import java.util.concurrent.Executors;

public class Test {
    
    public static void main(String[] args) {
        BlockingArray blockingArray = new BlockingArray();
        
        Executors.newSingleThreadExecutor().submit(() -> {
            RandomIntProducer randomIntProducer = new RandomIntProducer();
            try {
                randomIntProducer.execute(blockingArray);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        Executors.newSingleThreadExecutor().submit(() -> {
            LoopingConsumer consumer = new LoopingConsumer();
            consumer.accept(blockingArray);
        });
    }
}
