package hacker.rank.interviewpreparation.java8;

public class ConcurrentTest {
    public static void main(String[] args) throws InterruptedException {
        Waiter waiter = new Waiter();
        Thread waiterThread = new Thread(waiter);
        waiterThread.start();
        waiter.finish();
        waiterThread.join();
    }


    enum WaiterEnum{

        WAITOR_ONE;

    }

    static class Waiter implements Runnable {
        private boolean shouldFinish;
        void finish() {
            shouldFinish = true;
        }

        public void run() {
            long iteration = 0;
            while (!shouldFinish) {
            }
            iteration++;
            System.out.println("Finished after: " + iteration);
        }
    }

}
