/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Spell;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 * A panel amin a varázskönyv listáiban a varázslatok kerülnek.
 * 
 * @author Norrecito
 */
public class SpelllistPanel extends JPanel {
    
    /**
     * A varázslat ami éppen a panelen van
     */
    private final Spell spell;
    
    /**
     * Jelenleg ki van-e választva a varázslat (benne van-e a játékos karakter varázslatlistájában)
     */
    private boolean equipped=false;
    
    /**
     * A varázslat szintkövetelményét megjelenítő cimke
     */
    private final JLabel lbLevel = new JLabel();
    
    /**
     * A varázslat nevét megjelenítő cimke
     */
    private final JLabel lbName = new JLabel();
    
    /**
     * A varázslat típusát megjelenítő cimke
     */
    private final JLabel lbType = new JLabel();
    
    /**
     * A varázslat kiválasztására lehetőséget adó checkbox
     */
    private JCheckBox cbEquip = new JCheckBox();
    
    /**
     * A panel amire a varázslathóz szükséges rúnák kerülnek
     */
    private JPanel pnRunes;
    
    /**
     * Konstruktor
     */
    public SpelllistPanel(Spell s){
       this.spell = s;
        
       initComponents(); //Komponensek inicializálása
       initPanel(); //Panel inicializálása
    }

    private void initComponents() {
        
        lbLevel.setText(String.valueOf(spell.getLEVEL())+". szint");
        lbLevel.setForeground(Color.black);
        lbLevel.setPreferredSize(new Dimension(50,25));
        
        lbName.setText(spell.getNAME());
        lbName.setForeground(spell.getELEMENT().getColor());
        lbName.setPreferredSize(new Dimension(100,25));
        
        lbType.setText(spell.getTYPE().getName());
        lbType.setForeground(spell.getTYPE().getColor());
        lbType.setPreferredSize(new Dimension(70,25));
        
        pnRunes = spell.getRUNESOnPanel();
        
    }

    private void initPanel() {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS)); //Panel elrendezésének beállítása
        
        Box box = Box.createHorizontalBox();
        Dimension separator = new Dimension(10,0);
        
        box.add(cbEquip);
        box.add(Box.createRigidArea(separator));
        box.add(lbLevel);
        box.add(Box.createRigidArea(separator));
        box.add(lbName);
        box.add(Box.createRigidArea(separator));
        box.add(lbType);
        box.add(Box.createRigidArea(separator));
        box.add(pnRunes);
        
        add(box);
    }
    
    /**
     * @return a panelen lévő varázslatot 
     */
    public Spell getSpell() {
        return spell;
    }
    
    /**
     * @return a checkboxot ami jelzi a user számára hogy memorizálva van-e jelenleg a varázslat
     */
    public JCheckBox getCheckBox() {
        return cbEquip;
    }
    
}
