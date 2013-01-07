/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import game.Element;
import game.Zodiac;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
     * A jelenleg kiválasztott Csillagjegy referenciája
     */
    Zodiac currentZodiac;
    
    /*
     * Az elemeket tartalmazó lista
     */
    private JList lsElements = new JList(Element.createPanels().toArray()){
        {
            addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    
                    if(!e.getValueIsAdjusting()){
                        setElementInformation((IconPanel) getSelectedValue());
                        setZodiacs((IconPanel) getSelectedValue());
                    }
                    
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
    private JList lsZodiac = new JList(listModell){
        {
            addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(!e.getValueIsAdjusting()) setZodiacInformation((IconPanel) getSelectedValue());
                }
            });
        }
    };
    
    /*
     * Az Elemek listáját tartalmazó panel
     */
    private JPanel pnElementSelection = new JPanel(){
        {
            add(lsElements); //Elem lista hozzáadása
        }
    };
    
    /*
     * A Csillagjegyek listáját tartalmazó panel
     */
    private JPanel pnZodiacSelection = new JPanel(){
        {
            setBackground(Color.black); //Háttérszín beállítása
            setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)); //szegély beállítása
            setPreferredSize(new Dimension(275,150));
            
            add(lsZodiac); //Csillagjegy lista hozzáadása
            
        }
    };
    
    /*
     * Az Elemmelvkapcsolatos információkat megjelenítő panel referenciája
     */
    private InformationPanel ipElement;
    
    /*
     * A Csillagjeggyel kapcsolatos információkat megjelenítő panel referenciája
     */
    private InformationPanel ipZodiac;
    
    /*
     * Konstruktor
     */
    public SelectionPanel(InformationPanel element, InformationPanel zodiac){
        
        ipElement = element;
        ipZodiac = zodiac;
        
        initComponents(); //komponensek inicializálása
        initPanel(); //panel inicializálása
    }
    
    
    private void initPanel(){
        
        setOpaque(false); //A panel legyen átlátszó
        setPreferredSize(new Dimension(240,170)); //Maximum méret beállítása
        setLayout(new BorderLayout()); //Panel elrendezésének beállítása
        
        //Elemek hozzáadása a panelhez
        add(pnElementSelection, BorderLayout.NORTH);
        add(pnZodiacSelection, BorderLayout.CENTER);
        
        
    }
    
    private void initComponents(){
        
        pnElementSelection.setBorder(BorderFactory.createLineBorder(new Color(181,166,66), 3));
        pnElementSelection.setBackground(Color.black);
        pnElementSelection.setPreferredSize(new Dimension(275,75));
        
        
       
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
        
        
        listModell.clear();
        
        
        List<IconPanel> pl = ((Element) panel.getVisible()).getZodiacList().createPanels();
        IconPanel[] ps = new IconPanel[pl.size()];
        
        for(int i=0; i<pl.size(); i++){
            listModell.addElement(pl.get(i));
        }
      
    }
    
    /*
     * Beállítja a kiválasztott Elem leírását a hozzátartozó panelre
     */
    private void setElementInformation(IconPanel panel){
        if(!lsElements.isSelectionEmpty()) ipElement.setContent(panel.getVisible());
    }
    
    /*
     * Beállítja a kiválasztott Csillagjegy leírását a hozzátartozó panelre
     */
    private void setZodiacInformation(IconPanel panel){
        
        if(!lsZodiac.isSelectionEmpty()){
            ipZodiac.setContent(panel.getVisible());
            currentZodiac = (Zodiac) panel.getVisible();
        }
    }
    
    /*
     * Visszaadja a jelenleg kiválasztott csillagjegyet
     */
    public Zodiac getCurrentZodiac() {
        return currentZodiac;
    }
    
    /*
     * Visszaadja a Csillagjegyeket tároló listát
     */
    public JList getLsZodiac() {
        return lsZodiac;
    }
    
}
