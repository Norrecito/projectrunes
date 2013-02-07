/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.DataManager;
import game.Hero;
import game.Spell;
import game.SpellCategory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import resource.RM;

/**
 * Az aktuálisan kiválasztott hős "varázskönyvét" jeleníti meg
 * Itt választhatjuk ki melyik legyen az a 4 varázslat amit harc közben használhat
 * majd a karakterünk.
 * A varázslatokat kategoria szerint csoportosítja.
 * 
 * @author Norrecito
 */
public class SpellbookPanel extends AbstractPanel {
    
    /**
     * A varázslatpaneleket tároló lista osztálya
     * erre kerülnek fel a "varázslatok" és ebből a listából választhatjuk ki 
     * azt a pár darabot amit memorizál a karakterünk.
     */
    private class SpellList extends JList<SpelllistPanel>{
        
        /**
         * Konstruktor
         * @param model a listamodell 
         */
        public SpellList(ListModel model){
            super(model); 
            
            addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent evt){
                     if(evt.getClickCount() == 2) {   
                     changeSpellState(getSelectedValue());
                     repaint();
                     }
                }
            });
        }
    }
    
    /**
     * A "Varázskönyv" feliratot és annak ikonját tároló cimke 
     */
    private final JLabel lbText = new JLabel("<html><h1 color='#FFFFFF'>Varázskönyv (0/5)</h1></html>",RM.getSpellbookIcon(), SwingConstants.RIGHT);
    
    /**
     * Az egyjátékosmenübe visszalépést szolgáló gomb
     */
    private final JButton btBack = new JButton("Vissza",RM.getBackIcon()){
        {
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    getFrame().switchPanel(SingleplayerMenuPanel.class);
                }
            });
        }
    };
    
    /**
     * Az Offenzív varázslatok listájáhóz tartozó lista model
     */
    private DefaultListModel<SpelllistPanel> modelOffensize = new DefaultListModel<SpelllistPanel>();
    
    /**
     * Az Defenzív varázslatok listájáhóz tartozó lista model
     */
    private DefaultListModel<SpelllistPanel> modelDefensize = new DefaultListModel<SpelllistPanel>();
    
    /**
     * Az Offenzív (Támadó) varázslatokat tároló lista
     */
    private JList<SpelllistPanel> lsOffensive=new SpellList(modelOffensize);
    
    /**
     * A Defenzív (Védekező) varázslatokat tároló lista
     */
    private JList<SpelllistPanel> lsDefensive=new SpellList(modelDefensize);
    
    /**
     * Az Offenzív varázslatok listájának görgető felülete
     */
    private JScrollPane spOffensive = new JScrollPane(lsOffensive);
    
    /**
     * A Defenzív varázslatok listájának görgető felülete
     */
    private JScrollPane spDefensive = new JScrollPane(lsDefensive);
    
    /**
     * Az Offenzív varázslatok listáját tároló panel
     */
    private JPanel pnOffensive = new JPanel(){
        {
            setLayout(new BorderLayout());
            add(lsOffensive);
        }
    };
    
    /**
     * A Defenzív varázslatok listáját tároló panel
     */
    private JPanel pnDefensive = new JPanel(){
        {
            setLayout(new BorderLayout());
            add(lsDefensive);
        }
    };
    
    /**
     * A "Varázskönyv" cimkét tároló panel
     */
    private JPanel pnText = new JPanel(){
        {
            add(lbText);
            setOpaque(false);
        }
    };
    
    /**
     * A gombokat tároló panel
     */
    private JPanel pnButtons = new JPanel(){
        {
            add(btBack);
            setOpaque(false);
        }
    };
    
    /**
     * Az Offenzív és Defenzív varázslatok listáját tároló JTabbedPane
     */
    JTabbedPane tbLists = new JTabbedPane(){
        {
            addTab("Offenzív",RM.getOffensiveIcon(),pnOffensive);
            addTab("Defenzív",RM.getDefensiveIcon(),pnDefensive);
        }
    };
    
    /**
     * Konstruktor
     */
    public SpellbookPanel(){
        
        initComponents(); //Komponensek a inicializálása
        initPanel(); //Panel inicializálása
        setListContent(); //Varázslatlisták beállítása
    }

    private void initComponents() {
      //Cellrenderer beállítása
      lsDefensive.setCellRenderer(new ImageListCellRenderer(Color.WHITE, Color.LIGHT_GRAY));  
      lsOffensive.setCellRenderer(new ImageListCellRenderer(Color.WHITE, Color.LIGHT_GRAY));  
    }

    private void initPanel() {
       setLayout(new BorderLayout()); //Panel elrendezésének beállítása
       setBorder(new EmptyBorder(new Insets(20, 60, 20, 60))); //Margó beállítása
       
       add(pnText, BorderLayout.NORTH);
       add(tbLists, BorderLayout.CENTER);
       add(pnButtons, BorderLayout.SOUTH);
    }
    /**
     * Feltölti és beállítja a varázslatlistákat
     */
    private void setListContent(){
        
        List<Spell> spells = DataManager.getSelectedHero().getElement().getSpellList();
        
        for(int i=0; i<spells.size(); i++){
            if(spells.get(i).getCATEGORY() == SpellCategory.DEFENSIVE) modelDefensize.addElement(new SpelllistPanel(spells.get(i)));
            if(spells.get(i).getCATEGORY() == SpellCategory.OFFENSIVE) modelOffensize.addElement(new SpelllistPanel(spells.get(i)));
        }
        
    }
    
    /**
     * Memorizálja a kiválasztott varázslatot, illetve ha az memorizálva van már akkor kiszedi a listából.
     */
    private void changeSpellState(SpelllistPanel panel){
       
       Spell spell = panel.getSpell();
       Hero hero = DataManager.getSelectedHero(); 
       
       if(!spell.isMemorized() && (hero.getMaxSpell()>=hero.getSpells().size())) {
           panel.getCheckBox().setSelected(true);
           panel.getSpell().setMemorized(true);
           hero.getSpells().add(spell);
           System.out.println("Varázslat memorizálva: "+spell.getNAME());
       }
       else if(spell.isMemorized()){
            panel.getCheckBox().setSelected(false);
            panel.getSpell().setMemorized(false);
            hero.getSpells().remove(spell);
            System.out.println("Varázslat kiszedve a listából: "+spell.getNAME());
       }
       
    }
}
