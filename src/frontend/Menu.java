package frontend;

import backend.GameManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    GameManager gm;
    private int size;
    private int bombas;

    public Menu(GameManager gm) {
        this.gm = gm;
        initComponents();
        jPanelCustom.setVisible(false);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupDiff = new javax.swing.ButtonGroup();
        jButtonPlay = new javax.swing.JButton();
        jPanelCustom = new javax.swing.JPanel();
        jTextFieldBombas = new javax.swing.JTextField();
        jLabelBombas = new javax.swing.JLabel();
        jTextFieldTamanho = new javax.swing.JTextField();
        jLabelTamanho = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonMedium = new javax.swing.JRadioButton();
        jRadioButtonHard = new javax.swing.JRadioButton();
        jRadioButtonEasy = new javax.swing.JRadioButton();
        jRadioButtonCustom = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Campo MInado");
        setMaximumSize(new java.awt.Dimension(295, 140));
        setMinimumSize(new java.awt.Dimension(295, 140));
        setResizable(false);

        jButtonPlay.setText("Jogar!");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jTextFieldBombas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelBombas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelBombas.setText("Numero de Bombas:");

        jTextFieldTamanho.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabelTamanho.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelTamanho.setText("Tamanho do Campo: ");

        javax.swing.GroupLayout jPanelCustomLayout = new javax.swing.GroupLayout(jPanelCustom);
        jPanelCustom.setLayout(jPanelCustomLayout);
        jPanelCustomLayout.setHorizontalGroup(
            jPanelCustomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelCustomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTamanho)
                    .addComponent(jLabelBombas))
                .addGap(0, 0, 0)
                .addGroup(jPanelCustomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBombas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelCustomLayout.setVerticalGroup(
            jPanelCustomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelCustomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTamanho)
                    .addComponent(jTextFieldTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBombas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBombas)))
        );

        buttonGroupDiff.add(jRadioButtonMedium);
        jRadioButtonMedium.setText("Médio");
        jRadioButtonMedium.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jRadioButtonMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMediumActionPerformed(evt);
            }
        });

        buttonGroupDiff.add(jRadioButtonHard);
        jRadioButtonHard.setText("Difícil");
        jRadioButtonHard.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jRadioButtonHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMediumActionPerformed(evt);
            }
        });

        buttonGroupDiff.add(jRadioButtonEasy);
        jRadioButtonEasy.setSelected(true);
        jRadioButtonEasy.setText("Fácil");
        jRadioButtonEasy.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jRadioButtonEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMediumActionPerformed(evt);
            }
        });

        buttonGroupDiff.add(jRadioButtonCustom);
        jRadioButtonCustom.setText("Custom");
        jRadioButtonCustom.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jRadioButtonCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCustomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jRadioButtonEasy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonMedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonHard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCustom)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonHard)
                    .addComponent(jRadioButtonCustom)
                    .addComponent(jRadioButtonMedium)
                    .addComponent(jRadioButtonEasy))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanelCustom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPlay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCustom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPlay)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed

        if(jRadioButtonEasy.isSelected()) {
            size = 10;
            bombas = 10;
        } else if(jRadioButtonMedium.isSelected()) {
            size = 18;
            bombas = 40;
        } else if(jRadioButtonHard.isSelected()) {
            size = 24;
            bombas = 99;
        }
        
        if(jRadioButtonCustom.isSelected()) {
            if(!"".equals(jTextFieldTamanho.getText()) && !"".equals(jTextFieldBombas.getText())) {
                try { 
                    size = Integer.parseInt(jTextFieldTamanho.getText());
                    bombas = Integer.parseInt(jTextFieldBombas.getText());
                    if(size > 1 && bombas <= ((size * size) - 1) && bombas > 0) {
                        GameManager.g = new Game(size, bombas, gm);
                        GameManager.switchWindows();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro de Entrada!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro de Entrada!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } else {
            try {
                GameManager.g = new Game(size, bombas, gm);
                GameManager.switchWindows();
            } catch (InterruptedException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }   
           }
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jRadioButtonCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCustomActionPerformed
        jPanelCustom.setVisible(true);
        pack();
    }//GEN-LAST:event_jRadioButtonCustomActionPerformed

    private void jRadioButtonMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMediumActionPerformed
        jPanelCustom.setVisible(false);
        pack();
    }//GEN-LAST:event_jRadioButtonMediumActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDiff;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JLabel jLabelBombas;
    private javax.swing.JLabel jLabelTamanho;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCustom;
    public javax.swing.JRadioButton jRadioButtonCustom;
    public javax.swing.JRadioButton jRadioButtonEasy;
    public javax.swing.JRadioButton jRadioButtonHard;
    public javax.swing.JRadioButton jRadioButtonMedium;
    private javax.swing.JTextField jTextFieldBombas;
    private javax.swing.JTextField jTextFieldTamanho;
    // End of variables declaration//GEN-END:variables
}
