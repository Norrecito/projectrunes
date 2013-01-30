/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private DefaultListModel modelOffensize = new DefaultListModel();
    
    /**
     * Az Defenzív varázslatok listájáhóz tartozó lista model
     */
    private DefaultListModel modelDefensize = new DefaultListModel();
    
    /**
     * Az Offenzív (Támadó) varázslatokat tároló lista
     */
    private JList lsOffensive=new JList(modelOffensize);
    
    /**
     * A Defenzív (Védekező) varázslatokat tároló lista
     */
    private JList lsDefensive=new JList(modelDefensize);
    
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
            add(lsOffensive);
        }
    };
    
    /**
     * A Defenzív varázslatok listáját tároló panel
     */
    private JPanel pnDefensive = new JPanel(){
        {
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
    
    public SpellbookPanel(){
        
        initComponents(); //Komponensek a inicializálása
        initPanel(); //Panel inicializálása
    }

    private void initComponents() {
        
    }

    private void initPanel() {
       setLayout(new BorderLayout()); //Panel elrendezésének beállítása
       setBorder(new EmptyBorder(new Insets(20, 60, 20, 60))); //Margó beállítása
       
       add(pnText, BorderLayout.NORTH);
       add(tbLists, BorderLayout.CENTER);
       add(pnButtons, BorderLayout.SOUTH);
    }
}
