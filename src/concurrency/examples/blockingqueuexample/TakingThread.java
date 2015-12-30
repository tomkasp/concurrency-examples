package concurrency.examples.blockingqueuexample;

import java.util.concurrent.BlockingQueue;

/**
 * Simple usage of take method from a BlockingQueue.
 * take method tries to take element from the queue. When there are no elements inside queue
 * it makes current thread to sleep.
 */
public class TakingThread implements Runnable{

    private final BlockingQueue blockingQueue;

    public TakingThread(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println("taking an element from the queue");
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
