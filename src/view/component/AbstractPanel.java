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
import view.GameFrame;

/**
 * Az ablakhóz tartozó "panel" komponens, ami képes egy képet megjeleníteni annak háttereként
 * Az ős panel osztály, minden további panel ebből az osztályból származik le
 * 
 * @author Norrecito
 */
public abstract class AbstractPanel extends JPanel {
    
    /*
     * A háttérkép referenciája
     */
    private Image img;
    
    /*
     * A játék ablak referenciája
     */
    private GameFrame frame;
    
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
     * Beállítja a játék ablakot
     */
    public AbstractPanel setFrame(GameFrame frame) {
        this.frame = frame;
        return this;
    }

    /*
     * Visszaadja a játékablak referenciáját
     */
    public GameFrame getFrame() {
        return frame;
    }
    
    /*
     * A "paintComponent" metódus felülírása, hogy kirajzolja a képet a panel háttereként
     */
    @Override
    public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
    }
    
}
