package concurrency.examples.blockingqueuexample;

import java.util.concurrent.BlockingQueue;

/**
 *
 */
public class GettingThread implements Runnable{

    private final BlockingQueue blockingQueue;

    public GettingThread(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
