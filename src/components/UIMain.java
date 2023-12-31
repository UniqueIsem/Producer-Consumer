package components;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UIMain extends javax.swing.JFrame {
    
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    Productor productor;
    Consumidor consumidor;
    Logica logica;

    public UIMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.logica = new Logica(queue, pnlItems);
        this.productor = new Productor(queue, logica, lblProducer);
        this.consumidor = new Consumidor(queue, logica, lblConsumer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBody = new javax.swing.JPanel();
        pnlProducer = new javax.swing.JPanel();
        lblProducer = new javax.swing.JLabel();
        pnlConsumer = new javax.swing.JPanel();
        lblConsumer = new javax.swing.JLabel();
        pnlItems = new javax.swing.JPanel();
        Item1 = new javax.swing.JLabel();
        Item2 = new javax.swing.JLabel();
        Item3 = new javax.swing.JLabel();
        Item4 = new javax.swing.JLabel();
        Item5 = new javax.swing.JLabel();
        Item6 = new javax.swing.JLabel();
        Item7 = new javax.swing.JLabel();
        Item8 = new javax.swing.JLabel();
        Item9 = new javax.swing.JLabel();
        Item10 = new javax.swing.JLabel();
        pnlBtns = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        pnlTime = new javax.swing.JPanel();
        lblTimeProducer = new javax.swing.JLabel();
        txtProducer = new javax.swing.JTextField();
        btnTimeProducer = new javax.swing.JButton();
        lblTimeConsumer = new javax.swing.JLabel();
        txtConsumer = new javax.swing.JTextField();
        btnTimeConsumer = new javax.swing.JButton();
        pnlPC = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBody.setBackground(new java.awt.Color(0, 0, 0));
        pnlBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlProducer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 40));

        lblProducer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dormir.png"))); // NOI18N
        pnlProducer.add(lblProducer);

        pnlBody.add(pnlProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 150));

        pnlConsumer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 40));

        lblConsumer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dormir.png"))); // NOI18N
        pnlConsumer.add(lblConsumer);

        pnlBody.add(pnlConsumer, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 210, 150));

        pnlItems.setLayout(new java.awt.GridLayout(2, 5, 2, 2));
        pnlItems.add(Item1);
        pnlItems.add(Item2);
        pnlItems.add(Item3);
        pnlItems.add(Item4);
        pnlItems.add(Item5);
        pnlItems.add(Item6);
        pnlItems.add(Item7);
        pnlItems.add(Item8);
        pnlItems.add(Item9);
        pnlItems.add(Item10);

        pnlBody.add(pnlItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 210));

        pnlBtns.setLayout(new java.awt.GridLayout(1, 0));

        btnStart.setBackground(new java.awt.Color(51, 204, 0));
        btnStart.setForeground(new java.awt.Color(0, 0, 0));
        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        pnlBtns.add(btnStart);

        btnStop.setBackground(new java.awt.Color(204, 0, 0));
        btnStop.setForeground(new java.awt.Color(0, 0, 0));
        btnStop.setText("STOP");
        btnStop.setEnabled(false);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        pnlBtns.add(btnStop);

        pnlBody.add(pnlBtns, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 220, 120));

        pnlTime.setLayout(new java.awt.GridLayout(2, 3, 3, 3));

        lblTimeProducer.setText("Sleep time from Producer : ");
        pnlTime.add(lblTimeProducer);
        pnlTime.add(txtProducer);

        btnTimeProducer.setText("Set Time");
        btnTimeProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeProducerActionPerformed(evt);
            }
        });
        pnlTime.add(btnTimeProducer);

        lblTimeConsumer.setText("Sleep time from Consumer : ");
        pnlTime.add(lblTimeConsumer);
        pnlTime.add(txtConsumer);

        btnTimeConsumer.setText("Set Time");
        btnTimeConsumer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeConsumerActionPerformed(evt);
            }
        });
        pnlTime.add(btnTimeConsumer);

        pnlBody.add(pnlTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 410, 120));

        pnlPC.setBackground(new java.awt.Color(0, 0, 0));
        pnlPC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Producer Consumer");
        pnlPC.add(lblTitle);
        pnlPC.add(lblBody);

        pnlBody.add(pnlPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 250, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        Thread producerThread = new Thread(productor);
        Thread consumerThread = new Thread(consumidor);

        producerThread.start();
        consumerThread.start();
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        productor.detener();
        //consumidor.detener();
        btnStop.setEnabled(false);
        btnStart.setEnabled(true);
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnTimeProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeProducerActionPerformed
        int time = Integer.parseInt(txtProducer.getText());
        productor.setProducerSleepTime(time);
        txtProducer.setText("");
    }//GEN-LAST:event_btnTimeProducerActionPerformed

    private void btnTimeConsumerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeConsumerActionPerformed
        int time = Integer.parseInt(txtConsumer.getText());
        consumidor.setConsumerSleepTime(time);
        txtConsumer.setText("");
    }//GEN-LAST:event_btnTimeConsumerActionPerformed

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
    private javax.swing.JLabel Item10;
    private javax.swing.JLabel Item2;
    private javax.swing.JLabel Item3;
    private javax.swing.JLabel Item4;
    private javax.swing.JLabel Item5;
    private javax.swing.JLabel Item6;
    private javax.swing.JLabel Item7;
    private javax.swing.JLabel Item8;
    private javax.swing.JLabel Item9;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnTimeConsumer;
    private javax.swing.JButton btnTimeProducer;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblConsumer;
    private javax.swing.JLabel lblProducer;
    private javax.swing.JLabel lblTimeConsumer;
    private javax.swing.JLabel lblTimeProducer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlBtns;
    private javax.swing.JPanel pnlConsumer;
    private javax.swing.JPanel pnlItems;
    private javax.swing.JPanel pnlPC;
    private javax.swing.JPanel pnlProducer;
    private javax.swing.JPanel pnlTime;
    private javax.swing.JTextField txtConsumer;
    private javax.swing.JTextField txtProducer;
    // End of variables declaration//GEN-END:variables
}
