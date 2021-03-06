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
 *
 * This example contains two methods
 * takeDown()
 * takeOff()
 * which simulates takeOff and take down of plains.
 *
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

    /**
     * When plainsContainer is full await method is executed on a takeDownCondition which puts
     * all threads which try to execute it into a sleep state. On the other side when takeOff method runs
     * line takeDownCondition.signalAll() sleeping threads are notify about it and try to execute takeDown method
     * again.
     *
     */
    public void takeDown() {
        System.out.printf("Attempt take down for thread: %s \r\n", Thread.currentThread().getName());
        lock.lock();
        try {
            if (plainsContainer.size() == MAX_SIZE) {
                System.out.printf("Container is full for thread: %s \r\n", Thread.currentThread().getName());
                takeDownCondition.await();
            }
            System.out.printf("Take down done by thread: %s \r\n", Thread.currentThread().getName());
            plainsContainer.add(new Object());
            takeOffCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * takeOff method works in a oposite way to the takeDown. When plainsContainer is empty it means that there are
     * no more plains to take off and next all threads which try to execute it are delegate to the sleep state.
     *Only takeOffCondition.signalAll(); from a takeDown method can awake them.
     */
    public void takeOff() {
        System.out.printf("Attempt take off for thread: %s \r\n", Thread.currentThread().getName());
        lock.lock();
        try {
            if (plainsContainer.size() == 0) {
                System.out.printf("Container is empty for thread: %s \r\n", Thread.currentThread().getName());
                takeOffCondition.await();
            }
            System.out.printf("Take off done by thread: %s \r\n", Thread.currentThread().getName());
            plainsContainer.remove(plainsContainer.size() - 1);
            takeDownCondition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
