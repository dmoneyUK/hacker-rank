package concurrency.blockingarray;

import java.util.Arrays;
import java.util.concurrent.Executors;

public class BlockingArray {
    
    public final int SIZE;
    private int[] arr;
    private int addPointer;
    private int removalPointer;
    
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
    
    public BlockingArray() {
        SIZE = 10;
        this.arr = new int[SIZE];
        Arrays.fill(arr, -1);
        addPointer = 0;
        removalPointer = 0;
    }
    
    public synchronized void add(int i) throws InterruptedException {
        if (addPointer >= SIZE) {
            System.out.println("The array is full so wait for free some space.");
            wait();
            System.out.println("Reset add pointer to 0");
            addPointer = 0;
        }
        
        arr[addPointer] = i;
        System.out.println("new element " + i + " has been added to the array[" + addPointer + "]");
        addPointer++;
        notifyAll();
        
    }
    
    public synchronized int remove() throws InterruptedException {
        int ans = -1;
        if (removalPointer >= SIZE) {
            System.out.println("Reset removal pointer to 0");
            removalPointer = 0;
            notifyAll();
        } else if (arr[removalPointer]==-1) {
            System.out.println("The array is empty so wait for new elements.");
            wait();
        } else {
            ans = arr[removalPointer];
            System.out.println("The element " + ans + " has been removed from the array[" + removalPointer + "]");
            removalPointer++;
            notifyAll();
            System.out.println("Notify removal");
        }
        return ans;
    }
}
