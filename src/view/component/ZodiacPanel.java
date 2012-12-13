/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Zodiac;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A panel amire a csillagjegy objektum kerül majd
 * Egy "Visible" interface-el ellátott objektumot vár el
 * A panelen lévő cimkére a csillagjegy képe kerül
 * 
 * @author Norrecito
 */
public class ZodiacPanel extends JPanel {
    
    /*
     * A panelre kerülő Visible interface-el ellátott objektum 
     */
    private Visible zodiac;
    
    /*
     * A panelre kerülő címke, ami egy ikont fog tartalmazni
     */
    private final JLabel lbZodiac;
    
    /*
     * Konstruktor
     */
    public ZodiacPanel(Visible zodiac){
        
        this.zodiac = zodiac;
        lbZodiac = new JLabel(zodiac.getIcon());
        add(lbZodiac);
    
    }
    
    /*
     * Visszaadja a panelen lévő Visible interface-el ellátott objektumot
     */
    public Visible getZodiac() {
        return zodiac;
    }
    
    
    
}
