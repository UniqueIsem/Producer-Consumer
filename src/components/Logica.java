package components;

import java.util.concurrent.BlockingQueue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Logica {

    //Declaration icon's url
    String imgItem = "../images/pizza.png";
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
            queue.put(item);
            SwingUtilities.invokeLater(() -> setItemIcon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consumir() {
        try {
            int item = queue.take();
            SwingUtilities.invokeLater(() -> setItemIcon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Obtains the number of lbl on pnlItems and set them an img depending on queue size
    private void setItemIcon() {
        for (int i = 0; i < pnlItems.getComponentCount(); i++) {
            JLabel label = (JLabel) pnlItems.getComponent(i);
            if (i < queue.size()) {
                ImageIcon icon = new ImageIcon(getClass().getResource(imgItem));
                label.setIcon(icon);
            } else {
                label.setIcon(null);
            }
        }
    }
}
