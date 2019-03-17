package hacker.rank.corejava;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestVolatile {

    int a, b;
    Boolean normalKeepRunning = true;
    volatile Boolean volatileKeepRunning = true;

    @Test
    public void should_never_finish_if_not_using_any_visibility_control() throws InterruptedException, ExecutionException {

        Future<Integer> future = runTask(normalKeepRunning);

        stopNormalRunning();

        getResult(future);
    }

    @Test
    public void should_finish_if_using_volatile() throws InterruptedException, ExecutionException {

        Future<Integer> future = runTask(volatileKeepRunning);

        stopVolatileRunning();

        getResult(future);
    }

    private Future<Integer> runTask(Boolean keepRunning) {
        return Executors.newSingleThreadExecutor()
                        .submit(() -> {
                            int count = 0;
                            while (keepRunning) {
                                count++;
                            }
                            return count;
                        });
    }

    private void stopNormalRunning() throws InterruptedException {
        Thread.sleep(1000);

        normalKeepRunning = false;
        System.out.println(Thread.currentThread().getName() + " set volatileKeepRunning: " + volatileKeepRunning);
    }

    private void stopVolatileRunning() throws InterruptedException {
        Thread.sleep(1000);

        volatileKeepRunning = false;
        System.out.println(Thread.currentThread().getName() + " set volatileKeepRunning: " + volatileKeepRunning);
    }

    private void getResult(Future<Integer> future) throws InterruptedException, ExecutionException {
        int count = future.get();
        System.out.println("Finished after: " + count);
    }

    //void run() {
    //    //
    //    Executors.newSingleThreadExecutor().submit(() -> {
    //
    //        long count = 0;
    //        while (volatileKeepRunning) {
    //            //synchronized (volatileKeepRunning){
    //            //flag = flag == WaiterEnum.WAITOR_ONE ? WaiterEnum.WAITER_TWO : WaiterEnum.WAITOR_ONE;
    //            //}
    //            //count = increase(count);
    //            count++;
    //
    //            //try {
    //            //    Thread.sleep(1000);
    //            //} catch (InterruptedException e) {
    //            //    e.printStackTrace();
    //            //}
    //            //if(!volatileKeepRunning) {
    //            //System.out.println(Thread.currentThread().getName() + " see volatileKeepRunning: " + volatileKeepRunning);
    //            //}
    //        }
    //        System.out.println("Finished after: " + count);
    //        System.out.println("a = " + a);
    //        System.out.println("b = " + b);
    //        //System.out.println("a = " + a);
    //        //System.out.println("b = " + b);
    //        System.exit(0);
    //    });
    //
    //}
    //
    //void finish() {
    //    //Executors.newSingleThreadExecutor().submit(() -> {
    //    //synchronized (volatileKeepRunning) {
    //    //volatileKeepRunning = false;
    //    //flag = WaiterEnum.WAITER_TWO;
    //
    //    this.b = 2;
    //    this.a = 2;
    //    volatileKeepRunning = false;
    //    System.out.println(Thread.currentThread().getName() + " set volatileKeepRunning: " + volatileKeepRunning);
    //
    //    //System.out.println(Thread.currentThread().getName() + " set flag: " + WaiterEnum.WAITER_TWO);
    //    //}
    //    //});
    //}
    ////
    ////void increaseA(){
    ////    this.a ++;
    ////}
    ////
    ////void increaseB(){
    ////    this.b ++;
    ////}
    //
    ////volatileKeepRunning
    //synchronized long increase(long count) {
    //    return count + 1;
    //}
    //
    //synchronized void doNothing() {
    //
    //}
    //
    //enum WaiterEnum {
    //    WAITOR_ONE, WAITER_TWO;
    //}

}
