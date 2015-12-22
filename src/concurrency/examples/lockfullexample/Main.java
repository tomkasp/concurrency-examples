package concurrency.examples.lockfullexample;

/**
 *
 *
 *
 */
public class Main {

    public static void main(String[] args) {

        int MAX_THREDS = 15;
        Thread thread[] = new Thread[MAX_THREDS];
        ReentrantLockAirportFullExample reentrantLockAirportFullExample = new ReentrantLockAirportFullExample();

        /**
         * Take down procedure
         */
        for (int i = 0; i < MAX_THREDS; i++) {
            thread[i] = new Thread(new ControllerTakeDownJob(reentrantLockAirportFullExample));
        }

        for (int i = 0; i < MAX_THREDS; i++) {
            thread[i].start();
        }

        /**
         * Take off procedure
         */
        for (int i = 0; i < 5; i++) {
            thread[i] = new Thread(new ControllerTakeOffJob(reentrantLockAirportFullExample));
        }

        for (int i = 0; i < 5; i++) {
            thread[i].start();
        }

    }

}
