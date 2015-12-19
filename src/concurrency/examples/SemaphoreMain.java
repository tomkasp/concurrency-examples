package concurrency.examples;

import java.util.concurrent.TimeUnit;

/**
 * Created by tomkasp on 17/12/15.
 */
public class SemaphoreMain {

    public static void main(String[] args) throws InterruptedException {
        final SemaphoreTrainStationExample semaphoreSimpleExample = new SemaphoreTrainStationExample();
        Thread thread1 = new Thread(){
            public void run(){
                try {
                    semaphoreSimpleExample.parkTrain();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread("Train manager"){
            public void run(){
                try {
                    semaphoreSimpleExample.parkTrain();
                    TimeUnit.SECONDS.sleep(1);
                    semaphoreSimpleExample.releaseTrain();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread3 = new Thread(){
            public void run(){
                try {
                    semaphoreSimpleExample.parkTrain();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
