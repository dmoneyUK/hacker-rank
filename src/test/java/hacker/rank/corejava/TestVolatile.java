package hacker.rank.corejava;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class TestVolatile {

    int a, b;
    Boolean normalKeepRunning = true;
    volatile Boolean volatileKeepRunning = true;
    AtomicBoolean atomicKeepRunning = new AtomicBoolean(true);
    ReentrantLock lockingKeepRunning = new ReentrantLock(true);

    Callable<Long> NORMAL_KEEP_RUNNING_TASK = () -> {
        long count = 0;
        while (normalKeepRunning) {
            count++;
        }
        return count;
    };

    Callable<Long> VOLATILE_KEEP_RUNNING_TASK = () -> {
        long count = 0;
        while (volatileKeepRunning) {
            count++;
        }
        return count;
    };

    Callable<Long> ATOMIC_KEEP_RUNNING_TASK = () -> {
        long count = 0;
        while (atomicKeepRunning.get()) {
            count++;
        }
        return count;
    };

    Callable<Long> LOCKING_KEEP_RUNNING_TASK = () -> {
        long count = 0;

        while (normalKeepRunning) {
            lockingKeepRunning.lock();
            try {
                count++;
            } finally {
                lockingKeepRunning.unlock();
            }
        }
        return count;
    };


    @Test
    public void should_never_finish_if_not_using_any_visibility_control() throws InterruptedException, ExecutionException, TimeoutException {

        Assertions.assertThatThrownBy(() -> {
            Future<Long> future = runTask(NORMAL_KEEP_RUNNING_TASK);

            stopNormalRunning();

            getResult(future);
        }).isInstanceOf(TimeoutException.class);


    }

    @Test
    public void should_finish_if_using_volatile() throws InterruptedException, ExecutionException, TimeoutException {

        Future<Long> future = runTask(VOLATILE_KEEP_RUNNING_TASK);

        stopVolatileRunning();

        getResult(future);
    }

    @Test
    public void should_finish_if_using_atomic() throws InterruptedException, ExecutionException, TimeoutException {

        Future<Long> future = runTask(ATOMIC_KEEP_RUNNING_TASK);

        stopAtomicRunning();

        getResult(future);
    }

    @Test
    public void should_finsih_if_use_locking() throws InterruptedException, ExecutionException, TimeoutException {

        Future<Long> future = runTask(LOCKING_KEEP_RUNNING_TASK);

        stopLockingRunning();

        getResult(future);
    }

    private Future<Long> runTask(Callable task) {
        return Executors.newSingleThreadExecutor()
            .submit(task);
    }

    private void stopNormalRunning() throws InterruptedException {
        Thread.sleep(1000);

        normalKeepRunning = false;
        System.out.println(Thread.currentThread().getName() + " set normalKeepRunning: " + normalKeepRunning);
    }

    private void stopVolatileRunning() throws InterruptedException {
        Thread.sleep(1000);

        volatileKeepRunning = false;
        System.out.println(Thread.currentThread().getName() + " set volatileKeepRunning: " + volatileKeepRunning);
    }

    private void stopAtomicRunning() throws InterruptedException {
        Thread.sleep(1000);

        atomicKeepRunning.set(false);
        System.out.println(Thread.currentThread().getName() + " set atomicKeepRunning: " + atomicKeepRunning.get());
    }

    private void stopLockingRunning() throws InterruptedException {
        Thread.sleep(1000);
        lockingKeepRunning.lock();
        try {
            normalKeepRunning = false;
            System.out.println(Thread.currentThread().getName() + " set lockingKeepRunning: " + lockingKeepRunning);
        } finally {
            lockingKeepRunning.unlock();
        }
    }

    private void getResult(Future<Long> future) throws InterruptedException, ExecutionException, TimeoutException {
        long count = future.get(5, TimeUnit.SECONDS);
        System.out.println("Finished after: " + count / 100000);
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
