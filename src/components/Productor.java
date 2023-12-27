package components;

import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable {

    private BlockingQueue<Integer> queue;
    private volatile boolean running = true;

    public Productor(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    
    public void detener(){
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running) {
                int item = (int) (Math.random() * 4);
                queue.put(item);
                
                System.out.println(queue.size());

                System.out.println("Productor CREO " +item);
                //Se implementa algo para el productor
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void sleep(){
        
    }
}
