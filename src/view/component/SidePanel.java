/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.C;
import game.Spell;
import java.awt.Color;
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
    private Displayable displayable;
    
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
    
    /*
     * A varázslatokat mutató panel
     */
    private final JPanel pnSpell = new JPanel(){
        {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createLineBorder(Color.black));
            
            Box box = Box.createVerticalBox();
            
            for(int i =0; i<4; i++){
                SpellPanel spell = new SpellPanel(Spell.values()[C.createRandom(0, Spell.values().length-1)]);
                box.add(spell);  
            }
            
            add(box);
        }   
    };
    
    /*
     * A konstruktor
     * egy "Megjeleníthető" (Displayable) interface-el ellátot objektumot (Hős, Ellenfél) vár paraméterként,
     * és automatikusan beállítja a nézetet hozzá
     */
     public SidePanel(Displayable displayable){
         
         this.displayable = displayable;
         
         //Cimkék beállítása
         lbAvatar.setIcon(displayable.getAvatar().getIcon());
         lbSpellpower.setText(Integer.toString(displayable.getSpellpower()));
         lbResistance.setText(Integer.toString(displayable.getResistance()));
         lbCritical.setText(Integer.toString(displayable.getCritical()));
         
         initComponents(); //Komponensek inicialízálása
         initPanel(); //Panel inicialízálása
         
     }

    private void initComponents() {
        
        //Teszt
        pbHP.setStringPainted(true);
        pbHP.setString(Integer.toString(displayable.getHp())+"/"+Integer.toString(displayable.getHp()));
        pbHP.setMinimum(0);
        pbHP.setMaximum(displayable.getHp());
        pbHP.setValue(displayable.getHp());
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
    
}
