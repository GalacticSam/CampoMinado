package backend;

import frontend.Game;
import frontend.Menu;
import java.util.ArrayList;
import java.util.Random;

public class GameManager {

    public ArrayList<ArrayList<Casa>> matriz;
    public ArrayList<Casa> bombasM = new ArrayList<>();
    public int size = 10;
    public int bombas = 10;
    public int contaFlags = 0;
    public int contaClicks = 0;
    public boolean gameOver = false;
    public static Menu m = new Menu(new GameManager());
    public static Game g;
    
    public static void switchWindows() {
        if(m.isVisible()) {
            g.setVisible(true);
            m.setVisible(false);
        } else {
            g.dispose();
            m.setVisible(true);
        }
    }
    
    public void setRandomBombs() throws InterruptedException {
        
        bombasM.clear();
        
        for (int i = 0; i < bombas; i++) {
            Random r = new Random(System.currentTimeMillis());
            int x = r.nextInt(10000);
            int y = r.nextInt(10000);
            matriz.get(x % size).get(y % size).setBomb(true);
            if(bombasM.contains(matriz.get(x % size).get(y % size))){
                i--;
            }else{
                bombasM.add(matriz.get(x % size).get(y % size));
            }
            Thread.sleep(1);
        }
    }

    public boolean checkVitoria(){
        return contaClicks == (size * size) - bombas;
    }
    
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        m.setVisible(true);
        
    }
}