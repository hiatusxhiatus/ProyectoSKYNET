
package Forms;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends javax.swing.JFrame {

    public Window() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGraphs = new javax.swing.JPanel();
        pnlBefore = new javax.swing.JPanel();
        pnlAfter = new javax.swing.JPanel();
        bgBefore = new javax.swing.JLabel();
        bgAfter = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txfUploadGraph = new javax.swing.JTextField();
        btnAnnihilate = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        btnNextRound = new javax.swing.JButton();
        cbxAnnihilateCode = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlGraphs.setBackground(new java.awt.Color(0, 0, 0));
        pnlGraphs.setLayout(null);

        pnlBefore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pnlBefore.setOpaque(false);
        pnlBefore.setLayout(new java.awt.BorderLayout());
        pnlGraphs.add(pnlBefore);
        pnlBefore.setBounds(20, 190, 520, 500);

        pnlAfter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pnlAfter.setOpaque(false);
        pnlAfter.setLayout(new java.awt.BorderLayout());
        pnlGraphs.add(pnlAfter);
        pnlAfter.setBounds(560, 190, 520, 500);

        bgBefore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgBefore.png"))); // NOI18N
        bgBefore.setText("jLabel1");
        pnlGraphs.add(bgBefore);
        bgBefore.setBounds(20, 190, 520, 500);

        bgAfter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgAfter.png"))); // NOI18N
        bgAfter.setText("jLabel1");
        pnlGraphs.add(bgAfter);
        bgAfter.setBounds(560, 190, 520, 500);

        jLabel5.setFont(new java.awt.Font("Pixel NES", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("After");
        pnlGraphs.add(jLabel5);
        jLabel5.setBounds(560, 150, 70, 40);

        jLabel4.setFont(new java.awt.Font("Pixel NES", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Before");
        pnlGraphs.add(jLabel4);
        jLabel4.setBounds(470, 150, 70, 40);

        jLabel2.setFont(new java.awt.Font("Pixel NES", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Upload a new Graph");
        pnlGraphs.add(jLabel2);
        jLabel2.setBounds(20, 120, 210, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/image_2023-11-24_173408039-removebg-preview (1).png"))); // NOI18N
        pnlGraphs.add(jLabel6);
        jLabel6.setBounds(860, 10, 220, 150);

        txfUploadGraph.setBackground(new java.awt.Color(255, 255, 255));
        txfUploadGraph.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txfUploadGraph.setForeground(new java.awt.Color(0, 0, 0));
        txfUploadGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfUploadGraphActionPerformed(evt);
            }
        });
        pnlGraphs.add(txfUploadGraph);
        txfUploadGraph.setBounds(20, 140, 210, 30);

        btnAnnihilate.setBackground(new java.awt.Color(51, 0, 153));
        btnAnnihilate.setFont(new java.awt.Font("Pixel NES", 0, 12)); // NOI18N
        btnAnnihilate.setForeground(new java.awt.Color(255, 255, 255));
        btnAnnihilate.setText("Annihilate");
        pnlGraphs.add(btnAnnihilate);
        btnAnnihilate.setBounds(20, 30, 210, 30);

        btnUpload.setBackground(new java.awt.Color(51, 0, 153));
        btnUpload.setFont(new java.awt.Font("Pixel NES", 0, 12)); // NOI18N
        btnUpload.setForeground(new java.awt.Color(255, 255, 255));
        btnUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tick.png"))); // NOI18N
        pnlGraphs.add(btnUpload);
        btnUpload.setBounds(240, 140, 30, 30);

        btnNextRound.setBackground(new java.awt.Color(51, 0, 153));
        btnNextRound.setFont(new java.awt.Font("Pixel NES", 0, 12)); // NOI18N
        btnNextRound.setForeground(new java.awt.Color(255, 255, 255));
        btnNextRound.setText("Next Round");
        pnlGraphs.add(btnNextRound);
        btnNextRound.setBounds(20, 72, 210, 30);

        cbxAnnihilateCode.setBackground(new java.awt.Color(51, 0, 153));
        cbxAnnihilateCode.setFont(new java.awt.Font("Pixel NES", 0, 12)); // NOI18N
        cbxAnnihilateCode.setForeground(new java.awt.Color(255, 255, 255));
        cbxAnnihilateCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Annihilate code 1", "Annihilate code 2", "Annihilate code 3", "Annihilate code 4", "Annihilate code 5", "Annihilate code 6", "Annihilate code 7", "Annihilate code 8", "Annihilate code 9", "Annihilate code 10" }));
        cbxAnnihilateCode.setFocusable(false);
        pnlGraphs.add(cbxAnnihilateCode);
        cbxAnnihilateCode.setBounds(260, 30, 200, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGraphs, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGraphs, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfUploadGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfUploadGraphActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfUploadGraphActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgAfter;
    private javax.swing.JLabel bgBefore;
    private javax.swing.JButton btnAnnihilate;
    private javax.swing.JButton btnNextRound;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> cbxAnnihilateCode;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnlAfter;
    private javax.swing.JPanel pnlBefore;
    private javax.swing.JPanel pnlGraphs;
    private javax.swing.JTextField txfUploadGraph;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAnnihilate() {
        return btnAnnihilate;
    }

    public void setBtnAnnihilate(JButton btnAnnihilate) {
        this.btnAnnihilate = btnAnnihilate;
    }

    public JButton getBtnAnnihilateSimulation() {
        return btnNextRound;
    }

    public void setBtnAnnihilateSimulation(JButton btnAnnihilateSimulation) {
        this.btnNextRound = btnAnnihilateSimulation;
    }

    public JButton getBtnUpload() {
        return btnUpload;
    }

    public void setBtnUpload(JButton btnUpload) {
        this.btnUpload = btnUpload;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JPanel getPnlAfter() {
        return pnlAfter;
    }

    public void setPnlAfter(JPanel pnlAfter) {
        this.pnlAfter = pnlAfter;
    }

    public JPanel getPnlBefore() {
        return pnlBefore;
    }

    public void setPnlBefore(JPanel pnlBefore) {
        this.pnlBefore = pnlBefore;
    }

    public JPanel getPnlGraphs() {
        return pnlGraphs;
    }

    public void setPnlGraphs(JPanel pnlGraphs) {
        this.pnlGraphs = pnlGraphs;
    }

    public JTextField getTxfUploadGraph() {
        return txfUploadGraph;
    }

    public void setTxfUploadGraph(JTextField txfUploadGraph) {
        this.txfUploadGraph = txfUploadGraph;
    }

    public JComboBox<String> getCbxAnnihilateCode() {
        return cbxAnnihilateCode;
    }

    public JButton getBtnNextRound() {
        return btnNextRound;
    }
}
