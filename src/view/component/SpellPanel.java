/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Rune;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.imgscalr.Scalr;

/**
 * Panel amire a játékos illetve nem játékos karakterek varázslata kerül
 * Feladata hogy a felhasználói felületen megmutassa a felhasználónak az adott
 * varázslathóz szükséges rúnákat, kiírja a varázslat nevét/erejét illetve
 * tájékoztassa a felhasználót arról, hogy mikor képes használni a varázslatot.
 * 
 * @author Norrecito
 */
public class SpellPanel extends JPanel {
    
    /*
     * A varázslat nevét mutató cimke
     */
    private JLabel lbName = new JLabel("<HTML><p color='#FF0000'>Tűzgolyó</p></HTML>");
    
    /*
     * A varázslat erejét mutató cimke
     */
    private JLabel lbPower = new JLabel("Erő: 100%");
    
    /*
     * A varázslathóz szükséges rúnákat mutató panel
     */
    private JPanel pnRequirements = new JPanel(){
        {
        setLayout(new FlowLayout()); //Panel elrendezésének beállítása
        //TESZT
        //Átméretezett Avatar kép elkészítése
        BufferedImage image1 = (BufferedImage) Rune.FIRE1.getIcon().getImage();
        BufferedImage image2 = (BufferedImage) Rune.FIRE2.getIcon().getImage();
        BufferedImage scaledImage1 = Scalr.resize(image1, 25);
        BufferedImage scaledImage2 = Scalr.resize(image2, 25);
        
        add(new JLabel(new ImageIcon(scaledImage1)));
        add(new JLabel(new ImageIcon(scaledImage2)));
        
        setOpaque(false); //Legyen átlátszó a panel
        }
    };
    
    /*
     * Konstruktor
     * Egy varázslatot fog majd várni és annak tulajdonságait/követelményeit jeleníti meg a felhasználó számára
     * Egyenlőre Teszt jellegü
     */
    public SpellPanel(){
        initPanel(); //Panel inicializálása
    }

    private void initPanel() {
        setLayout(new BorderLayout()); //Panel elrendezésének beállítása
        setBorder(BorderFactory.createLineBorder(Color.black)); //Panel keretének beállítása
        
        add(lbName, BorderLayout.WEST);
        add(lbPower, BorderLayout.EAST);
        add(pnRequirements, BorderLayout.SOUTH);
    }
    
}
