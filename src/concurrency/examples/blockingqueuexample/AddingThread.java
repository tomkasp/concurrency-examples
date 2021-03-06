package concurrency.examples.blockingqueuexample;

import java.util.concurrent.BlockingQueue;

/**
 * Simple usage of put method from a BlockingQueue.
 * put method tries to put element into the queue. When there is no free space
 * it makes current thread to sleep.
 */
public class AddingThread implements Runnable {

    private final BlockingQueue<Object> blockingQueue;

    public AddingThread(BlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        try {
            System.out.println("putting element into a queue");
            blockingQueue.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
