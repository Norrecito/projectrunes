/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import resource.RM;

/**
 * Az ablakhóz tartozó "panel" komponens, ami képes egy képet megjeleníteni annak háttereként
 * 
 * @author Norrecito
 */
public abstract class AbstractPanel extends JPanel {
    
    /*
     * A háttérkép referenciája
     */
    private Image img;
    
    /*
     * Konstruktor
     */
    public AbstractPanel() {
        
        img = createBackgroundImage();
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        
    }
    
    /*
     * Visszadja a panel hátterét
     */
    protected Image createBackgroundImage() {
        return RM.getDefaultBackgroundImage();
 }
    
    /*
     * A "paintComponent" metódus felülírása, hogy kirajzolja a képet a panel háttereként
     */
    @Override
    public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
    }
    
}
