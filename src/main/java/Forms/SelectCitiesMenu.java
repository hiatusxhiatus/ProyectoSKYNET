
package Forms;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SelectCitiesMenu extends javax.swing.JFrame {

    public SelectCitiesMenu() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
              
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAccept = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaSecond = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaFirst = new javax.swing.JTextArea();
        txfSecond = new javax.swing.JTextField();
        txfFirst = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        btnAccept.setBackground(new java.awt.Color(51, 0, 153));
        btnAccept.setFont(new java.awt.Font("Pixel NES", 0, 8)); // NOI18N
        btnAccept.setForeground(new java.awt.Color(255, 255, 255));
        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        jPanel1.add(btnAccept);
        btnAccept.setBounds(544, 310, 72, 30);

        txaSecond.setBackground(new java.awt.Color(255, 255, 255));
        txaSecond.setColumns(20);
        txaSecond.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txaSecond.setForeground(new java.awt.Color(0, 0, 0));
        txaSecond.setRows(5);
        txaSecond.setText("fbdfhd");
        txaSecond.setEnabled(false);
        jScrollPane3.setViewportView(txaSecond);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(330, 100, 280, 180);

        txaFirst.setBackground(new java.awt.Color(255, 255, 255));
        txaFirst.setColumns(20);
        txaFirst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txaFirst.setForeground(new java.awt.Color(0, 0, 0));
        txaFirst.setRows(5);
        txaFirst.setText("dfghdfg");
        txaFirst.setEnabled(false);
        jScrollPane4.setViewportView(txaFirst);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(30, 100, 280, 180);

        txfSecond.setBackground(new java.awt.Color(255, 255, 255));
        txfSecond.setFont(new java.awt.Font("Pixel NES", 0, 12)); // NOI18N
        txfSecond.setForeground(new java.awt.Color(0, 0, 0));
        txfSecond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfSecondActionPerformed(evt);
            }
        });
        jPanel1.add(txfSecond);
        txfSecond.setBounds(380, 300, 100, 30);

        txfFirst.setBackground(new java.awt.Color(255, 255, 255));
        txfFirst.setFont(new java.awt.Font("Pixel NES", 0, 12)); // NOI18N
        txfFirst.setForeground(new java.awt.Color(0, 0, 0));
        txfFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfFirstActionPerformed(evt);
            }
        });
        jPanel1.add(txfFirst);
        txfFirst.setBounds(160, 302, 100, 30);

        jLabel4.setFont(new java.awt.Font("Pixel NES", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Second City");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(330, 70, 180, 20);

        jLabel3.setFont(new java.awt.Font("Pixel NES", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("First City");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 70, 180, 20);

        jLabel2.setFont(new java.awt.Font("Pixel NES", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Available Cities");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 20, 380, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.gif"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 640, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void txfFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfFirstActionPerformed

    private void txfSecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfSecondActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfSecondActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txaFirst;
    private javax.swing.JTextArea txaSecond;
    private javax.swing.JTextField txfFirst;
    private javax.swing.JTextField txfSecond;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAccept() {
        return btnAccept;
    }

    public JTextArea getTxaFirst() {
        return txaFirst;
    }

    public JTextArea getTxaSecond() {
        return txaSecond;
    }

    public JTextField getTxfFirst() {
        return txfFirst;
    }

    public JTextField getTxfSecond() {
        return txfSecond;
    }





}
