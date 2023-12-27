package components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Consumidor implements Runnable {

    //This list contains the size of the consumers
    private final List<Consumidor> consumidores;
    //Declaration of producer icon url
    String imgConsumer = "../images/consumidor.gif";
    String imgSleep = "../images/dormir.png";
    //Item List queue shared by both
    private BlockingQueue<Integer> queue;
    //Thread flag is running
    private volatile boolean running = true;
    private int sleepConsumer = 1500;
    Logica logica;
    JPanel pnlConsumer;

    public Consumidor(BlockingQueue<Integer> queue, Logica logica, JPanel pnlConsumer) {
        this.queue = queue;
        this.logica = logica;
        this.pnlConsumer = pnlConsumer;
        this.consumidores = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            setConsumerRunning(true);
            while (running) {
                logica.consumir();
                Thread.sleep(sleepConsumer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setConsumerRunning(boolean running) {
        this.running = running;
        setConsumerIcon();
    }

    public void setConsumerIcon() {
        JLabel lblConsumer = new JLabel();
        //thread consumer is running? yes : no
        ImageIcon icon = new ImageIcon(getClass().getResource(running ? imgConsumer : imgSleep));
        lblConsumer.setIcon(icon);
        pnlConsumer.add(lblConsumer);
        pnlConsumer.revalidate(); // Asegura que se actualice la interfaz gráfica
        pnlConsumer.repaint();
    }

    public void setConsumerSleepTime(int sleepTime) {
        if (sleepTime >= 500 || sleepTime <= 2000) {
            sleepConsumer = sleepTime;
            System.out.println("El Consumidor ahora duerme " + sleepConsumer);
        }
    }

    public void detener() {
        running = false;
    }
}
