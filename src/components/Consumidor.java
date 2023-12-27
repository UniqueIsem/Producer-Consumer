package components;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {

    private BlockingQueue<Integer> queue;
    private volatile boolean running = true;

    public Consumidor(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    
    public void detener(){
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running) {
                int item = queue.take();

                System.out.println("Consumidor TOMO " +item);
                //Se implementa algo para el consumidor
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
