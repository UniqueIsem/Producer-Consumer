package components;

import java.awt.MediaTracker;
import java.util.concurrent.BlockingQueue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Productor implements Runnable {

    //Declaration of producer icon url
    String imgProducer = "../images/productor.gif";
    String imgSleep = "../images/dormir.png";
    //Item List queue shared by both
    private BlockingQueue<Integer> queue;
    //thread flag is running
    private volatile boolean running = true;
    private int sleepProducer = 1000;
    Logica logica;
    JLabel lblProducer;

    public Productor(BlockingQueue<Integer> queue, Logica logica, JLabel lblProducer) {
        this.queue = queue;
        this.logica = logica;
        this.lblProducer = lblProducer;
    }

    @Override
    public void run() {
        try {
            setProducerRunning(true);
            while (running) {
                if (queue.size() <= 9) {
                    setProducerIcon();
                    logica.producir();
                    Thread.sleep(sleepProducer);
                    System.out.println("producer" + queue);
                } else {
                    setProducerIconSleep();
                    Thread.sleep(5000);
                }
                setProducerIconSleep();
                Thread.sleep(sleepProducer);
            }
            setProducerIcon();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void setProducerRunning(boolean running) {
        this.running = running;
        setProducerIcon();
    }

    public void setProducerIcon() {
        //thread producer is running? yes : no
        ImageIcon icon = new ImageIcon(getClass().getResource(running ? imgProducer : imgSleep));
        if (icon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Producer img failed loading...");
        } else {
            lblProducer.setIcon(icon);
        }
    }

    public void setProducerIconSleep() {
        ImageIcon icon = new ImageIcon(getClass().getResource(imgSleep));
        if (icon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("ProducerSleepig img failed loading...");
        } else {
            lblProducer.setIcon(icon);
        }
    }

    public void setProducerSleepTime(int sleepTime) {
        sleepProducer = sleepTime;
        System.out.println("Producer now sleeps " + sleepProducer + "ms");
    }

    public void detener() {
        running = false;
    }
}
