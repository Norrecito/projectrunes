/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Rune;
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
     * A rúna ikonját tároló cimke
     */
    private JLabel lbIcon = new JLabel();
    
    /*
     * Konstruktor
     */
    public RunePanel(Rune rune){
       
        this.rune = rune;
        lbIcon.setIcon(rune.getIcon()); //A cimke beállítása
        add(lbIcon);
        
    }
    
    /*
     * Visszaadja a rúnát amit éppen a panel megjelenít
     */
    public Rune getRune() {
        return rune;
    }
    
}
