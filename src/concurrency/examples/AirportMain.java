package concurrency.examples;

/**
 *
 *
 */
public class AirportMain {


    public static void main(String[] args) {
        Thread thread[]=new Thread[10];
    final ReentrantLockAirportExample reentrantLockAirportExample = new ReentrantLockAirportExample();
        for (int i=0; i<10; i++){
            thread[i]=new Thread("Thread "+ i){
                @Override
                public void run(){
                    reentrantLockAirportExample.airplaneTakdeDownPermission();
                }
            };
        }

        for (int i=0; i<10; i++){
            thread[i].start();
        }
    }



}
