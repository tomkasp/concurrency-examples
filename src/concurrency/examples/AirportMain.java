package concurrency.examples;

/**
 *
 *
 */
public class AirportMain {


    public static void main(String[] args) {
        int size = 13;
        Thread thread[] = new Thread[size];
        final ReentrantLockAirportExample reentrantLockAirportExample = new ReentrantLockAirportExample();
        for (int i = 0; i < size; i++) {
            thread[i] = new Thread("Thread " + i) {
                @Override
                public void run() {
                    reentrantLockAirportExample.airplaneTakeDownPermission();
                }
            };
        }

        for (int i = 0; i < size; i++) {
            thread[i].start();
        }
    }


}
