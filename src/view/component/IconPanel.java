/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Norrecito
 */
public class IconPanel extends JPanel {
    
    /*
     * A panelre kerülő Visible interface-el ellátott objektum 
     */
    private Visible visible;
    
    /*
     * A panelre kerülő címke, ami egy ikont fog tartalmazni
     */
    private final JLabel lbIcon;
    
    /*
     * Konstruktor
     */
    public IconPanel(Visible visible){
        
        this.visible = visible;
        lbIcon = new JLabel(visible.getIcon());
        add(lbIcon);
    
    }
    
    /*
     * Visszaadja a panelen lévő Visible interface-el ellátott objektumot
     */
    public Visible getVisible() {
        return visible;
    }
    
}
