package concurrency.examples;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * This is a simple example of CountDownLatch. You can think about it as a barrier which blocks other threads to run
 * until specific condition is reached.
 * Basically the aim of the Latch is to block threads until count reaches 0.
 * The count is specified with CountDownLatch constructor.
 * In below example await method (countDownLatch.await()) blocks thread threadWitLatchExample until countDownLatch reaches
 * value equals to zero.
 * Second thread externalEventWhichDecreaseLatch actually decreases the latch counter. After for seconds thread
 * threadWitLatchExample will print text 'hello from thread: ' because latch counter is equal to zero.
 *
 * Two main methods:
 * countDown() - decrease count
 * await() -  await until count is equals to zero.
 */

public class CountDownLatchExample {

    public static final CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) {

        System.out.println("hello from main: " + Thread.currentThread().getName());

        Thread threadWitLatchExample = new Thread() {
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("hello from thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread externalEventWhichDecreaseLatch = new Thread(){
            public void run(){
                try {
                    for (int i = 0; i < 4; i++) {
                    TimeUnit.SECONDS.sleep(1);
                        countDownLatch.countDown();
                        System.out.printf("Decrising the latch form the thread: %s \r\n", Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        threadWitLatchExample.start();
        externalEventWhichDecreaseLatch.start();
    }

}
