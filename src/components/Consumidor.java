package components;

import java.awt.MediaTracker;
import java.util.concurrent.BlockingQueue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Consumidor implements Runnable {

    //Declaration of producer icon url
    String imgConsumer = "../images/consumidor.gif";
    String imgSleep = "../images/dormir.png";
    //Item List queue shared by both
    private BlockingQueue<Integer> queue;
    //Thread flag is running
    private volatile boolean running = true;
    private int sleepConsumer = 1500;
    Logica logica;
    JLabel lblConsumer;

    public Consumidor(BlockingQueue<Integer> queue, Logica logica, JLabel lblConsumer) {
        this.queue = queue;
        this.logica = logica;
        this.lblConsumer = lblConsumer;
    }

    @Override
    public void run() {
        try {
            setConsumerRunning(true);
            while (running) {
                if (queue.size() != 0) {
                    setConsumerIcon();
                    logica.consumir();
                    Thread.sleep(sleepConsumer);
                    System.out.println("consumer" + queue);
                } else {
                    setConsumerIconSleep();
                    Thread.sleep(5000);
                }
                setConsumerIconSleep();
                Thread.sleep(sleepConsumer);
            }
            setConsumerIcon();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void setConsumerRunning(boolean running) {
        this.running = running;
        setConsumerIcon();
    }

    public void setConsumerIcon() {
        //thread consumer is running? yes : no
        ImageIcon icon = new ImageIcon(getClass().getResource(running ? imgConsumer : imgSleep));
        if (icon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Consumer img failed loading...");
        } else {
            lblConsumer.setIcon(icon);
        }
    }

    public void setConsumerIconSleep() {
        ImageIcon icon = new ImageIcon(getClass().getResource(imgSleep));
        if (icon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("ConsumerSleep img failed loading...");
        } else {
            lblConsumer.setIcon(icon);
        }
    }

    public void setConsumerSleepTime(int sleepTime) {
        sleepConsumer = sleepTime;
        System.out.println("Consumer now sleeps " + sleepConsumer + "ms");
    }

    public void detener() {
        running = false;
    }
}
