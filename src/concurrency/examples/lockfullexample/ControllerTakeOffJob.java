package concurrency.examples.lockfullexample;

/**
 * This job is a Runnable and it represents job done by flights controllers during take off of plains.
 *  Inside hook method - run, it runs takeOff method which acquires a lock on ReentrantLockAirportFullExample instance.
 *  and it case when there are no pending plains to take off it puts current thread into a wait state.
 */
public class ControllerTakeOffJob implements Runnable {

    private final ReentrantLockAirportFullExample reentrantLockAirportExample;

    public ControllerTakeOffJob(ReentrantLockAirportFullExample reentrantLockAirportExample) {
        this.reentrantLockAirportExample = reentrantLockAirportExample;
    }

    @Override
    public void run() {
        reentrantLockAirportExample.takeOff();
    }
}
