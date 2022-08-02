package backend;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Casa extends JButton{
    private boolean bomb = false;
    private boolean flag = false;
    private int nbombs;
    private int x;
    private int y;
    public Timer t;

    public Casa(String label, int x, int y, GameManager gm){
        super(label);
        this.x = x;
        this.y = y;

        this.setPreferredSize(new Dimension(37, 37));
        this.setMaximumSize(new Dimension(37, 37));
        this.setMinimumSize(new Dimension(37, 37));
        this.setFont(new java.awt.Font("Dialog", 1, 15));
        this.setBackground(new java.awt.Color(235, 235, 235));
        this.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            
            Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    click(evt, gm);
                } catch (LineUnavailableException e) {
                // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        
        
        Thread t = new Thread(r);
        t.start();
            
            
        }
        });
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getNbombs() {
        return nbombs;
    }

    public void setNbombs(int nbombs) {
        this.nbombs = nbombs;
    }
    
    private void gameover(GameManager gm) throws InterruptedException, LineUnavailableException {
        
            this.setText("");
            this.setIcon(new ImageIcon("res/bomb.png"));
            this.setEnabled(false);
            File death = new File("res/death.wav");
            AudioInputStream as;
        for(int i = 0; i < gm.bombasM.size(); i++) {
            try{
                as = AudioSystem.getAudioInputStream(death);
                Clip c = AudioSystem.getClip();
                c.open(as);
                c.start();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            gm.bombasM.get(i).setText("");
            gm.bombasM.get(i).setIcon(new ImageIcon("res/bomb.png"));
            gm.bombasM.get(i).setEnabled(false);
            Thread.currentThread().sleep(300);
        }
        JOptionPane.showMessageDialog(null, "BOOM", "Game over!", JOptionPane.WARNING_MESSAGE);
        GameManager.switchWindows();
        Thread.currentThread().stop();
    }

    public void click(MouseEvent evt, GameManager gm) throws LineUnavailableException{
        if(!gm.gameOver) {    
            if(evt.getButton() == MouseEvent.BUTTON1 && isEnabled()) {
                lClick(gm);
            } else if(evt.getButton() == MouseEvent.BUTTON3 && isEnabled()) {
                if(!flag) {
                    this.setFlag(true);
                    this.setText("");
                    this.setIcon(new ImageIcon("res/flag.png"));
                    gm.contaFlags++;
                } else {
                    this.setFlag(false);
                    this.setIcon(null);
                    this.setText(" ");
                    gm.contaFlags--;
                }
                GameManager.g.jTextFieldNBombas.setText(Integer.toString(gm.bombas - gm.contaFlags));
            }else if(evt.getButton() == MouseEvent.BUTTON2) {
                checkFlag(gm.matriz, x, y, gm);
            }
        }
    }

    private void lClick(GameManager gm) throws LineUnavailableException {    
        if (bomb) {
            gm.gameOver = true;
            GameManager.g.time.stop();

            Runnable rGameOver = new Runnable() {
                @Override
                public void run() {
                    try {
                        gameover(gm);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            
            Thread tGameOver = new Thread(rGameOver);
            tGameOver.start();
        }else if (isEnabled()){
            if (isFlag()) {
                setText(" ");
                gm.contaFlags--;
                this.setIcon(null);
                GameManager.g.jTextFieldNBombas.setText(Integer.toString(gm.bombas - gm.contaFlags));
            }
            setEnabled(false);
            gm.contaClicks++;
            checkBomba(gm.matriz, x, y, gm);
        }
        if (gm.checkVitoria()) {
            gm.bombas = 0;
            File f = new File("res/victory.wav");
            AudioInputStream as;
            try {
                as = AudioSystem.getAudioInputStream(f);
                Clip c = AudioSystem.getClip();
                c.open(as);
                c.start();
            } catch (UnsupportedAudioFileException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            GameManager.g.time.stop();
            JOptionPane.showMessageDialog(null, "PARABENS", "Vitoria", JOptionPane.OK_OPTION);
            GameManager.switchWindows();
        }
    }


    public void checkBomba(ArrayList<ArrayList<Casa>> a, int x, int y, GameManager gm){
        boolean found = false;
        this.nbombs = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(x + j > (gm.size - 1) || x + j < 0 || y + i > (gm.size - 1) || y + i < 0)) {
                    if (!(i == 0 && j == 0) && a.get(x + j).get(y + i).isBomb()) {
                        found = true;
                        nbombs++;
                    }
                }
            }
        }
        if (!found) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (!(x + j > (gm.size - 1) || x + j < 0 || y + i > (gm.size - 1) || y + i < 0)) {
                        if (!(i == 0 && j == 0) && a.get(x + j).get(y + i).isEnabled()) {
                            try {
                                a.get(x + j).get(y + i).lClick(gm);
                            } catch (LineUnavailableException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }   
                    }
                }
            }
        }else{
            if (getText() == " ") {
                setText("" + nbombs);
            }
        }   
    }

    public void checkFlag(ArrayList<ArrayList<Casa>> a, int x, int y, GameManager gm){
        int nflags = 0;
        this.nbombs = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(x + j > (gm.size - 1) || x + j < 0 || y + i > (gm.size - 1) || y + i < 0)) {
                    if (!(i == 0 && j == 0) && a.get(x + j).get(y + i).isFlag()) {  
                        nflags++;
                    }
                    if (!(i == 0 && j == 0) && a.get(x + j).get(y + i).isBomb()) {
                        nbombs++;
                    }
                }
            }
        }
        if (nflags == nbombs) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (!(x + j > (gm.size - 1) || x + j < 0 || y + i > (gm.size - 1) || y + i < 0)) {
                        if (!(i == 0 && j == 0) && !a.get(x + j).get(y + i).isFlag()) {  
                            try {
                                a.get(x + j).get(y + i).lClick(gm);
                            } catch (LineUnavailableException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Casa [x=" + x + ", y=" + y + "]";
    }

    
    
}