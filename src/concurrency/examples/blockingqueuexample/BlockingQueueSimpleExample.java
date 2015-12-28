package concurrency.examples.blockingqueuexample;

import concurrency.examples.lockfullexample.ControllerTakeDownJob;
import concurrency.examples.lockfullexample.ReentrantLockAirportFullExample;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by tomkasp on 28/12/15.
 * This is a real life example how to use blocking queue implementation.
 */
public class BlockingQueueSimpleExample {

    /**
     * Blocking queue summary
     * put(E e) insert element into tail of the function - wait for a specific space if it's necessary.
     * ge
     */

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(5);

        int MAX_THREDS = 6;
        Thread thread[] = new Thread[MAX_THREDS];

        /**
         * Take down procedure
         */
        for (int i = 0; i < MAX_THREDS; i++) {
            thread[i] = new Thread(new AddingThread(linkedBlockingQueue));
        }

        for (int i = 0; i < MAX_THREDS; i++) {
            thread[i].start();
            TimeUnit.SECONDS.sleep(1);
        }

    }


}
