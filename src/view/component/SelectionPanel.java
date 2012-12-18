/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Element;
import game.Zodiac;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * A panel amin az elem kiválasztása, és a hozzá tartozó csillagjegy történik
 * 
 * @author Norrecito
 */
public class SelectionPanel extends JPanel {
    
    /*
     * A cardLayout-hóz tartozó panelek osztálya
     */
    public class ZodiacChooserPanel extends JPanel{
        
        private DefaultListModel listModel = new DefaultListModel();
        
        private JList lsZodiac = new JList(listModel);
        
        public ZodiacChooserPanel(Zodiac z1, Zodiac z2, Zodiac z3){
            
            //setOpaque(false);
            setBackground(Color.black);
            setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            setPreferredSize(new Dimension(275,150));
            
            lsZodiac.setCellRenderer(new ImageListCellRenderer());
            lsZodiac.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            lsZodiac.setPreferredSize(new Dimension(180,150));
            lsZodiac.setVisibleRowCount(0);
            lsZodiac.setBackground(Color.black);
            
            listModel.addElement(new ZodiacPanel(z1));
            listModel.addElement(new ZodiacPanel(z2));
            listModel.addElement(new ZodiacPanel(z3));
            
            add(lsZodiac);
            
        }
    }
    
    /*
     * Az elemek listájáhóz tartozó listamodel
     */
    private DefaultListModel listModel = new DefaultListModel(){
        {
            addElement(new ElementPanel(Element.AIR));
            addElement(new ElementPanel(Element.EARTH));
            addElement(new ElementPanel(Element.FIRE));
            addElement(new ElementPanel(Element.WATER));
        }
    };
    
    /*
     * Az elemeket tartalmazó lista
     */
    private JList lsElements = new JList(listModel);
    
    /*
     * Az elemek listáját tartalmazó panel
     */
    private JPanel pnElementSelection = new JPanel(){
        {
            add(lsElements);
        }
    };
    
    /*
     * A "kártya" panel elrendezés menedzsere
     */
    CardLayout cl = new CardLayout();
    
    /*
     * A panelek tároló panel deklarálása és a hozzá tartozó elrendezés menedzser átadása
     */
    JPanel cards = new JPanel(cl){
        {
           setPreferredSize(new Dimension(275,150));
           add("FIRE", new ZodiacChooserPanel(Zodiac.ARIES, Zodiac.LEO, Zodiac.SAGITTARIUS));  
        }
    };
    
    /*
     * Konstruktor
     */
    public SelectionPanel(){
        
        initComponents(); //komponensek inicializálása
        initPanel(); //panel inicializálása
    }
    
    
    private void initPanel(){
        
        setOpaque(false);
        setMaximumSize(new Dimension(240,170));
        setLayout(new BorderLayout()); //Panel elrendezésének beállítása
        
        add(pnElementSelection, BorderLayout.NORTH);
        add(cards, BorderLayout.CENTER);
        cl.show(cards, "FIRE");
        
    }
    
    private void initComponents(){
        
        pnElementSelection.setBorder(BorderFactory.createLineBorder(new Color(181,166,66), 3));
        pnElementSelection.setBackground(Color.black);
        pnElementSelection.setPreferredSize(new Dimension(275,80));
        
        cards.setOpaque(false);
       
        //A lista elrendezésének beállítása
        lsElements.setPreferredSize(new Dimension(240,60));
        lsElements.setCellRenderer(new ImageListCellRenderer());
        lsElements.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lsElements.setVisibleRowCount(0);
        
    }
    
}
