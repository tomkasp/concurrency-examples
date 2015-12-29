package concurrency.examples.blockingqueuexample;

import java.util.concurrent.BlockingQueue;

/**
 *
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
