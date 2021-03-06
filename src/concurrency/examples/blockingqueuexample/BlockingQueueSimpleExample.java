package concurrency.examples.blockingqueuexample;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * This is a real life example how to use blocking queue implementation.
 */
public class BlockingQueueSimpleExample {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(5);

        int MAX_THREDS = 7;
        Thread puttingThreads[] = new Thread[MAX_THREDS];
        Thread takingThreads[] = new Thread[MAX_THREDS];

        /**
         * Putting threads
         */
        for (int i = 0; i < MAX_THREDS; i++) {
            puttingThreads[i] = new Thread(new AddingThread(linkedBlockingQueue));
        }

        /**
         * Taking threads
         */
        for (int i = 0; i < MAX_THREDS; i++) {
            takingThreads[i] = new Thread(new TakingThread(linkedBlockingQueue));
        }

        for (int i = 0; i < MAX_THREDS; i++) {
            puttingThreads[i].start();
            TimeUnit.SECONDS.sleep(1);
        }

        for (int i = 0; i < MAX_THREDS; i++) {
            takingThreads[i].start();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
