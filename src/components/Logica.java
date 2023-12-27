package components;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Logica {

    //Declaration of icon url
    String imgItem = "../images/pizza.png";
    String imgSleep = "../images/dormir.png";
    //Other variable declarations
    private final BlockingQueue<Integer> queue;
    private final JPanel pnlItems;
    int item = 0;

    //Logic Constructor
    public Logica(BlockingQueue<Integer> queue, JPanel pnlItems) {
        this.queue = queue;
        this.pnlItems = pnlItems;
    }

    public void producir() {
        try {
            while (queue.size() >= 10) {
                wait(); // Wait if queue is full
            }
            queue.put(item);
            setItemIcon();
            System.out.println(queue);

            notify(); //notify to consumers there is availabe items
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consumir() {
        try {
            while (queue.isEmpty()) {
                wait(); // Wait if queue is emty
            }
            int item = queue.take();
            setItemIcon();
            System.out.println(queue);
            
            notify(); //Notify to producer there is availabe space
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setItemIcon() {
        int size = queue.size();

        for (int i = 0; i < pnlItems.getComponentCount(); i++) {
            JLabel label = (JLabel) pnlItems.getComponent(i);

            if (i < size) {
                // Obtener el ícono de la variable imgItem
                ImageIcon icon = new ImageIcon(getClass().getResource(imgItem));
                label.setIcon(icon);
            } else {
                label.setIcon(null);
            }
        }
    }
}
