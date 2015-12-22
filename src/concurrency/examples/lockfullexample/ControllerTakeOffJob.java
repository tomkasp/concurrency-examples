package concurrency.examples.lockfullexample;

import concurrency.examples.ReentrantLockAirportExample;

/**
 * Created by tomkasp on 22/12/15.
 */
public class ControllerTakeOffJob implements Runnable {

    private final ReentrantLockAirportExample reentrantLockAirportExample;

    public ControllerTakeOffJob(ReentrantLockAirportExample reentrantLockAirportExample) {
        this.reentrantLockAirportExample = reentrantLockAirportExample;
    }

    @Override
    public void run() {

    }
}
