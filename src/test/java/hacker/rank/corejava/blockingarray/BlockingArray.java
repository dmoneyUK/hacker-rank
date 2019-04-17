package hacker.rank.corejava.blockingarray;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingArray {
    
    public final int SIZE;
    private int[] arr;
    private int addPointer;
    private int removalPointer;
    
    public BlockingArray() {
        SIZE = 10;
        this.arr = new int[SIZE];
        Arrays.fill(arr, -1);
        addPointer = 0;
        removalPointer = 0;
    }
    
    public synchronized void add(int i) throws InterruptedException {
        if (addPointer >= SIZE) {
            addPointer = 0;
            System.out.println("Reset add pointer to 0");
        }
    
        if (arr[addPointer] != -1) {
            System.out.println("The array is full so wait for free some space.");
            wait();
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
        }
    
        if (arr[removalPointer] == -1) {
            System.out.println("The array is empty so wait for new elements.");
            wait();
        } else {
            ans = arr[removalPointer];
            System.out.println("The element " + ans + " has been removed from the array[" + removalPointer + "]");
            arr[removalPointer]=-1;
            removalPointer++;
            notifyAll();
            System.out.println("Notify removal");
        }
        return ans;
    }
}
