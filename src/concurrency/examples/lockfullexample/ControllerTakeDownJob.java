package concurrency.examples.lockfullexample;

/**
 * Created by tomkasp on 22/12/15.
 */
public class ControllerTakeDownJob implements Runnable {

    private final ReentrantLockAirportFullExample reentrantLockAirportExample;

    public ControllerTakeDownJob(ReentrantLockAirportFullExample reentrantLockAirportExample) {
        this.reentrantLockAirportExample = reentrantLockAirportExample;
    }


    @Override
    public void run() {

        System.out.printf("Running thread %s", Thread.currentThread().getName());
        reentrantLockAirportExample.takeDown();

    }
}
