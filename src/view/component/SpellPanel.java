/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.BattleMaster;
import game.Rune;
import game.RuneList;
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
     * A varázslat eredeti ereje 
     */
    private int defaultPower;
    
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
        defaultPower = spell.getPower();
       
        initComponents(); //Komponensek inicializálása
        initPanel(); //Panel inicializálása
    }

    private void initPanel() {
        setLayout(new BorderLayout()); //Panel elrendezésének beállítása
        setBorder(BorderFactory.createLineBorder(Color.black)); //Panel keretének beállítása
        setBackground(Color.LIGHT_GRAY);
        
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
            
            RuneList charrunes = BattleMaster.getActiveCharacter().getRunes();
            List<Rune> spellrunes = spell.getRUNES();
            
            for(int i =0; i<charrunes.size(); i++){
                
                for(int j=0; j<spellrunes.size(); j++){
                    if(charrunes.get(i) == spellrunes.get(j)){
                        BufferedImage bufferedimage = (BufferedImage) spellrunes.get(j).getActivatedIcon().getImage();
                        BufferedImage resizedImage = Scalr.resize(bufferedimage, 25);
                        ImageIcon resizedIcon = new ImageIcon(resizedImage);
                        requirements.get(j).setIcon(resizedIcon);
                        System.out.println("Ikon lecserélve!");
                    }
                }
            }
            System.out.println("Varázslatpanel "+spell.getNAME()+" frissitve "+BattleMaster.getActiveCharacter().getName()+" számára!");
        }
        checkSpellState();
    }
    
    /**
     * Leellenőrzi, hogy a hős birtokolja-e a varázslathóz szükséges rúnákat.
     * Amennyiben igen, engedélyezi a varázslat használatát a játékos számára,
     * ha pedig nem (például már elhasználta a szükséges rúnákat egy másik varázslatra),
     * akkor letíltja a varázslat használatát.
     */
    private void checkSpellState(){
        boolean criteria = BattleMaster.getActiveCharacter().getRunes().containsAll(spell.getRUNES());
        
        setEnabled(criteria);
        setBackground((criteria) ? Color.GREEN : Color.LIGHT_GRAY);
    }
    
    /**
     * Beállítja a varázslat erejét mutató címke betüszínét.
     * Amennyiben a varázslat ereje nagyobb mint a varázslat eredeti ereje volt (tehát valamilyen bonusz hatására megnőtt),
     * a címke betüszíne zöldre vált. Amennyiben a varázslat ereje kisebb mint az eredeti ereje volt (tehát valamilyen büntetés miatt lecsökkent),
     * a címke betüszíne pirosra vált. Ha egyik kivétel se teljesül akkor a betűszín a fehér lesz.
     */
    private void checkPowerColor(){
        lbPower.setForeground((spell.getPower() > defaultPower) ? Color.GREEN : (spell.getPower() == defaultPower) ? Color.WHITE : Color.RED);
    }
        
}
