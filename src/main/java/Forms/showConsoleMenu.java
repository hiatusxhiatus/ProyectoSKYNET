
package Forms;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class showConsoleMenu extends javax.swing.JFrame {

    public showConsoleMenu() {
        initComponents();
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaEulerianPath = new javax.swing.JTextArea();
        btnAccept = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        txaEulerianPath.setBackground(new java.awt.Color(255, 255, 255));
        txaEulerianPath.setColumns(20);
        txaEulerianPath.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txaEulerianPath.setForeground(new java.awt.Color(0, 0, 0));
        txaEulerianPath.setRows(5);
        txaEulerianPath.setText("dfghdfg");
        jScrollPane4.setViewportView(txaEulerianPath);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(20, 60, 440, 360);

        btnAccept.setBackground(new java.awt.Color(51, 0, 153));
        btnAccept.setFont(new java.awt.Font("Pixel NES", 0, 12)); // NOI18N
        btnAccept.setForeground(new java.awt.Color(255, 255, 255));
        btnAccept.setText("Accept");
        jPanel1.add(btnAccept);
        btnAccept.setBounds(342, 440, 130, 30);

        jLabel2.setFont(new java.awt.Font("Pixel NES", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Eulerian Path");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 16, 240, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgBefore.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 480, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txaEulerianPath;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAccept() {
        return btnAccept;
    }

    public JTextArea getTxaEulerianPath() {
        return txaEulerianPath;
    }

    

}
