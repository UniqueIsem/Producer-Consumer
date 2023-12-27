package components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Productor implements Runnable {

    //This list contains the size of producers
    private final List<Productor> productores;
    //Declaration of producer icon url
    String imgProducer = "../images/productor.gif";
    String imgSleep = "../images/dormir.png";
    //Item List queue shared by both
    private BlockingQueue<Integer> queue;
    //thread flag is running
    private volatile boolean running = true;
    private int sleepProducer = 1000;
    Logica logica;
    JPanel pnlProducer;

    public Productor(BlockingQueue<Integer> queue, Logica logica, JPanel pnlProducer) {
        this.queue = queue;
        this.logica = logica;
        this.pnlProducer = pnlProducer;
        this.productores = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            setProducerRunning(true);
            while (running) {
                logica.producir();
                Thread.sleep(sleepProducer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setProducerRunning(boolean running) {
        this.running = running;
        setProducerIcon();
    }

    //Creates a new lbl on pnlProducer with a dynamic icon
    public void setProducerIcon() {
        JLabel lblProducer = new JLabel();
        //thread producer is running? yes : no
        ImageIcon icon = new ImageIcon(getClass().getResource(running ? imgProducer : imgSleep));
        lblProducer.setIcon(icon);
        pnlProducer.add(lblProducer);
        pnlProducer.revalidate(); // Asegura que se actualice la interfaz gráfica
        pnlProducer.repaint();

    }

    public void setProducerSleepTime(int sleepTime) {
        if (sleepTime >= 500 || sleepTime <= 2000) {
            sleepProducer = sleepTime;
            System.out.println("El Productor ahora duerme " + sleepProducer);
        }
    }

    public void detener() {
        running = false;
    }
}
