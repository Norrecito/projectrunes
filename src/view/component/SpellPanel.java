/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Rune;
import game.Spell;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.List;
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
    
    /**
     * A varázslat ami jelenleg a panelen van
     */
    private Spell spell;
    
    /**
     * A varázslat nevét mutató cimke
     */
    private JLabel lbName = new JLabel();
    
    /**
     * A varázslat erejét mutató cimke
     */
    private JLabel lbPower = new JLabel();
    
    /**
     * A varázslathóz szükséges rúnákat mutató panel
     */
    private JPanel pnRequirements = new JPanel(){
        {
        setLayout(new FlowLayout()); //Panel elrendezésének beállítása
        setOpaque(false); //Legyen átlátszó a panel
        }
    };
    
    /*
     * Konstruktor
     * Egy varázslatot fog majd várni és annak tulajdonságait/követelményeit jeleníti meg a felhasználó számára
     * Egyenlőre Teszt jellegü
     */
    public SpellPanel(Spell s){
        
        this.spell = s;
        
        initComponents(); //Komponensek a inicializálása
        initPanel(); //Panel inicializálása
    }

    private void initPanel() {
        setLayout(new BorderLayout()); //Panel elrendezésének beállítása
        setBorder(BorderFactory.createLineBorder(Color.black)); //Panel keretének beállítása
        
        add(lbName, BorderLayout.WEST);
        add(lbPower, BorderLayout.EAST);
        add(pnRequirements, BorderLayout.SOUTH);
    }

    private void initComponents() {
        lbName.setText(spell.getNAME());
        lbName.setForeground(spell.getELEMENT().getColor());
        lbPower.setText("Erő: "+String.valueOf(spell.getPower())+"%");
        
        List<Rune> runes = spell.getRUNES();
        for(int i=0; i<runes.size(); i++){
            
            Rune rune = runes.get(i);
            BufferedImage image = (BufferedImage) rune.getIcon().getImage();
            BufferedImage scaledImage = Scalr.resize(image, 25);
            
            pnRequirements.add(new JLabel(new ImageIcon(scaledImage)));
            
        }
    }
    
}