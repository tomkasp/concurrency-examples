package concurrency.examples.lockfullexample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is an example of more complicated usage of the ReentrantLock with Condition.
 * <p/>
 * As an example we will use again Airport but this time more advanced use case.
 * When you create a Condition object you need to use factory method from the Lock interface - newCondition()
 * Condition objects cooperate strongly with the Lock object.
 */
public class ReentrantLockAirportFullExample {

    public static final int MAX_SIZE = 10;

    List<Object> plainsContainer = new ArrayList<>();
    Lock lock = new ReentrantLock();
    Condition takeDownCondition;
    Condition takeOffCondition;

    public ReentrantLockAirportFullExample() {
        takeDownCondition = lock.newCondition();
        takeOffCondition = lock.newCondition();
    }

    public void takeDown() {
        System.out.printf("attempt take down for thread: %s", Thread.currentThread().getName());
        lock.lock();
        try {
            if (plainsContainer.size() == MAX_SIZE) {
                System.out.printf("container is full for thread: %s", Thread.currentThread().getName());
                takeDownCondition.await();
            }
            plainsContainer.add(new Object());
            takeOffCondition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void takeOff() {
        lock.lock();
        try {
            if (plainsContainer.size() == 0) {
                takeOffCondition.await();
            }
            plainsContainer.remove(plainsContainer.size() - 1);
            takeDownCondition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
