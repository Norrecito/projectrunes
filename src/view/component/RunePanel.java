/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.BattleMaster;
import game.Rune;
import java.awt.event.MouseAdapter;
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
    private MouseListener listener = new MouseAdapter() {

       @Override
        public void mouseReleased(MouseEvent e) {
            activateRune();
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
     * Aktiválja a panelen lévő rúnát ha még nem aktív
     */
    public void activateRune(){
       
       if(!activated){
           activated=true;
           lbIcon.setIcon(rune.getActivatedIcon());
           BattleMaster.addRune(rune);
       } 
    }
    
}
