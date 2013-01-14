/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Rune;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A rúnatábla rúnáinak megjelenítő panelje
 * 
 * @author Norrecito
 */
public class RunePanel extends JPanel {
    
    /*
     * A rúna amit megjelenít a panel
     */
    private Rune rune;
    
    /*
     * Aktiválva van-e a panelen lévő rúna
     */
    private boolean activated=false;
    
    /*
     * A rúna ikonját tároló cimke
     */
    private JLabel lbIcon = new JLabel();
    
    /*
     * A egérkattintás figyelő
     */
    private MouseListener listener = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            ;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            ;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            activateRune();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ;
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ;
        }
    };
    
    /*
     * Konstruktor
     */
    public RunePanel(Rune rune){
       
        this.rune = rune;
        lbIcon.setIcon(rune.getIcon()); //A cimke beállítása
        add(lbIcon);
        
        addMouseListener(listener); //Egérkattintás figyelő hozzáadása
        
    }
    
    /*
     * Visszaadja a rúnát amit éppen a panel megjelenít
     */
    public Rune getRune() {
        return rune;
    }
    
    /*
     * Aktiválja a panelen lévő rúnát
     */
    public void activateRune(){
       
       if(!activated){
           activated=true;
           lbIcon.setIcon(rune.getActivatedIcon());
       } 
    }
    
}
