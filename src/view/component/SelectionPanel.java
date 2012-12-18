/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Element;
import game.Zodiac;
import java.awt.*;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
            
            listModel.addElement(new IconPanel(z1));
            listModel.addElement(new IconPanel(z2));
            listModel.addElement(new IconPanel(z3));
            
            add(lsZodiac);
            
        }
    }
    
    /*
     * Az elemeket tartalmazó lista
     */
    private JList lsElements = new JList(Element.createPanels().toArray()){
        {
            addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    setZodiacs((IconPanel) getSelectedValue());
                }
            });
        }
    };
    
    /*
     * Az elemhez kapcsololdó csillagjegyeket tartalmazó lista modellje
     */
    DefaultListModel listModell = new DefaultListModel();
    
    /*
     * Az elemhez kapcsololdó csillagjegyeket tartalmazó lista 
     */
    private JList lsZodiac = new JList();
    
    /*
     * Az Elemek listáját tartalmazó panel
     */
    private JPanel pnElementSelection = new JPanel(){
        {
            setLayout(new FlowLayout());
            add(lsElements);
        }
    };
    
    /*
     * A Csillagjegyek listáját tartalmazó panel
     */
    private JPanel pnZodiacSelection = new JPanel(){
        {
            setBackground(Color.black);
            setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            setPreferredSize(new Dimension(275,150));
            
            add(lsZodiac);
            
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
           add("FIRE", pnZodiacSelection);  
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
        pnElementSelection.setPreferredSize(new Dimension(275,75));
        
        cards.setOpaque(false);
       
        //Az Elemek listájának beállításai
        lsElements.setPreferredSize(new Dimension(240,60));
        lsElements.setCellRenderer(new ImageListCellRenderer());
        lsElements.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lsElements.setVisibleRowCount(0);
        
        //A Csillagjegyek listájának beállításai
        lsZodiac.setCellRenderer(new ImageListCellRenderer());
        lsZodiac.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lsZodiac.setPreferredSize(new Dimension(180,150));
        lsZodiac.setVisibleRowCount(0);
        lsZodiac.setBackground(Color.black);
        
    }
    
    /*
     * A kiválasztott Elem alapján betölti az alsó listába az ebbe az elembe tartozó Csillagjegyeket
     */
    private void setZodiacs(IconPanel panel){
        
        lsZodiac.removeAll(); //Törölje a lista jelenlegi tartalmát
        
        List<IconPanel> pl = ((Element) panel.getVisible()).getZodiacList().createPanels();
        IconPanel[] ps = new IconPanel[pl.size()];
        
        for(int i=0; i<pl.size(); i++){
            listModell.addElement(pl.get(i));
            System.out.println(pl.get(i).getVisible().getName());
        }
        
    }
    
}
