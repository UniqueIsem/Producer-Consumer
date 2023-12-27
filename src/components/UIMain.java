package components;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UIMain extends javax.swing.JFrame {

    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    private Productor productorThread;
    private Consumidor consumidorThread;

    public UIMain() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBody = new javax.swing.JPanel();
        pnlProducer = new javax.swing.JPanel();
        lblP1 = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        lblP3 = new javax.swing.JLabel();
        pnlConsumer = new javax.swing.JPanel();
        lblC1 = new javax.swing.JLabel();
        lblC2 = new javax.swing.JLabel();
        lblC3 = new javax.swing.JLabel();
        pnlItems = new javax.swing.JPanel();
        Item1 = new javax.swing.JLabel();
        pnlBtns = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        lblBody = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBody.setBackground(new java.awt.Color(153, 153, 153));
        pnlBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlProducer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));

        lblP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dormir.png"))); // NOI18N
        pnlProducer.add(lblP1);

        lblP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productor.gif"))); // NOI18N
        pnlProducer.add(lblP2);

        lblP3.setText("jLabel3");
        pnlProducer.add(lblP3);

        pnlBody.add(pnlProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 910, 150));

        lblC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dormir.png"))); // NOI18N
        pnlConsumer.add(lblC1);

        lblC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/consumidor.gif"))); // NOI18N
        lblC2.setText("jLabel2");
        pnlConsumer.add(lblC2);

        lblC3.setText("jLabel3");
        pnlConsumer.add(lblC3);

        pnlBody.add(pnlConsumer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 910, 150));

        pnlItems.setLayout(new java.awt.GridLayout(2, 5, 2, 2));

        Item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pizza.png"))); // NOI18N
        pnlItems.add(Item1);

        pnlBody.add(pnlItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 160));

        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        pnlBtns.add(btnStart);

        btnStop.setText("STOP");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        pnlBtns.add(btnStop);

        pnlBody.add(pnlBtns, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 190, 40));
        pnlBody.add(lblBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 843, 508));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        productorThread = new Productor(queue);
        consumidorThread = new Consumidor(queue);

        Thread producerThread = new Thread(productorThread);
        Thread consumerThread = new Thread(consumidorThread);

        producerThread.start();
        consumerThread.start();
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        productorThread.detener();
        consumidorThread.detener();
    }//GEN-LAST:event_btnStopActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Item1;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblC1;
    private javax.swing.JLabel lblC2;
    private javax.swing.JLabel lblC3;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblP3;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlBtns;
    private javax.swing.JPanel pnlConsumer;
    private javax.swing.JPanel pnlItems;
    private javax.swing.JPanel pnlProducer;
    // End of variables declaration//GEN-END:variables
}
