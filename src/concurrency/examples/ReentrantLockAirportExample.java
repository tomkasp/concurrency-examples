package concurrency.examples;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrant Lock simple example
 * <p/>
 * Think about ReentrantLock and Lock interface as a more sophisticated version of a synchronization.
 * <p/>
 * <p/>
 * <p/>
 * Methods:
 * <p/>
 * lock()
 * unlock()
 * interrupt()
 */
public class ReentrantLockAirportExample {

    private static final int MAX_PLANES = 10;
    Lock airportLock = new ReentrantLock();
    Queue<Object> planes = new LinkedList<>();


    public void airplaneTakdeDownPermission() {
        try {
            airportLock.lock();
            if (planes.size() == MAX_PLANES) {
            } else {
                System.out.printf("take down %s \r\n", Thread.currentThread().getName());
                planes.add(new Object());
            }
        } finally {
            airportLock.unlock();
        }
    }


    public void airplaneTakeOffPermission() {
//        if ()

    }

}
