package concurrency.examples;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Consider SemaphoreTrainStationExample as a shared resource between threads. It's like an really live. One train
 * station is shared/managed by many traffic controllers.
 * 
 * Semaphore simple example based on a train station. Semaphore acts like a station witch allows to park and release
 * trains.
 *
 * Semaphore based methods:
 * acquire() - attempt to acquire a permit (permit is a value which is set when semaphore is constructed)
 * release()
 */
public class SemaphoreTrainStationExample {

    public final Semaphore semaphoreStation = new Semaphore(2, true);

    Queue<Train> trains = new ArrayBlockingQueue<Train>(10);


    public void parkTrain() throws InterruptedException {
        semaphoreStation.acquire();
        trains.add(new Train());
        System.out.println("Train has been parked by :" + Thread.currentThread().getName());
        System.out.printf("Number of trains in the station %s \r\n", trains.size());

    }

    public void releaseTrain() {
        System.out.println("Train left the station: " + Thread.currentThread().getName());
        semaphoreStation.release();
        trains.poll();
        System.out.printf("Number of trains in the station %s \r\n", trains.size());
    }


    public class Train {

    }


}
