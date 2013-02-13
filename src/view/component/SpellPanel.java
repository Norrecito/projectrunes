/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.BattleMaster;
import game.Rune;
import game.Spell;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
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
     * A varázslat követelményeinek ikonjait (a varázslathóz szükséges rúnák ikonjai) tároló lista
     */
    private List<JLabel>requirements = new ArrayList();
    
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
       
        initComponents(); //Komponensek inicializálása
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
        
        Box box = Box.createHorizontalBox();
        RuneListPanel panel = spell.getRunesPanel(false, 25);
        requirements.addAll(0,panel.getIcons());
        
        pnRequirements.add(panel);
       
    }
    
    /**
     * Frissiti a varázslat panel követelmény részében szereplő rúnák ikonját az éppen aktív karakter számára.
     * Amenyiben időközben a karakter kapott egy rúnát amire szükség van a varázslat használatáhóz,
     * akkor annak lecseréli az ikonját a panelen az "aktívált" ikonra.
     * Amennyiben időközben a karakter felhasznált egy rúnát(rúnákat) ami eddig a rúnalistájában volt,
     * akkor visszacseréli az ikont az "inaktív" változatára.
     * @param r a rúna amit ellenőrizni szeretnénk.
     * 
     * @pending a metódus további kidolgozása/optimalizálása/átírása (egyenlőre erősen teszt jellegű)
     */
    public void refreshIcons(Rune r){
        if(spell.getRUNES().contains(r)){
            
            BufferedImage image = (BufferedImage) r.getIcon().getImage();
            BufferedImage image2 = (BufferedImage) r.getActivatedIcon().getImage();
            
            BufferedImage scaledImage = Scalr.resize(image, 25);
            BufferedImage scaledImage2 = Scalr.resize(image2, 25);
            ImageIcon icon = new ImageIcon(scaledImage);
            
            ImageIcon icon2 = new ImageIcon(scaledImage2);
            
            for(int i=0; i<requirements.size(); i++){
                if(requirements.get(i).getIcon().equals(icon)){
                    requirements.get(i).setIcon(icon2);
                    System.out.println("Ikon lecserélve!");
                }
            }
            System.out.println("Varázslatpanel "+spell.getNAME()+" frissitve "+BattleMaster.getActiveCharacter().getName()+" számára!");
        }
    }
        
}
