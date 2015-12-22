package concurrency.examples.lockfullexample;

/**
 *
 * 
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
