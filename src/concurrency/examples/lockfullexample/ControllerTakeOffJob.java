package concurrency.examples.lockfullexample;

/**
 *
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
