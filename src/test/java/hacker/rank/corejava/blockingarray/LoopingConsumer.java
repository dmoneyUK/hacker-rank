package hacker.rank.corejava.blockingarray;

import java.util.function.Consumer;

public class LoopingConsumer implements Consumer<BlockingArray> {
    
    @Override
    public void accept(BlockingArray blockingArray) {
        
        while (true) {
            try {
                System.out.println("Consume");
                blockingArray.remove();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
