package concurrency.examples;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrant Lock simple example
 * <p/>
 * Think about ReentrantLock and Lock interface as a more sophisticated version of a synchronization.
 * Below you can find really simple example how to use it. It's a airport example when planes can take down
 * in order. There is only one airstrip so only one thread can runs at once.
 *
 * When you use method lock on your resource from a Lock interface it acquires a lock on that resource
 * (in our case ReentrantLockAirportExample) for a thread which tried to run the method.
 * All other threads need to wait until lock is unlocked via unlock() method.
 * When unlock() runs next thread from all waiting threads will acquire a lock
 *
 *
 * Methods:
 * lock()
 * unlock()
 * interrupt()
 */
public class ReentrantLockAirportExample {

    private static final int MAX_PLANES = 2;
    Lock airportLock = new ReentrantLock();
    Queue<Object> planes = new LinkedList<>();


    public void airplaneTakeDownPermission() {
        airportLock.lock();
        try {
            if (planes.size() == MAX_PLANES) {
                System.out.println("to many planes you can't add more");
            } else {
                TimeUnit.SECONDS.sleep(30);
                System.out.printf("take down: %s \r\n", Thread.currentThread().getName());
                planes.add(new Object());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            airportLock.unlock();
        }
    }

}
