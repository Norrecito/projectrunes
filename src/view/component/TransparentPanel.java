/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Egy részlegesen átlátszó panel a karakter statisztikák mutatására
 * 
 * @author Norrecito
 */
public class TransparentPanel extends JPanel {
    
    /*
     * Konstruktor
     */
    public TransparentPanel()
    {
        super();
        setLayout(null);
        setOpaque(false);
    }
    
    /*
     * paintComponent felülírása, hogy a panel részlegesen átlátszó háttérrel rendelkezzen
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color ppColor = new Color(255,255,255, 100); //r,g,b,alpha
        g.setColor(ppColor);
        g.fillRect(0,0,260,500); //x,y,width,height
    }    
}
