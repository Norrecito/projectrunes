/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Hero;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.imgscalr.Scalr;

/**
 * A panel amire a "Folytatás" panel karakterlistáján a karakterek kerülnek
 * 
 * @author Norrecito
 */
public class CharacterlistPanel extends JPanel {
    
    /*
     * A hős ami a panelen van
     */
    private final Hero hero;
    
    /*
     * A karakter avatarját tároló cimke
     */
    private final JLabel lbAvatar = new JLabel();
    
    /*
     * A karakter nevét tároló cimke
     */
    private final JLabel lbName = new JLabel();
    
    /*
     * Az elem cimkéje amibe a karakter csillagjegye tartozik
     */
    private final JLabel lbElement = new JLabel();
    
    /*
     * A karakter csillagjegyét tároló cimke
     */
    private final JLabel lbZodiac = new JLabel();
    
    /*
     * A karakter szintjét tároló cimke
     */
    private final JLabel lbLevel = new JLabel();
    
    /*
     * Konstruktor
     */
    public CharacterlistPanel(Hero hero){
        
        this.hero = hero;
        
        //Átméretezett Avatar kép elkészítése
        BufferedImage image = (BufferedImage) hero.getAvatar().getIcon().getImage();
        BufferedImage scaledImage = Scalr.resize(image, 80);
        
        //Cimkék beállítása
        lbAvatar.setIcon(new ImageIcon(scaledImage));
        lbName.setText("<html><h2 color='#FFFFFF'>"+hero.getName()+"</h2></html>");
        lbElement.setText(hero.getElement().getName());
        lbZodiac.setText(hero.getZodiac().getName());
        lbLevel.setText("<html> <p color ='#FFFFFF'>Szint: "+String.valueOf(hero.getLevel())+"</p></html>");
        
        initPanel(); //Panel inicializálása
    }

    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(new Insets(10, 10, 10, 10))); //Margó beállítása
        
        Box left = Box.createVerticalBox();
        left.add(lbAvatar);
        
        Box right = Box.createVerticalBox();
        right.add(lbName);
        right.add(lbElement);
        right.add(lbZodiac);
        right.add(lbLevel);
        
        add(left);
        add(Box.createRigidArea(new Dimension(15,0)));
        add(right);
    }
    
    /*
     * Visszaadja a hőst ami a panelen van
     */
    public Hero getHero() {
        return hero;
    }
    
}
