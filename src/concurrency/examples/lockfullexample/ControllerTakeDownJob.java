package concurrency.examples.lockfullexample;

/**
 * This job is a Runnable type and it represents job done by flights controllers during take down of plains.
 *  Run method (template hook method) runs takeDown() method which acquires a lock on ReentrantLockAirportFullExample instance.
 *  and it case when there are no free slots for plain it puts current thread into a wait state.
 */
public class ControllerTakeDownJob implements Runnable {

    private final ReentrantLockAirportFullExample reentrantLockAirportExample;

    public ControllerTakeDownJob(ReentrantLockAirportFullExample reentrantLockAirportExample) {
        this.reentrantLockAirportExample = reentrantLockAirportExample;
    }


    @Override
    public void run() {

        reentrantLockAirportExample.takeDown();

    }
}
