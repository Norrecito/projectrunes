/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import resource.RM;

/**
 *
 * A játékos karakter illetve az ellenfél paneljének osztálya
 * Információt jelenít meg a user számára (Életerő, statisztika, képességek, varázslatok)
 * A rúna tábla bal illetve jobb oldalán helyezkedik el (Játékos-ellenfél)
 * 
 * @author Norrecito
 */
public class SidePanel extends JPanel {
    
    /*
     * A megjelenítendő elem referenciája
     */
    private Character character;
    
    /*
     * Az avatart tároló cimke
     */
    private final JLabel lbAvatar = new JLabel();
    
    /*
     * A varázserőt tároló cimke
     */
    private JLabel lbSpellpower = new JLabel(RM.getSpellpowerIcon(), SwingConstants.LEFT);
    
    /*
     * Az ellenállást tároló cimke
     */
    private JLabel lbResistance = new JLabel(RM.getResistanceIcon(), SwingConstants.LEFT);
    
    /*
     * A kritikus esélyt tároló cimke
     */
    private JLabel lbCritical = new JLabel(RM.getCriticalIcon(), SwingConstants.LEFT);
    
    /*
     * A képességeket mutató 3 cimke
     */
    private JLabel lbSkill1 = new JLabel(RM.getBlankSkillIcon());
    private JLabel lbSkill2 = new JLabel(RM.getBlankSkillIcon());
    private JLabel lbSkill3 = new JLabel(RM.getBlankSkillIcon());
    
    /*
     * Az életerőt mutató állapotjelző csík
     */
    private JProgressBar pbHP = new JProgressBar();
    
    /**
     * A varázslat férőhelyeket tároló tömb
     */
    private JPanel spellSlots[] = new JPanel[4];
    
    /*
     * Az avatart tároló panel
     */
    private final JPanel pnAvatar = new JPanel(){
        {
            setBorder(BorderFactory.createLineBorder(Color.black));
            add(lbAvatar);
        }
    };
    
    /*
     * A statisztikát (Varázserő, védelem) mutató panel
     */
    private final JPanel pnStat = new JPanel(){
        {
            setLayout(new FlowLayout()); //panel elrendezésének beállítása
            setBorder(BorderFactory.createLineBorder(Color.black));
            add(lbSpellpower); //"Varázserő" cimke hozzáadása
            add(lbResistance); //"Ellenállás" cimke hozzáadása
            add(lbCritical); //"Kritikus esély" cimke hozzáadása
        }
    };
    
    /*
     * A képességeket (csillagjegy skillek) mutató panel 
     */
    private final JPanel pnSkill = new JPanel(){
        {
           setLayout(new FlowLayout()); //panel elrendezésének beállítása
           setBorder(BorderFactory.createLineBorder(Color.black));
           add(lbSkill1);
           add(lbSkill2);
           add(lbSkill3);
        }
    };
    
    /**
     * A varázslatokat mutató panel
     */
    private final JPanel pnSpell = new JPanel(){
        {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createLineBorder(Color.black));
            
            Box box = Box.createVerticalBox();
            
            for(int i =0; i<4; i++){
                JPanel spellSlot = new JPanel();
                spellSlot.setLayout(new BorderLayout());
                box.add(spellSlot);
                spellSlots[i] = spellSlot;
            }
            add(box);
        }   
    };
    
    /*
     * A konstruktor
     * egy "Megjeleníthető" (Displayable) interface-el ellátot objektumot (Hős, Ellenfél) vár paraméterként,
     * és automatikusan beállítja a nézetet hozzá
     */
     public SidePanel(Character character){
         
         this.character = character;
         
         //Cimkék beállítása
         lbAvatar.setIcon(character.getAvatar().getIcon());
         lbSpellpower.setText(Integer.toString(character.getSpellpower()));
         lbResistance.setText(Integer.toString(character.getResistance()));
         lbCritical.setText(Integer.toString(character.getCritical()));
         
         initComponents(); //Komponensek inicialízálása
         initPanel(); //Panel inicialízálása
         
     }

    private void initComponents() {
        
        //Teszt
        pbHP.setStringPainted(true);
        pbHP.setString(Integer.toString(character.getHp())+"/"+Integer.toString(character.getHp()));
        pbHP.setMinimum(0);
        pbHP.setMaximum(character.getHp());
        pbHP.setValue(character.getHp());
        
        Dimension size = new Dimension(40,25);
        lbSpellpower.setPreferredSize(size);
        lbResistance.setPreferredSize(size);
        lbCritical.setPreferredSize(size);
        
        //Varázslatok felrakása a felületre
        
        for(int i =0; i<character.getSpells().size(); i++){
                JPanel slot = spellSlots[i];
                SpellPanel spell = new SpellPanel(character.getSpells().get(i));
                slot.add(spell);  
            }
            
    }

    private void initPanel() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); //Panel elrendezésének beállítása
        
        Box box = Box.createVerticalBox(); //Tároló "doboz" létrehozása
        
        box.add(pnAvatar);
        box.add(pbHP);
        box.add(pnStat);
        box.add(pnSkill);
        box.add(pnSpell);
        
        add(box);
    }
    
    /**
     * @return a panelen lévő karaktert
     */
    public Character getCharacter() {
        return character;
    }
    
}
