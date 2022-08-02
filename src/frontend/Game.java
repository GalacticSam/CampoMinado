/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.Casa;
import backend.GameManager;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Game extends javax.swing.JFrame {

    public GameManager gm;
    public Timer time;
    
    
    
    public Game(int size, int bombas, GameManager gm) throws InterruptedException {
        this.gm = gm;
        gm.bombas = bombas;
        gm.size = size;
        gm.contaFlags = 0;
        gm.contaClicks = 0;
        gm.matriz = new ArrayList<>();
        gm.gameOver = false;
        initComponents();
        jPanelMain.setLayout(new GridLayout(size, size));
       
        for (int i = 0; i < size; i++) {
            gm.matriz.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                gm.matriz.get(i).add(new Casa(" ", i, j, gm));
                jPanelMain.add(gm.matriz.get(i).get(j));
            }
        }
        pack();
        
        gm.setRandomBombs();
        
        jTextFieldNBombas.setText("" + gm.bombas);
        jLabelBombs.setIcon(new ImageIcon("res/flag.png"));
        jLabelClock.setIcon(new ImageIcon("res/stopwatch.png"));
        
        ActionListener taskPerformer = new ActionListener() {
        int timer = 0;
        @Override
        public void actionPerformed(ActionEvent evt) {
            timer++;
            
            jTextFieldTimeElapsed.setText(Integer.toString(timer));
        }
  };
        time = new Timer(1000, taskPerformer);
        time.start();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jTextFieldNBombas = new javax.swing.JTextField();
        jTextFieldTimeElapsed = new javax.swing.JTextField();
        jLabelClock = new javax.swing.JLabel();
        jLabelBombs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Campo Minado");
        setResizable(false);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        jTextFieldNBombas.setEditable(false);
        jTextFieldNBombas.setBackground(new java.awt.Color(18, 30, 49));
        jTextFieldNBombas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextFieldNBombas.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNBombas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNBombas.setAutoscrolls(false);

        jTextFieldTimeElapsed.setEditable(false);
        jTextFieldTimeElapsed.setBackground(new java.awt.Color(18, 30, 49));
        jTextFieldTimeElapsed.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextFieldTimeElapsed.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTimeElapsed.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTimeElapsed.setText("0");
        jTextFieldTimeElapsed.setToolTipText("");
        jTextFieldTimeElapsed.setAutoscrolls(false);
        jTextFieldTimeElapsed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimeElapsedActionPerformed(evt);
            }
        });

        jLabelClock.setText(" ");

        jLabelBombs.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBombs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNBombas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldTimeElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNBombas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTimeElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBombs, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTimeElapsedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimeElapsedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimeElapsedActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBombs;
    private javax.swing.JLabel jLabelClock;
    private javax.swing.JPanel jPanelMain;
    public javax.swing.JTextField jTextFieldNBombas;
    public javax.swing.JTextField jTextFieldTimeElapsed;
    // End of variables declaration//GEN-END:variables
}
